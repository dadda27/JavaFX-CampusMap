/*
 * The MIT License
 *
 * Copyright 2025 dadda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package campusmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Point2D;


/**
 * This class represent a system of masses (WeightedPoint class), required for the center of mass calculation and
 * Avarage Distance calculation between masses (ResidenceNode).
 * @author dadda
 */
public class MassSystem extends ArrayList<WeightedPoint> {
    private Point2D centerOfMass;

    public MassSystem(WeightedPoint ... weightedPoints) {
        this.addAll(Arrays.asList(weightedPoints));
        centerOfMass = GeometryFormulas.computeCenterOfMass2D(Arrays.asList(weightedPoints));
    }
    
    public Point2D getCenterOfMass() {
        return centerOfMass;
    }
    
    public void refreshCenterOfMass() {
        centerOfMass = GeometryFormulas.computeCenterOfMass2D(this);
    }
    
    public List<Point2D> getCoordinates() {
        List<Point2D> coordinateList;
        coordinateList = new ArrayList<>();
        
        for(WeightedPoint weightedPoint : this) {
            coordinateList.add(weightedPoint.getCoordinates());
        }
        if( coordinateList.isEmpty()) {
            throw new UnsupportedOperationException("Cannot find any coordinates in this Mass System");
        }
        return coordinateList;
    }
    
}
