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

import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;

/**
 * This class is the graphical representation of the buildings in the Map. 
 * It consists of a Shape and a text Label. 
 * If translate X and Y are not specified in the constructor, the label is positioned in the center of the shape
 * @author dadda
 */
public class MapBuilding extends AbstractMapLabelledShape {
    
    //Constants for default style application
    private static final Font DEFAULT_LABEL_FONT = Font.font("Arial", FontWeight.LIGHT, 15.0);
    private static final Color DEFAULT_FILL_COLOR = Color.DARKSLATEGRAY;
    private static final double DEFAULT_FILL_OPACITY = 0.4;
    private static final double DEFAULT_STROKE_WIDTH = 2;
    private static final Color DEFAULT_STROKE_COLOR = Color.GRAY;

    /**
     * Creates a simple Building without text label
     * @param shape shape of the graphical MapBuiildng
     */
    public MapBuilding(Shape shape) {
        super("", shape);
        super.getShape().setFill(DEFAULT_FILL_COLOR);
        super.getShape().setOpacity(DEFAULT_FILL_OPACITY);
        super.getShape().setStrokeWidth(DEFAULT_STROKE_WIDTH);
        super.getShape().setStroke(DEFAULT_STROKE_COLOR);
    }

    /**
     * Creates a Building with text label and default style.Label is centered inside the shape.
     * @param name name of the graphical MapBuiildng
     * @param shape shape of the graphical MapBuiildng
     */
    public MapBuilding(String name, Shape shape) {
        super(name, shape);
        super.getShape().setFill(DEFAULT_FILL_COLOR);
        super.getShape().setOpacity(DEFAULT_FILL_OPACITY);
        super.getShape().setStrokeWidth(DEFAULT_STROKE_WIDTH);
        super.getShape().setStroke(DEFAULT_STROKE_COLOR);

        super.getLabel().setFont(DEFAULT_LABEL_FONT);
        this.setLabelToCenter();
    }

    /**
     * Creates a simple Building without text label but with customized style
     * @param shape shape of the graphical MapBuiildng
     * @param fillColor fillColor of the shape
     * @param strokeWidth the strokeWidth of the shape
     * @param strokeColor the strokeColor of the shape
     */
    public MapBuilding(Shape shape, Color fillColor, double strokeWidth, Color strokeColor) {
        super("", shape);
        super.getShape().setFill(fillColor);
        super.getShape().setOpacity(DEFAULT_FILL_OPACITY);
        super.getShape().setStrokeWidth(strokeWidth);
        super.getShape().setStroke(strokeColor);      
    }

    /**
     * Creates a Building with text label and customized style
     * @param name name of the graphical MapBuiildng
     * @param shape shape of the graphical MapBuiildng
     * @param fillColor fillColor fillColor of the shape
     * @param strokeWidth the strokeWidth of the shape
     * @param strokeColor the strokeColor of the shape
     */
    public MapBuilding(String name, Shape shape, Color fillColor, double strokeWidth, Color strokeColor) {
        super(name, shape);
        super.getShape().setFill(fillColor);
        super.getShape().setOpacity(DEFAULT_FILL_OPACITY);
        super.getShape().setStroke(strokeColor);
        super.getShape().setStrokeWidth(strokeWidth);

        super.getLabel().setFont(DEFAULT_LABEL_FONT);
        
        this.setLabelToCenter();
    }

    /**
     * Creates a Building with text label and default style.The label is placed according to the coordinates and rotation passed as arguments.
     * @param name name of the graphical MapBuiildng
     * @param labelTranslateX the translateX location of the label
     * @param labelTranslateY the translateY location of the label
     * @param labelRotationInDegrees the rotationInDegrees of the label used for label.setRotate()
     * @param shape shape of the graphical MapBuiildng
     */
    public MapBuilding(String name, double labelTranslateX, double labelTranslateY, double labelRotationInDegrees, 
            Shape shape) {
        super(name, shape);
        super.getShape().setFill(DEFAULT_FILL_COLOR);
        super.getShape().setOpacity(DEFAULT_FILL_OPACITY);
        super.getShape().setStrokeWidth(DEFAULT_STROKE_WIDTH);
        super.getShape().setStroke(DEFAULT_STROKE_COLOR);
        
        super.getLabel().setFont(DEFAULT_LABEL_FONT);
        super.getLabel().setTranslateX(labelTranslateX);
        super.getLabel().setTranslateY(labelTranslateY);
        super.getLabel().getTransforms().add(new Rotate(labelRotationInDegrees));
    }
    
    /**
     * Creates a Building with text label and customized style.
     * The label is placed according to the coordinates and rotation passed as arguments.
     * @param name name of the graphical MapBuiildng
     * @param labelTranslateX the translateX location of the label
     * @param labelTranslateY the translateY location of the label
     * @param labelRotationInDegrees the rotationInDegrees of the label used for label.setRotate()
     * @param shape shape of the graphical MapBuiildng
     * @param fillColor fillColor of the shape
     * @param strokeWidth the strokeWidth of the shape
     * @param strokeColor the strokeColor of the shape
     */
    public MapBuilding(String name, double labelTranslateX, double labelTranslateY, double labelRotationInDegrees, 
                    Shape shape, Color fillColor, double strokeWidth, Color strokeColor) {
        
        super(name, shape);
        super.getShape().setFill(fillColor);
        super.getShape().setOpacity(DEFAULT_FILL_OPACITY);
        super.getShape().setStroke(strokeColor);
        super.getShape().setStrokeWidth(strokeWidth);
        
        super.getLabel().setFont(DEFAULT_LABEL_FONT);
        super.getLabel().setTranslateX(labelTranslateX);
        super.getLabel().setTranslateY(labelTranslateY);
        super.getLabel().getTransforms().add(new Rotate(labelRotationInDegrees));
    }
    
    /**
     * Sets the Label to the center of the shape. 
     * It uses a StackPane layout.
     */
    @Override
    public final void setLabelToCenter() {
        StackPane stackPane = new StackPane(super.getShape(), super.getLabel());
        super.setTranslateX(super.getShape().getBoundsInParent().getMinX());
        super.setTranslateY(super.getShape().getBoundsInParent().getMinY());
        
        super.getChildren().add(stackPane);
        
    }
}
