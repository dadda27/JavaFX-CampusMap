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
package residence;

import javafx.beans.value.ChangeListener;
import javafx.scene.input.MouseEvent;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import campusmap.WeightedPoint;
import campusmap.GeometryFormulas;

/**
 * The graphical representation of a Residence
 * @author dadda
 */
public class ResidenceHall extends Group {
    private final Residence residence;
    private final Label labelName;
    private final Circle circle = new Circle();
    private final Label labelPopulation;
    private final Slider slider;
    private final VBox vBox;

    //Variables for Residence Node position
    private double initX;
    private double initY;
    private Point2D dragAnchor;
    private WeightedPoint wightedPoint;

    //Constants for shape and label styles
    private static final double DEFAULT_SHAPE_OPACITY = 0.6;
    public static final Font DEFAULT_LABEL_FONT = Font.font("Cambria", FontWeight.BOLD, 15);
    public static final Color DEFAULT_LABEL_COLOR = Color.INDIGO;

    /**
     * Creates a Residence Node with custom color and assigned location
     * @param residence the residence (name and population) of a ResidenceNode
     * @param fillColor the fillColor of the shape (circle)
     * @param translateX the translateX location of the ResidenceNode
     * @param translateY the translateY location of the ResidenceNode
     */
    public ResidenceHall(Residence residence, Color fillColor, double translateX, double translateY) {
        this.residence = residence;
        this.labelName = new Label(this.residence.getName());
        this.labelPopulation = new Label(Integer.toString(this.residence.getPopulation()));
        this.slider = new Slider(0, Residence.DEFAULT_MAX_POPULATION, this.residence.getPopulation());
        this.vBox = new VBox(this.labelName, circle, this.labelPopulation, this.slider);

        this.labelName.setFont(DEFAULT_LABEL_FONT);
        this.labelName.setTextFill(DEFAULT_LABEL_COLOR);
        
        this.circle.setCursor(Cursor.HAND);
        this.circle.setFill(fillColor);
        this.circle.setOpacity(DEFAULT_SHAPE_OPACITY);
        
        //sets the circle radius according to the population of the residence
        if ((this.residence.getPopulation() / 2) > 10) {
            this.circle.setRadius(new Double(this.residence.getPopulation() / 2));
        } else {
            this.circle.setRadius(10);
        }
        
        this.labelPopulation.setFont(DEFAULT_LABEL_FONT);

        this.slider.setMaxWidth(100.0);
        this.slider.setShowTickMarks(true);
        this.slider.setShowTickLabels(true);
        this.slider.setMajorTickUnit(50);
        this.slider.setMinorTickCount(20);
        this.slider.setBlockIncrement(10);
        this.slider.setCursor(Cursor.HAND);
        this.slider.setVisible(false);

        this.vBox.setSpacing(5);
        this.vBox.setAlignment(Pos.CENTER);
        
        this.setTranslateX(translateX - this.vBox.getBoundsInLocal().getWidth() /2);
        this.setTranslateY(translateY - this.vBox.getBoundsInLocal().getHeight() /2);

        super.getChildren().add(vBox);
        
        interactions();
    }

    public Residence getResidence() {
        return residence;
    }

    public Label getLabelName() {
        return labelName;
    }

    public Circle getCircle() {
        return circle;
    }

    public Label getLabelPopulation() {
        return labelPopulation;
    }

    public Slider getSlider() {
        return slider;
    }

    public VBox getvBox() {
        return vBox;
    }
    
    //Circle Shape Utils
    /**
     *
     * @return double The mass (area) of the circle representing the ResidenceHall
     */
    public double getMass() {
        return Math.pow(this.circle.getRadius(), 2) * Math.PI;
    }
    
    //Residence Node Position Getters and Setters
    /**
     *
     * @return double the Initial X location of a ResidenceHall before an event is triggered. 
 For example, when a mouse is clicked on the ResidenceHall it gets its X position
     */
    public double getInitX() {
        return initX;
    }

    /**
     *
     * @param initX set the Initial X location of a ResidenceHall.
     */
    public void setInitX(double initX) {
        this.initX = initX;
    }

    /**
     *
     * @return double the Initial Y location of a ResidenceHall before an event is triggered. 
 For example, when a mouse is clicked on the ResidenceHall, it gets its Y position
     * 
     */
    public double getInitY() {
        return initY;
    }

    /**
     *
     * @param initY set the Initial Y location of a ResidenceHall.
     */
    public void setInitY(double initY) {
        this.initY = initY;
    }

    /**
     *
     * @return Point2D the dragAnchor. The location in the scene where an event occurred. 
     * For example, can be the location where a mouse has been pressed before dragging a Node into a new location. 
     * It's needed to calculate the new position of a dragged node
     */
    public Point2D getDragAnchor() {
        return dragAnchor;
    }

    /**
     *
     * @param dragAnchor the dragAnchor. The location in the scene where an event occurred.
     */
    public void setDragAnchor(Point2D dragAnchor) {
        this.dragAnchor = dragAnchor;
    }

    /**
     *
     * @return WeightedPoint
     */
    public WeightedPoint getWightedPoint() {
        return wightedPoint;
    }
    

    private void interactions() {
        this.wightedPoint = new WeightedPoint(this.getMass(), 
                GeometryFormulas.computeGeometricCenter(ResidenceHall.this));
        
        this.circle.setOnMouseEntered((MouseEvent me) -> {
            this.toFront();
            this.circle.setOpacity(0.8);
        });
        
        this.circle.setOnMouseExited((MouseEvent me) -> {
            this.circle.setOpacity(DEFAULT_SHAPE_OPACITY);
        });
        
        this.setOnMouseEntered((MouseEvent me) -> 
                this.slider.setVisible(true));
        
        this.setOnMouseExited((MouseEvent me) -> 
                this.slider.setVisible(false));
        
        this.setOnMousePressed((MouseEvent me) -> {
            initX = this.getTranslateX();
            initY = this.getTranslateY();
            dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                double dragX = me.getSceneX() - dragAnchor.getX();
                double dragY = me.getSceneY() - dragAnchor.getY();
                //calculate new position of the vBox
                double newXPosition = initX + dragX;
                double newYPosition = initY + dragY;
                //if mouseEvent does not exceeds left and top borders of the scene, translate to this position
                if (me.getSceneX() >= 0) {
                    ResidenceHall.this.setTranslateX(newXPosition);
                }
                if (me.getSceneY() >= 0) {
                    ResidenceHall.this.setTranslateY(newYPosition);
                }
                //Sets new Geometric_Center
                ResidenceHall.this.wightedPoint.setCoordinates(GeometryFormulas.computeGeometricCenter(ResidenceHall.this));
            }
        });

        //Modifies the circle's radius with the slider and sets new population
        this.slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                slider.setVisible(true);
                ResidenceHall.this.labelPopulation.setText(String.format("%.0f", new_val));
                ResidenceHall.this.residence.setPopulation(new_val.intValue());
                if (new_val.doubleValue() / 2 > 10) {
                    ResidenceHall.this.circle.setRadius(new_val.doubleValue() / 2);
                    ResidenceHall.this.wightedPoint.setMass(ResidenceHall.this.getMass());
                }
            }
        });

    }

}
