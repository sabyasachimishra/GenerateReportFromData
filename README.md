Customer Report Generator
==========================

This application reads customer data from a multi-line string input and generates various reports.


Here's an example input string that you can use:
- 2343225,2345,us_east,RedTeam,ProjectApple,3445s
- 1223456,2345,us_west,BlueTeam,ProjectBanana,2211s

Application generates the following reports
- The number of unique customers for each contract Id
- The number of unique customers for each Geozone
- Average build duration for each Geozone
- List of unique customers for each Geozone

## Installation
- Prerequisites
    - Java 21 or higher 
    - Maven


## Steps Clone the repository:

    git clone <repository-url>
    cd CustomerReportGenerator


## Build the project:
    mvn clean install



## Start the application:
    mvn exec:java -Dexec.mainClass="org.example.Main"

## Interacting with the Application with new data
update the string input in the main method in Main class with new strings and application will accept the input and generate the report. 



## Run the tests using Maven:
    mvn test