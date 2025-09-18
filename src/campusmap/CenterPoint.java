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
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javax.swing.JOptionPane;

/**
 * This class represents a graphical central point.
 * @author dadda
 */
public class CenterPoint extends Group {
    private final Label labelName;
    private final Circle circle;
    private final Label labelCoordinates;
    private final VBox vBox;
    private final Point2D position;
    private double averageDistance;

    public CenterPoint(String name) {
        this.labelName = new Label(name);
        this.circle = new Circle(10);
        this.labelCoordinates = new Label();
        this.vBox = new VBox();
        this.position = new Point2D(0, 0);
        this.averageDistance = 0;
        
        this.labelName.setFont(Font.font("Calibri", FontWeight.BOLD, 15));
        this.labelName.setTextFill(Color.BLACK);
        
        this.circle.setFill(Color.DARKSLATEBLUE);
        this.circle.setStrokeWidth(4);
        this.circle.setStroke(Color.WHITE);
        
        this.labelCoordinates.setFont(Font.font("Calibri", FontWeight.BOLD, 15));
        this.labelCoordinates.setTextFill(Color.BLACK);
        this.labelCoordinates.setAlignment(Pos.CENTER);
        
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.setSpacing(2);
        this.vBox.getChildren().addAll(this.labelName, this.circle, this.labelCoordinates);
        
        this.setLableCoordinatesText();   
        
        boolean add;
        add = super.getChildren().addAll(this.vBox);
        
        if(!add) {
            JOptionPane.showMessageDialog(null, "Error adding list to " + this.getClass().getSimpleName() +
                    "." + "Please check");
        } 
        
        this.toBack();
    }

    public Label getLabelName() {
        return labelName;
    }
    

    public Circle getCircle() {
        return circle;
    }

    public Label getLabelCoordinates() {
        return labelCoordinates;
    }

    public VBox getvBox() {
        return vBox;
    }
    
    public Point2D getPosition() {
        return position;
    }

    public void setAverageDistance(double averageDistance) {
        this.averageDistance = averageDistance;
    }

    public double getAverageDistance() {
        return averageDistance;
    }
    
    public final void setLableCoordinatesText() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Pos X: ").append(String.valueOf(Math.round(GeometryFormulas.computeGeometricCenter(this).getX()))).append("\n");
        sb.append("Pos Y: ").append(String.valueOf(Math.round(GeometryFormulas.computeGeometricCenter(this).getY()))).append("\n");
        sb.append("Distance: ").append(this.getAverageDistance());
        this.labelCoordinates.setText(sb.toString());
    }
    
    
  
}
