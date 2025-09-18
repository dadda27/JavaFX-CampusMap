/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campusmap;

import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.Node;

/**
 * This Utility class contains the methods to solve the CampusMap exercise such as Center of Mass calculation and 
 * Average Distance calculation. These calculations are used to move the Central Point instances in the application.
 * @author dadda
 */
public class GeometryFormulas {

    private GeometryFormulas() {
    }
            
    /**
     *
     * @param node the node passed as argument for the calculation
     * @return Point2D the Geometric Center of the Node in its parent
     */
    public static final Point2D computeGeometricCenter(Node node) {
        return new Point2D(
                node.getBoundsInParent().getMinX() + node.getBoundsInParent().getWidth() / 2,
                node.getBoundsInParent().getMinY() + node.getBoundsInParent().getHeight() / 2
        );
    }
    
    /**
     *
     * @param mass the mass of a node. As an example, it can be the area of a JavaFX shape
     * @param coordinateX the translateX location
     * @return double the MomentX (mass * coordinateX)
     */
    public static double computeMomentX(double mass, double coordinateX) {
        return mass * coordinateX;
    }
    
    /**
     *
     * @param mass the mass of a node. As an example, it can be the area of a JavaFX shape
     * @param coordinateY the translateY location
     * @return double the MomentY (mass * coordinateX)
     */
    public static double computeMomentY(double mass, double coordinateY) {
        return mass * coordinateY;
    }
    
    /**
     *
     * @param weightedPointList List of WeightedPoint class (double mass, Point2D coordinates)
     * @return Point2D the Center of Mass of a WeightedPoint list
     */
    public static Point2D computeCenterOfMass2D(List<WeightedPoint> weightedPointList) {
        double totMass = 0;
        double totMomentX = 0;
        double totMomentY = 0;
        
        for(WeightedPoint weightedPoint : weightedPointList) {
            totMass += weightedPoint.getMass();
            totMomentX += weightedPoint.getCoordinates().getX() * weightedPoint.getMass();
            totMomentY += weightedPoint.getCoordinates().getY() * weightedPoint.getMass();
        }
        
        if(totMass == 0) {
            return Point2D.ZERO;
        }
        
        return new Point2D(
                totMomentX / totMass, 
                totMomentY / totMass);
    }
    
    /**
     *
     * @param point2DList List of Point2D nodes
     * @return double the average distance between a list of Point2D
     */
    public static double computeAvarageDistance2D(List<Point2D> point2DList) {
        double sumDistances = 0;
        
        /*
        * Calculate All Pairwise Distances: Use the distance formula (derived from the Pythagorean theorem)
        * to find the distance (d) between every unique pair of points: 
        * \(d=\sqrt{(x_{2}-x_{1})^{2}+(y_{2}-y_{1})^{2}}\).
        * Sums all the distances
        */
        for(int i = 0; i < point2DList.size(); i++) {
            for (int j = i + 1; j < point2DList.size(); j++) {
                sumDistances += Math.hypot(
                        point2DList.get(j).getX() - point2DList.get(i).getX(), 
                        point2DList.get(j).getY() - point2DList.get(i).getY());
            }
        }
        
        //Divide the sum of the distances by the total number of pairs 
        //to get the average point distance. this is N(N-1)/2.
        double avarageDistance = sumDistances / (point2DList.size() * (point2DList.size() - 1) / 2);

        return Math.round(avarageDistance);
    }
    
    /**
     *
     * @param point2DList List of Point2D nodes
     * @return Point2D the average X and Y location of a List of Point2D
     */
    public static Point2D computeAvarageCoordinates2D(List<Point2D> point2DList) {
        double sumX = 0;
        double sumY = 0;

        for (Point2D point2D : point2DList) {
            sumX += point2D.getX();
            sumY += point2D.getY();
        }

        return new Point2D(
                sumX / point2DList.size(), 
                sumY / point2DList.size());
    }
}
