# Huenei - Tech Exam

## Overview

This is an automation project that provides the solution for the Tech Exam requirements.

# Main requirements

* Install the Java JDK
* Install Apache Maven
* Configure the system environment variables
* Code editor like Visual Studio Code (the one I have chosen), IntelliJ, Eclipse

## Tech stack

* Java
* Cucumber
* Gherkin
* TestNG
* Maven

## Project structure

This is Java-Maven project built with the quickstart archetype. The design pattern applied is Page Object Model, so all the pages involved in the solutions are represented as separated clasess with their corresponding elements and action methods. Along with the pages there are created some 'base' methods to apply as hooks but also element interaction methods used to perform the different actions. To apply the Gherkin syntax through Cucumber tool there were created different packages and files to separate the feature files from the steps definitions and the runners. Also, there are different xml suites to separate the execution of the different tests.

## Execution commands

* To run all the tests: *mvn test -Dfile=allTests*
* To run the Valid Login tests: *mvn test -Dfile=validLoginTests*
* To run the Invalid Login tests: *mvn test -Dfile=invalidLoginTests*

## Results

The execution results will be printed in the console, but also there will be created a html report that provides the same information. The path to find the report is `\target\cucumber-reports\cucumber.html`.