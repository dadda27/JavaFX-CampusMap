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

import javafx.geometry.Point2D;

/**
 * This data-class only contains the Mass and Coordinates attributes of a ResidenceNode.
 * It has been created to decouple and reduce the dependency of GeometryUtil class and the ResidenceNode class in the 
 * Center of Mass and Distance calculation.
 * @author dadda
 * 
 */
public class WeightedPoint {
    private double mass;
    private Point2D coordinates;

    public WeightedPoint(double mass, Point2D coordinates) {
        this.mass = mass;
        this.coordinates = coordinates;
    }

    public double getMass() {
        return mass;
    }
    
    public void setMass(double mass) {
        this.mass = mass;
    }

    public Point2D getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point2D coordinates) {
        this.coordinates = coordinates;
    }
      
}
