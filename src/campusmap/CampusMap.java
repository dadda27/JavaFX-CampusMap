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

import residence.ResidenceHall;
import map.Map;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import residence.Residence;

/**
 *
 * @author dadda
 */
public class CampusMap extends Application {

    public static Group root = new Group();

    @Override
    public void start(Stage primaryStage) {

        //Instantiates the Map in the background of the applications
        Map backgroundMap = new Map();

        //Creates the graphical residencesNodes and Central Points
        ResidenceHall residence1 = new ResidenceHall(new Residence("Residence 1", 50), Color.AQUA, 20, 30);
        ResidenceHall residence2 = new ResidenceHall(new Residence("Residence 2", 50), Color.PURPLE, 50, 30);
        ResidenceHall residence3 = new ResidenceHall(new Residence("Residence 3", 50), Color.BROWN, 100, 30);
        ResidenceHall residence4 = new ResidenceHall(new Residence("Residence 4", 50), Color.YELLOW, 150, 30);
        ResidenceHall residence5 = new ResidenceHall(new Residence("Residence 5", 50), Color.CORAL, 200, 30);

        CenterlPoint allResidencesCentralPoint = new CenterlPoint("All Residences");
        allResidencesCentralPoint.setVisible(false);

        CenterlPoint myStudyGroupCentralPoint = new CenterlPoint("My Study Group");
        myStudyGroupCentralPoint.setVisible(false);

        //Adds the nodes to root
        root.getChildren().addAll(
                allResidencesCentralPoint,
                myStudyGroupCentralPoint,
                residence1,
                residence2,
                residence3,
                residence4,
                residence5
                );

        /*
        * When the Mouse is Dragged inside Root (moving the Residences), 
        * the Central Points are moved according to the 
        * Center of Mass and the Avarage Distance calculation required in the exercise
        */
        root.addEventFilter(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                //creates the mass systems needed for the Center of Mass calculation
                MassSystem allResidences = new MassSystem(
                        residence1.getWightedPoint(),
                        residence2.getWightedPoint(),
                        residence3.getWightedPoint(),
                        residence4.getWightedPoint(),
                        residence5.getWightedPoint());
                
                //creates the mass systems of My group of study needed for the distance calculation
                MassSystem myStudyGroup = new MassSystem(
                        residence2.getWightedPoint(),
                        residence4.getWightedPoint(),
                        residence5.getWightedPoint()
                );
                
                //activates the central points in the Map and calculates is avarage distance from the Residences 
                allResidencesCentralPoint.setVisible(true);
                allResidencesCentralPoint.setAverageDistance(GeometryFormulas.computeAvarageDistance2D(
                        allResidences.getCoordinates()));
                
                myStudyGroupCentralPoint.setVisible(true);
                myStudyGroupCentralPoint.setAverageDistance(GeometryFormulas.computeAvarageDistance2D(
                        myStudyGroup.getCoordinates()));
                
                //moves All Residences central point according to the Center of Mass calculations
                allResidencesCentralPoint.setTranslateX(GeometryFormulas.computeCenterOfMass2D(
                        allResidences).getX()
                        - allResidencesCentralPoint.getBoundsInParent().getWidth() / 2);
                allResidencesCentralPoint.setTranslateY(GeometryFormulas.computeCenterOfMass2D(
                        allResidences).getY()
                        - allResidencesCentralPoint.getBoundsInParent().getHeight() / 2);
                
                //moves My Study Group central point according to the Avarage Distance calculation
                myStudyGroupCentralPoint.setTranslateX(GeometryFormulas.computeAvarageCoordinates2D(
                        myStudyGroup.getCoordinates()).getX()
                        - myStudyGroupCentralPoint.getBoundsInParent().getWidth() / 2);
                myStudyGroupCentralPoint.setTranslateY(GeometryFormulas.computeAvarageCoordinates2D(
                        myStudyGroup.getCoordinates()).getY()
                        - myStudyGroupCentralPoint.getBoundsInParent().getHeight() / 2);
                
                //shows the measures in the central point labels
                allResidencesCentralPoint.setLableCoordinatesText();
                myStudyGroupCentralPoint.setLableCoordinatesText();
                
                //clears the Mass Systems to allow recalculation at next Drag Event
                allResidences.clear();
                myStudyGroup.clear();
            }
        });

        //Scene
        Scene scene = new Scene(root, 1200, 800, Color.LIGHTGRAY);

        //Stage
        primaryStage.setTitle("CampusMap!");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
