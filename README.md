# MY STUDY PROJECT
## JAVA

###Project description:
Program for calculating the cost of horizontal and vertical blinds.
1. Horizontal blinds. 3 input parameters: width (250-2700 mm), height (500-3000 mm), color (201 - $8.8 per sq.m., 202 - $10.4 per sq.m.).
   Formula: find the area (if the area is less than 0.75 sq. m., then round up to 0.75 sq. m.), then multiply by the cost of the color in dollars and then convert the dollars into rubles and display the price on the console.
2. Vertical blinds. Input parameters: width (400-6000 mm), height (200-4000 mm, if less than 1500 - round up to 1500), fabric type (01 = $13.3, 02 = $14.7, 03 = $15.3), fabric color (white , green, yellow, blue, beige), blinds mounting type (ceiling, wall).
   The color of the fabric is not used anywhere, just kept. If the type of blind fastening is a wall: if the width is up to 2000 - 2 mounts, from 2000 to 3000 - 3 mounts, more than 3000 - 4 mounts. Cost of mounts - $ 0.27.
   
Loading prices from a csv file.  
After the completion of all calculations, provide for saving all calculations in a csv file.

###To run a project from the command line
1. Download the project from the repository at https://github.com/IvashkevichYury/my_project
2. Open the command line, go to the package with the project, after which to build the project you need to type:
mvn clean package
3. To start the project, you need to type::
java -jar target/myProject.jar 