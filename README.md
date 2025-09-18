# JavaFX-CampusMap
### This projects aims to solve the Oracle Academy - JavaFx CampusMap - of the Java Foundation Lab exercise

## Requirements
java version "1.8.0_202".\
This Java version already contains the JavaFX library.\
Other versions or more recent versions that do not include JavaFX could produce errors when compiling the application.\

## Description of the exercise
Lab: Finding a Central Location\
**Tasks**\
Your goal is to create the CampusMap program that uses the campus map, the names of the residence halls, the residence hall populations, and your group of friends. You are encouraged to design your own campus map (this is your background graphic). You will need to design your own campus map if the actual campus has fewer than three residence halls; otherwise, this problem set would not be very interesting.\
**Residence Halls**\
Select a way to visually represent the residence halls. The name and population of each residence hall must also be visible. The population and location of each residence hall must be adjustable while the program is running.\
**Center Points**\
The program should display two center points. The first point represents the central location of all students in all residence halls. Essentially, this is a center-of-mass problem, where residences with larger populations are considered more "massive" and have a greater influence on the location of the center point.
The second point represents the central location of your study group. Create a study group of at least three people, one of whom must be from another residence.
Both center points must include a visual representation and a label, and display their locations as numerical values. These points should update automatically as a residence's location or population changes. You can leave these measurements in pixels or convert them to real-world distance units.
Whatever you choose to represent the residences and points, remember to perform distance calculations based on the geometric center of these visual elements, not the upper-left corners.\
**Hints:**\
There are some concepts not covered in Section 9, such as how to work with a text node. However, we've covered how to query JavaFX Ensemble. Part of the difficulty with this problem set is knowing how to query resources. If you have an idea for a feature you'd like to implement or a technique you'd like to explore, don't hesitate to contact JavaFX Ensemble. They have a lot of interesting things to show you.
