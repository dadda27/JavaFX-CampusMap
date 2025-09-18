/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import javafx.geometry.Point2D;
import javafx.scene.shape.PathElement;

/**
 * This data-class represents a Line segment in a Path's PathElements. It can be either a LineTo, HLineTo or
 * VLineTo. It has been created in order to ease the Label's positioning methods in a Path (see MapStreet class).
 * @author dadda 
 */
public class PathLineSegment {

    private int index;
    private Class<? extends PathElement> classOfPathElement;
    private Point2D start;
    private Point2D end;
    private Point2D middle;
    private double length;
    private double rotationInDegrees;

    /**
     *
     */
    public PathLineSegment() {
    }
    
    /**
     * Creates a new PathLineSegment containing the coordinates (start, end, middle, lenght, rotation) calculated from 
     * a LineTo, HLineTo, VLineTo inside a Path.
     * @param index index of the PathElement
     * @param classOfPathElement Class of the PathElement
     * @param start start of the PathElement
     * @param end end of the PathElement
     * @param middle middle of the PathElement
     * @param length length of the PathElement
     * @param rotationInDegrees Rotation in Degrees of the PathElement
     */
    public PathLineSegment(int index, Class<? extends PathElement> classOfPathElement,
            Point2D start, Point2D end, Point2D middle,
            double length, double rotationInDegrees) {
        this.index = index;
        this.classOfPathElement = classOfPathElement;
        this.start = start;
        this.end = end;
        this.middle = middle;
        this.length = length;
        this.rotationInDegrees = rotationInDegrees;
    }

    /**
     *
     * @return index of the PathElement
     */
    public int getIndex() {
        return index;
    }

    /**
     *
     * @param index of the PathElement
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     *
     * @return Class of the PathElement
     */
    public Class<? extends PathElement> getClassOfPathElement() {
        return classOfPathElement;
    }

    /**
     *
     * @param classOfPathElement Class of the PathElement
     */
    public void setClassOfPathElement(Class<? extends PathElement> classOfPathElement) {
        this.classOfPathElement = classOfPathElement;
    }
    
    /**
     *
     * @return Point2D start
     */
    public Point2D getStart() {
        return start;
    }

    /**
     *
     * @param start Point2D start
     */
    public void setStart(Point2D start) {
        this.start = start;
    }

    /**
     *
     * @return Point2D end
     */
    public Point2D getEnd() {
        return end;
    }

    /**
     *
     * @param end Point2D end
     */
    public void setEnd(Point2D end) {
        this.end = end;
    }

    /**
     *
     * @return Point2D middle
     */
    public Point2D getMiddle() {
        return middle;
    }

    /**
     *
     * @param middle Point2D middle
     */
    public void setMiddle(Point2D middle) {
        this.middle = middle;
    }
    
    /**
     *
     * @return double length
     */
    public double getLength() {
        return length;
    }

    /**
     *
     * @param length double length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     *
     * @return double rotation in degrees of the PathElement
     */
    public double getRotationInDegrees() {
        return rotationInDegrees;
    }

    /**
     *
     * @param rotationInDegrees rotation in degrees PathElement
     */
    public void setRotationInDegrees(double rotationInDegrees) {
        this.rotationInDegrees = rotationInDegrees;
    }
}
