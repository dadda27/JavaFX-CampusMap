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
