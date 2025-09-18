/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;

/**
 * Utility class that allows calculation of PathElements, such as Coordinates X and Y, longest Line (PathLineSegment) or 
 * middle coordinates of a specific Line (PathLineSegment) within a Path. 
 * MapStreet class uses this utility methods to allow graphical representation of streets inside the Map
 * @author dadda
 */
public class PathGeometryUtils {

    private PathGeometryUtils() {
    }

    /**
     * Calculates the start and end coordinates (X and Y) of a PathLineSegment.
     * This method has been created in order to later retrieve the middle, length and rotation of the PathLineSegment
     * @param index index of the PathElement
     * @param path path
     * @return double[4] the start and end coordinates [startX, startY, endX, endY] of a PathLineSegment
     */
    public static double[] computeLineSegmentCoordinates(int index, Path path) {
        if (path.getElements().get(index) instanceof LineTo) {
            return computeLinetoCoordinates(path, index);

        } else if (path.getElements().get(index) instanceof HLineTo) {
            return computeHLineToCoordinates(path, index);

        } else if (path.getElements().get(index) instanceof VLineTo) {
            return computeVLineToCoordinates(path, index);

        } else {
            throw new UnsupportedOperationException("Cannot calculate the coordinates of this LinePathSegment.\n");
        }
    }
    
    /**
     * Calculates the start and end coordinates (X and Y) of a LineTo 
     * based on its preceding PathElements.
     * @param path path 
     * @param index index of the LineTo PathElement
     * @return double[4] the start and end coordinates [startX, startY, endX, endY] of a PathLineSegment
     */
    public static double[] computeLinetoCoordinates(Path path, int index) {
        double startX = 0.0;
        double startY = 0.0;
        double endX;
        double endY;
        double[] lineSegmentCoordinates = new double[4];
        //Casts the PathElement of the index to a LineTo and gets its endX and endY
        LineTo tempLineTo = (LineTo) path.getElements().get(index);
        endX = tempLineTo.getX();
        endY = tempLineTo.getY();
        //Finds the startX and startY of the LineTo based on the previous PathElements in the Path
        for (int i = 0; i < index; i++) {
            PathElement previousPathElement = path.getElements().get(i);
            Class<? extends PathElement> pathElementClass = previousPathElement.getClass();

            if (pathElementClass.equals(MoveTo.class)) {
                MoveTo moveTo = (MoveTo) previousPathElement;
                startX = moveTo.getX();
                startY = moveTo.getY();
            } else if (pathElementClass.equals(LineTo.class)) {
                LineTo lineTo = (LineTo) previousPathElement;
                startX = lineTo.getX();
                startY = lineTo.getY();
            } else if (pathElementClass.equals(HLineTo.class)) {
                HLineTo hLineTo = (HLineTo) previousPathElement;
                startX = hLineTo.getX();
            } else if (pathElementClass.equals(VLineTo.class)) {
                VLineTo vLineTo = (VLineTo) previousPathElement;
                startY = vLineTo.getY();
            } else if (pathElementClass.equals(CubicCurveTo.class)) {
                CubicCurveTo cubiCurveTo = (CubicCurveTo) previousPathElement;
                startX = cubiCurveTo.getX();
                startY = cubiCurveTo.getY();
            } else if (pathElementClass.equals(QuadCurveTo.class)) {
                QuadCurveTo quadCurveTo = (QuadCurveTo) previousPathElement;
                startX = quadCurveTo.getX();
                startY = quadCurveTo.getY();
            } else if (pathElementClass.equals(ArcTo.class)) {
                ArcTo arcTo = (ArcTo) previousPathElement;
                startX = arcTo.getX();
                startY = arcTo.getY();
            } else {
                throw new UnsupportedOperationException("Issue calculating the coordinates of the LineTo");
            }
        }
        lineSegmentCoordinates[0] = startX;
        lineSegmentCoordinates[1] = startY;
        lineSegmentCoordinates[2] = endX;
        lineSegmentCoordinates[3] = endY;
        return lineSegmentCoordinates;
    }
 
    /**
     * Calculates the start and end coordinates (X and Y) of an HLineTo 
     * based on its preceding PathElements.
     * @param path path
     * @param index index of the HLineTo PathElement
     * @return double[4] the start and end coordinates [startX, startY, endX, endY] of a PathLineSegment
     */
    public static double[] computeHLineToCoordinates(Path path, int index) {
        double startX = 0.0;
        double startY = 0.0;
        double endX;
        double endY = 0.0;
        double[] lineSegmentCoordinates = new double[4];
        //Gets the end X of the HLineTo
        HLineTo tempHLineTo = (HLineTo) path.getElements().get(index);
        endX = tempHLineTo.getX();
        //Find Start X, Start Y and End Y of the HLineTo based on previous pathElements
        for (int i = 0; i < index; i++) {
            PathElement previousPathElement = path.getElements().get(i);
            Class<? extends PathElement> pathElementClass = previousPathElement.getClass();

            if (pathElementClass.equals(MoveTo.class)) {
                MoveTo moveTo = (MoveTo) previousPathElement;
                startX = moveTo.getX();
                startY = moveTo.getY();
                endY = moveTo.getY();
            } else if (pathElementClass.equals(LineTo.class)) {
                LineTo lineTo = (LineTo) previousPathElement;
                startX = lineTo.getX();
                startY = lineTo.getY();
                endY = lineTo.getY();
            } else if (pathElementClass.equals(HLineTo.class)) {
                HLineTo hLineTo = (HLineTo) previousPathElement;
                startX = hLineTo.getX();
            } else if (pathElementClass.equals(VLineTo.class)) {
                VLineTo vLineTo = (VLineTo) previousPathElement;
                startY = vLineTo.getY();
            } else if (pathElementClass.equals(CubicCurveTo.class)) {
                CubicCurveTo cubicCurveTo = (CubicCurveTo) previousPathElement;
                startX = cubicCurveTo.getX();
                startY = cubicCurveTo.getY();
                endY = cubicCurveTo.getY();
            } else if (pathElementClass.equals(QuadCurveTo.class)) {
                QuadCurveTo quadCurveTo = (QuadCurveTo) previousPathElement;
                startX = quadCurveTo.getX();
                startY = quadCurveTo.getY();
                endY = quadCurveTo.getY();
            } else if (pathElementClass.equals(ArcTo.class)) {
                ArcTo arcTo = (ArcTo) previousPathElement;
                startX = arcTo.getX();
                startY = arcTo.getY();
                endY = arcTo.getY();
            } else {
                throw new UnsupportedOperationException("Issue calculating the coordinates of the HLineTo");
            }
        }
        lineSegmentCoordinates[0] = startX;
        lineSegmentCoordinates[1] = startY;
        lineSegmentCoordinates[2] = endX;
        lineSegmentCoordinates[3] = endY;
        return lineSegmentCoordinates;
    }
    
    /**
     * Calculates the start and end coordinates (X and Y) of a VLineTo 
     * based on its preceding PathElements.
     * @param path path
     * @param index index of the VLineTo PathElement
     * @return double[4] the start and end coordinates [startX, startY, endX, endY] of a PathLineSegment
     */
    public static double[] computeVLineToCoordinates(Path path, int index) {
        double startX = 0.0;
        double startY = 0.0;
        double endX = 0.0;
        double endY;
        double[] lineSegmentCoordinates = new double[4];
        //Gets the end Y of the VLineTo
        VLineTo tempVLineTo = (VLineTo) path.getElements().get(index);
        endY = tempVLineTo.getY();
        //Find Start X, Start Y and End X of the VLineTo based on previous pathElements
        for (int i = 0; i < index; i++) {
            PathElement pathElement = path.getElements().get(i);
            Class<? extends PathElement> pathElementClass = pathElement.getClass();

            if (pathElementClass.equals(MoveTo.class)) {
                MoveTo moveTo = (MoveTo) pathElement;
                startX = moveTo.getX();
                startY = moveTo.getY();
                endX = moveTo.getX();
            } else if (pathElementClass.equals(LineTo.class)) {
                LineTo lineTo = (LineTo) pathElement;
                startX = lineTo.getX();
                startY = lineTo.getY();
                endX = lineTo.getX();
            } else if (pathElementClass.equals(HLineTo.class)) {
                HLineTo hLineTo = (HLineTo) pathElement;
                startX = hLineTo.getX();
            } else if (pathElementClass.equals(VLineTo.class)) {
                VLineTo vLineTo = (VLineTo) pathElement;
                startY = vLineTo.getY();
            } else if (pathElementClass.equals(CubicCurveTo.class)) {
                CubicCurveTo cubicCurveTo = (CubicCurveTo) pathElement;
                startX = cubicCurveTo.getX();
                startY = cubicCurveTo.getY();
                endX = cubicCurveTo.getX();
            } else if (pathElementClass.equals(QuadCurveTo.class)) {
                QuadCurveTo quadCurveTo = (QuadCurveTo) pathElement;
                startX = quadCurveTo.getX();
                startY = quadCurveTo.getY();
                endX = quadCurveTo.getX();
            } else if (pathElementClass.equals(ArcTo.class)) {
                ArcTo arcTo = (ArcTo) pathElement;
                startX = arcTo.getX();
                startY = arcTo.getY();
                endX = arcTo.getX();
            } else {
                throw new UnsupportedOperationException("Issue calculating the coordinates of the VLineTo");
            }
        }
        lineSegmentCoordinates[0] = startX;
        lineSegmentCoordinates[1] = startY;
        lineSegmentCoordinates[2] = endX;
        lineSegmentCoordinates[3] = endY;
        return lineSegmentCoordinates;
    }


    /**
     * Calculates the length of a PathLineSegment
     * based on its coordinates X and Y.
     * @param lineStartX start X coordinates of the PathLineSegment
     * @param lineStartY start Y coordinates of the PathLineSegment
     * @param lineEndX end X coordinates of the PathLineSegment
     * @param lineEndY end Y coordinates of the PathLineSegment
     * @return double the length in pixels of a PathLineSegment
     */
    public static double computeLineSegmentLength(double lineStartX, double lineStartY,
            double lineEndX, double lineEndY) {
        double length;

        double deltaX = (lineEndX - lineStartX);
        double deltaY = (lineEndY - lineStartY);
        double squareDeltaX = Math.pow(deltaX, 2);
        double squareDeltaY = Math.pow(deltaY, 2);

        length = Math.sqrt(squareDeltaX + squareDeltaY);

        return length;
    }

    /**
     * Calculates the rotation in degrees of a PathLineSegment 
     * based on its coordinates X and Y
     * @param startLineToX start X coordinates of the PathLineSegment
     * @param startLineToY start Y coordinates of the PathLineSegment
     * @param endLineToX end X coordinates of the PathLineSegment
     * @param endLineToY end Y coordinates of the PathLineSegment
     * @return double the rotation of the PathLineSegment in Degrees
     */
    public static double computeLineSegmentRotationInDegrees(double startLineToX, double startLineToY,
            double endLineToX, double endLineToY) {
        double rotationInDegrees;

        //gets the Rotation: Calculate the ArchTangent 2 of the X and Y points of the lines
        double rotationInRadiants = Math.atan2((endLineToY - startLineToY), (endLineToX - startLineToX));
        rotationInDegrees = Math.toDegrees(rotationInRadiants);

        return rotationInDegrees;
    }

    /**
     * Calculates the middle X coordinates of a PathLineSegment based on its X coordinates 
     * @param lineStartX start X coordinates of the PathLineSegment
     * @param lineEndX end X coordinates of the PathLineSegment
     * @return double the X coordinate of the middle point of a PathLineSegment
     */
    public static double computePathLineSegmentMiddleX(double lineStartX, double lineEndX) {
        return (lineStartX + lineEndX) / 2;
    }

    /**
     * Calculates the middle Y coordinates of a PathLineSegment based on its Y coordinates 
     * @param lineStartY start Y coordinates of the PathLineSegment
     * @param lineEndY end Y coordinates of the PathLineSegment
     * @return double the Y coordinate of the middle point of a PathLineSegment
     */
    public static double computePathLineSegmentMiddleY(double lineStartY, double lineEndY) {
        return (lineStartY + lineEndY) / 2;
    }

    /**
     * Creates a List of PathLineSegment from a Path 
     * @param path Path where to extract the PathLineSegments (LineTo, HLineTo, VLineTo)
     * @return List PathLineSegment the list of PathLineSegment in a Path
     */
    public static List<PathLineSegment> getPathLinesList(Path path) {
        int index;
        Class<? extends PathElement> classOfPathElement;
        Point2D start;
        Point2D end;
        Point2D middle;
        double length;
        double rotationInDegrees;
        List<PathLineSegment> listPathLineSegments = new ArrayList<>();

        for (int i = 0; i < path.getElements().size(); i++) {
            if (path.getElements().get(i) instanceof LineTo
                    || path.getElements().get(i) instanceof HLineTo
                    || path.getElements().get(i) instanceof VLineTo) {

                index = i;
                classOfPathElement = path.getElements().get(i).getClass();
                double[] pathElementCoordinates;
                pathElementCoordinates = computeLineSegmentCoordinates(i, path);
                start = new Point2D(pathElementCoordinates[0], pathElementCoordinates[1]);
                end = new Point2D(pathElementCoordinates[2], pathElementCoordinates[3]);
                middle = new Point2D(
                        computePathLineSegmentMiddleX(start.getX(), end.getX()),
                        computePathLineSegmentMiddleY(start.getY(), end.getY()));
                length = computeLineSegmentLength(start.getX(), start.getY(), end.getX(), end.getY());
                rotationInDegrees = computeLineSegmentRotationInDegrees(
                        start.getX(), start.getY(), end.getX(), end.getY());
                
                PathLineSegment pathLineSegmentTest = new PathLineSegment(index, classOfPathElement,
                        start, end, middle, length, rotationInDegrees);

                listPathLineSegments.add(pathLineSegmentTest);
            }
        }
        if (listPathLineSegments.isEmpty()) {
            throw new UnsupportedOperationException("The path is null or does not contain any line.\n"
                    + "Argument recived: " + path.getElements());
        } else {
            return listPathLineSegments;
        }
    }

    /**
     * Retrieves a PathLineSegment from a Path using the index of the PathElement
     * @param index index of the PathLineSegment (LineTo, HLineTo, VLineTo) within a Path
     * @param path path containing a PathLineSegment
     * @return PathLineSegment the pathLineSegment identified by the index in a Path
     */
    public static PathLineSegment getPathLineSegment(int index, Path path) {

        for (PathLineSegment pathLineSegment : getPathLinesList(path)) {
            if (pathLineSegment.getIndex() == index) {
                return pathLineSegment;
            }
        }
        throw new UnsupportedOperationException("No Line has been found at index: " + index + "\n"
                + "Path: " + path.getElements());
    }

    /**
     * 
     * @param path path containing a PathLineSegmen
     * @return PathLineSegment the longest pathLineSegment in a Path
     */
    public static PathLineSegment getLongestPathLineSegment(Path path) {
        double maxLength = 0;
        PathLineSegment tempLongestPathLineSegment = null;

        for (PathLineSegment pathLineSegment : getPathLinesList(path)) {
            if (pathLineSegment.getLength() > maxLength) {
                maxLength = pathLineSegment.getLength();
                tempLongestPathLineSegment = pathLineSegment;
            }
        }
        if (tempLongestPathLineSegment != null) {
            return tempLongestPathLineSegment;
        }
        throw new UnsupportedOperationException("No Line has been found in path: " + path.getElements());
    }
}
