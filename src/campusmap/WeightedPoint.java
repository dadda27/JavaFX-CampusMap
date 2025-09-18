/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
