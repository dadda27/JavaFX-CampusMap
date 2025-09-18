/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import campusmap.CampusMap;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;

/**
 * This class represents the background map of the application. 
 * Uses nodes, MapStreet, ResidenceNode and MapBuilding to draw the Map.
 * @author dadda 
 *
 */
public class Map extends Group{

    /**
     * Creates a new BackGroundMap
     */
    public Map() {
    /*
  STREETS: Street from left to right
     */

        /*
         STREET 1: left vertical
         */
        MapStreet street1Left = new MapStreet("Street 1", new Path(
                new MoveTo(10, 0),
                new LineTo(10, 200),
                new LineTo(70, 800)
        ));
        super.getChildren().add(street1Left);
        
        /*
         STREET 1: Right vertical
         */
        MapStreet street1Right = new MapStreet(new Path(
                new MoveTo(30, 0),
                new LineTo(30, 200),
                new LineTo(90, 800)
        ));
        super.getChildren().add(street1Right);

        /*
         STREET 2: Intersection with Street 1: Before Roundabout
         */
        MapStreet street2 = new MapStreet(new Path(
                new MoveTo(50, 550),
                new LineTo(200, 525)
        ));
        super.getChildren().add(street2);

        /*
         ROUNDABOUT: 
         */
        Circle circleRoundAbout = new Circle(285, 520, 70);
        circleRoundAbout.setStroke(Color.GREY);
        circleRoundAbout.setFill(null);
        circleRoundAbout.setStrokeWidth(15);
        circleRoundAbout.setOpacity(0.5);
        super.getChildren().add(circleRoundAbout);

        /*
         CONTINUE OF STREET 2:
         */
        MapStreet street2Continue = new MapStreet("Street 2", new Path(
                new MoveTo(368, 500),
                new LineTo(900, 420),
                new LineTo(880, 300),
                new CubicCurveTo(880, 270, 840, 280, 820, 310),
                new LineTo(850, 550),
                new ArcTo(20, 20, 90, 920, 520, true, false),
                new LineTo(900, 420)
        ));
        super.getChildren().add(street2Continue);

        /*
         STREET 3: Intersection with Street 2
         */
        MapStreet street3 = new MapStreet("Street 3", new Path(
                new MoveTo(450, 500),
                new QuadCurveTo(455, 505, 460, 510),
                new LineTo(680, 700),
                new QuadCurveTo(740, 710, 740, 680),
                new LineTo(670, 620),
                new QuadCurveTo(665, 615, 595, 615)
        ));
        super.getChildren().add(street3);

        /*
         STREET 3.5: Intersection with Street 3
         */
        MapStreet street3_5 = new MapStreet(new Path(
                new MoveTo(520, 560),
                new LineTo(440, 680)
        ));
        super.getChildren().add(street3_5);

        /*
         STREET 4: 
         */
        MapStreet street4 = new MapStreet("Street 4", new Path(
                new MoveTo(815, 300),
                new CubicCurveTo(780, 260, 860, 220, 850, 200),
                new LineTo(800, 10),
                new HLineTo(1000),
                new LineTo(1100, 300)
        ));
        super.getChildren().add(street4);

        /*
         STREET 5: Exit from Campus: Parking Good zone
         */
        MapStreet street5 = new MapStreet("Street 5", new Path(
                new MoveTo(1100, 0),
                new LineTo(1200, 500)
        ) , 25.0);
        super.getChildren().add(street5);

        /*
         STREET 6: 
         */
        MapStreet street6 = new MapStreet("Street 6", new Path(
                new MoveTo(45, 10),
                new HLineTo(785)
        ) ,20 ,1);
        super.getChildren().add(street6);
    
    /*
  BUILDINGS AND REST OF THE MAP NODES: 
     */
        /*
     DORM 1:
         */
        MapBuilding dorm1 = new MapBuilding("Dorm 1", 120, 340, 0, new Rectangle(100, 360, 100, 100),
                Color.LIGHTYELLOW, 5, Color.GREY);
        dorm1.getTransforms().add(new Rotate(-10, dorm1.getBoundsInParent().getMaxX(),
                dorm1.getBoundsInParent().getMaxY()));
        super.getChildren().add(dorm1);
        /*
     DORM 2:
         */
        MapBuilding dorm2 = new MapBuilding("Dorm 2", new Rectangle(420, 420, 200, 50),
                Color.LIGHTGOLDENRODYELLOW, 5, Color.DARKGOLDENROD);
        dorm2.getTransforms().add(new Rotate(-9, dorm2.getBoundsInLocal().getMinX(),
                dorm2.getBoundsInLocal().getMinY()));
        super.getChildren().add(dorm2);

        /*
     DORM 3:
         */
        MapBuilding dorm3 = new MapBuilding("Dorm 3", new Polygon(new double[]{
            200, 640,
            220, 600,
            250, 640,
            300, 630,
            420, 510,
            480, 580,
            460, 610,
            420, 560,
            270, 730
        }), Color.LIGHTGREEN, 5, Color.DARKGREEN);
        super.getChildren().add(dorm3);

        /*
     DORM 4:
         */
        MapBuilding dorm4 = new MapBuilding("Dorm 4", new Rectangle(550, 500, 200, 50),
                Color.LIGHTCORAL, 5, Color.DARKSALMON);
        dorm4.getTransforms().add(new Rotate(-9, dorm4.getBoundsInLocal().getMinX(),
                dorm4.getBoundsInLocal().getMinY()));
        super.getChildren().add(dorm4);

        /*
     DORM 5:
         */
        MapBuilding dorm5 = new MapBuilding("Dorm 5", new Rectangle(960, 300, 200, 50),
                Color.CYAN, 5, Color.DARKCYAN);
        dorm5.getTransforms().add(new Rotate(80, dorm5.getBoundsInLocal().getMinX(),
                dorm5.getBoundsInLocal().getMinY()));
        super.getChildren().add(dorm5);

        /*
     BUILDING 6:
         */
        MapBuilding administrativeHall = new MapBuilding("Administrative Hall", new Circle(1080, 430, 60),
                Color.BISQUE, 5, Color.DARKCYAN);
        super.getChildren().add(administrativeHall);

        /*  
     CLASSROOM:
         */
        MapBuilding classRoom = new MapBuilding("ClassRoom", new Polygon(new double[]{
            260, 270,
            230, 320,
            370, 480,
            420, 470,
            410, 420,
            390, 410,
            390, 400,
            370, 400,
            260, 270
        }), Color.SILVER, 5, Color.DARKSLATEGRAY);
        super.getChildren().add(classRoom);

        /*  
     LABORATORY:
         */
        MapBuilding laboratory = new MapBuilding("Laboratory", new Rectangle(650, 380, 150, 50));
        laboratory.getTransforms().add(new Rotate(-9, laboratory.getBoundsInLocal().getMinX(),
                laboratory.getBoundsInLocal().getMinY()));
        super.getChildren().add(laboratory);

        /*
     LIBRARY:
         */
        MapBuilding building7 = new MapBuilding("Library", new Rectangle(530, 610, 200, 50));
        building7.getTransforms().add(new Rotate(40, building7.getBoundsInParent().getMaxX(),
                building7.getBoundsInParent().getMaxY()));
        super.getChildren().add(building7);

        /*
     DINING HALL
         */
        MapBuilding diningHall = new MapBuilding("Dining Hall", new Path(
                new MoveTo(850, 50),
                new VLineTo(150),
                new HLineTo(880),
                new VLineTo(120),
                new HLineTo(950),
                new VLineTo(150),
                new HLineTo(980),
                new VLineTo(50),
                new ClosePath()
        ));
        super.getChildren().add(diningHall);

        /*
     PARK 1:
         */
        Path pathPark1 = new Path(
                new MoveTo(200, 50),
                new ArcTo(50, 50, 90, 200, 250, true, false),
                new HLineTo(650),
                new ArcTo(50, 50, 90, 650, 50, false, false),
                new ClosePath()
        );
        pathPark1.setStroke(Color.DARKGREEN);
        pathPark1.setFill(Color.GREEN);
        pathPark1.setOpacity(0.4);

        Label labelPark1 = new Label("Park 1");
        labelPark1.setFont(Font.font("Arial", FontWeight.LIGHT, 15));
        labelPark1.setTranslateX(400);
        labelPark1.setTranslateY(135);
        super.getChildren().addAll(pathPark1, labelPark1);

        /*
     PARK 2:
         */
        Path pathPark2 = new Path(
                new MoveTo(700, 600),
                new LineTo(850, 750),
                new LineTo(900, 780),
                new HLineTo(1100),
                new VLineTo(630),
                new ClosePath()
        );
        pathPark2.setStroke(Color.DARKGREEN);
        pathPark2.setFill(Color.GREEN);
        pathPark2.setOpacity(0.4);

        Label labelPark2 = new Label("Park 2");
        labelPark2.setFont(Font.font("Arial", FontWeight.LIGHT, 15));
        labelPark2.setTranslateX(900);
        labelPark2.setTranslateY(700);
        super.getChildren().addAll(pathPark2, labelPark2);
        
        /*
        ROOT:
         */
        //adds to the root group 
        CampusMap.root.getChildren().addAll(super.getChildren());
        super.toBack();
    }

}
