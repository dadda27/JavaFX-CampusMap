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
package map;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;

/**
 * This class is a graphical representation of a street in the map
 * @author dadda 
 */
public class MapStreet extends AbstractMapLabelledShape {
    
    //Constants for default graphical representation

    /**
     *
     */
    public static final double DEFAULT_PATH_STROKE_WIDTH = 15;

    /**
     *
     */
    public static final Color DEFAULT_PATH_STROKE_COLOR = Color.GRAY;

    /**
     *
     */
    public static final double DEFAULT_PATH_STROKE_OPACITY = 0.5;

    /**
     *
     */
    public static final Font DEFAULT_LABEL_FONT = Font.font("Arial", FontWeight.BOLD, 15);
    
    /**
     * Creates a Street with no label and default style
     * @param path the Path used to create the street
     */
    public MapStreet(Path path) {
        super("", path);
        super.getShape().setStrokeWidth(DEFAULT_PATH_STROKE_WIDTH);
        super.getShape().setStroke(DEFAULT_PATH_STROKE_COLOR);
        super.getShape().setOpacity(DEFAULT_PATH_STROKE_OPACITY);
    }
  
    /**
     * Creates a Street with a label and default style.The label placed in the longest *LineTo (see PathLineSegment) of the path.
     * @param name the name of the street
     * @param path the Path used to create the street
     * 
     */
    public MapStreet(String name, Path path) {
        super(name, path);
        super.getShape().setStrokeWidth(DEFAULT_PATH_STROKE_WIDTH);
        super.getShape().setStroke(DEFAULT_PATH_STROKE_COLOR);
        super.getShape().setOpacity(DEFAULT_PATH_STROKE_OPACITY);
        super.getLabel().setFont(DEFAULT_LABEL_FONT);
        
        setLabelToCenter();
    }

    /**
     * Creates a Street with a label and default style.The label is placed in the *LineTo (see PathLineSegment) chosen in the path.
     * @param name the name of the street
     * @param path the Path used to create the street
     * @param indexPathLine the index of the *LineTo (see PathLineSegment) chosen for the Text Position
     */
    public MapStreet(String name, Path path, int indexPathLine) {
        super(name, path);
        super.getShape().setStrokeWidth(DEFAULT_PATH_STROKE_WIDTH);
        super.getShape().setStroke(DEFAULT_PATH_STROKE_COLOR);
        super.getShape().setOpacity(DEFAULT_PATH_STROKE_OPACITY);
        super.getLabel().setFont(DEFAULT_LABEL_FONT);
        
        this.setLabelToCenter(indexPathLine);
    }
    
     /**
     * Creates a Street with no label, customized width and default style
     * @param path the Path used to create the street
     * @param streetWidth the width assigned to the path.setStrokeWidth()
     * 
     */
    public MapStreet(Path path, double streetWidth) {
        super("", path);
        super.getShape().setStrokeWidth(streetWidth);
        super.getShape().setStroke(DEFAULT_PATH_STROKE_COLOR);
        super.getShape().setOpacity(DEFAULT_PATH_STROKE_OPACITY);
    }
    
    /**
     * Creates a Street with a label, customized width and default style.The label placed in the longest *LineTo (see PathLineSegment) of the path.
     * @param name the name of the street
     * @param path the Path used to create the street
     * @param streetWidth the width assigned to the path.setStrokeWidth()
     * 
     */
    public MapStreet(String name, Path path, double streetWidth) {
        super(name, path);
        super.getShape().setStrokeWidth(streetWidth);
        super.getShape().setStroke(DEFAULT_PATH_STROKE_COLOR);
        super.getShape().setOpacity(DEFAULT_PATH_STROKE_OPACITY);
        super.getLabel().setFont(DEFAULT_LABEL_FONT);
        
        this.setLabelToCenter();
    }
    
    /**
     * Creates a Street with a label, customized width and default style.
     * The label placed in the *LineTo (see PathLineSegment) chosen in the path. 
     * @param name the name of the street
     * @param path the Path used to create the street
     * @param streetWidth the width assigned to the path.setStrokeWidth()
     * @param indexPathLine the index of the *LineTo (see PathLineSegment) chosen for the Text Position
     */
    public MapStreet(String name, Path path, double streetWidth, int indexPathLine) {
        super(name, path);
        super.getShape().setStrokeWidth(streetWidth);
        super.getShape().setStroke(DEFAULT_PATH_STROKE_COLOR);
        super.getShape().setOpacity(DEFAULT_PATH_STROKE_OPACITY);
        super.getLabel().setFont(DEFAULT_LABEL_FONT);
        
        this.setLabelToCenter(indexPathLine);
    }
    
    /**
     *
     * @return ArrayList PathLineSegment the ArrayList of the PathLineSegments within the Path
     */
    public ArrayList<PathLineSegment> getLines() {
        return (ArrayList<PathLineSegment>) PathGeometryUtils.getPathLinesList((Path)super.getShape());
    }
    
    /**
     *
     * @param index index of the PathLineSegment
     * @return PathLinesegment the PathLinesegment returned by its index in the Path
     */
    public PathLineSegment getLine(int index) {
        return PathGeometryUtils.getPathLineSegment(index, (Path)super.getShape());
    }
    
    /**
     * 
     * @return PathLineSegment the longest PathLinesegment in the Path
     */
    public PathLineSegment getLongestLine() {
        return PathGeometryUtils.getLongestPathLineSegment((Path)super.getShape());
    }
    
    /**
     * Centers the Label in the longest *LineTo (see PathLineSegment) of the path
     */
    @Override
    public final void setLabelToCenter() {
        
        if (super.getLabel() != null) {

            super.getLabel().setTranslateX(
                    this.getLongestLine().getMiddle().getX() + super.getShape().getStrokeWidth() / 2);
            super.getLabel().setTranslateY(
                    this.getLongestLine().getMiddle().getY() - super.getShape().getStrokeWidth() / 2);

            super.getLabel().getTransforms().add(new Rotate(
                    this.getLongestLine().getRotationInDegrees()
            ));
        }
    }
    
    /**
     * Centers the Label in the *LineTo (see PathLineSegment) passed as index argument
     * @param index the index of the *LineTo (see PathLineSegment) chosen for the Text Position
     */
    public final void setLabelToCenter(int index) {
        if (super.getLabel() != null || super.getLabel().getText().isEmpty()) {

            super.getLabel().setTranslateX(
                    this.getLine(index).getMiddle().getX() + super.getShape().getStrokeWidth() / 2);
            super.getLabel().setTranslateY(
                    this.getLine(index).getMiddle().getY() - super.getShape().getStrokeWidth() / 2);
            super.getLabel().getTransforms().add(new Rotate(
                    this.getLine(index).getRotationInDegrees()
            ));
        }
    }
    
}
