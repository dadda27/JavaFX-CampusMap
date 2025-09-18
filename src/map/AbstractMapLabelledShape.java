/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Shape;
import javax.swing.JOptionPane;

/**
 * Abstract class representing a JavaFX shape and a Label.
 * @author dadda
 */
public abstract class AbstractMapLabelledShape extends Group {
    private Shape shape;
    private Label label;

    protected AbstractMapLabelledShape(String name, Shape shape) {
        this.shape = shape;
        this.label = new Label(name);
        
        boolean add;
        add = super.getChildren().addAll(this.label, this.shape);
        
        if(!add) {
            JOptionPane.showMessageDialog(null, "Error adding list to Custom Node. Please check");
        } 
    }
    
    /**
     *
     * @return Shape
     */
    public Shape getShape() {
        return shape;
    }

    /**
     *
     * @param shape Shape
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     *
     * @return Label
     */
    public Label getLabel() {
        return label;
    }

    /**
     *
     * @param label the label
     */
    public void setLabel(Label label) {
        this.label = label;
    }

    /**
     * 
     */
    public abstract void setLabelToCenter();
    
}
