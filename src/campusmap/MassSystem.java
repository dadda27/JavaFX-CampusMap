/*
 * Copyright (C) 2025 dadda27
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
