<h1 align="center">
  Java test Task "Films  list"
</h1>
<h4>For this project you need java version 1.8</h4>
<h6>All instruction for IntelliJ IDEA </h6>
## 🚀 How to start.

1.  **First of all you need open your advanced Open Source database for example 'pgAdmin 4'.**

2.  **Create database with name "films".**

3.  **Run file with name "Films".**
    ```sh
    # this's file need only for build and insert info database    
        src/main/java/gerteor/Films.java
    ```

4.  **Now you need can start with maven .**   
    ```sh
    # pull up collector maven     
      go in terminal and press 'mvn clean install tomcat7:run'
    or you cant write command 'instal' and do othe points 
    ``` 
5.  **Add new Tomcat configuration .**   
    ```sh
    # you need choes auto generated 'artifact war' file   
       Edit Configuration/ Add new configuration/ Tomcat Server / Fix/ project_GodelT echnologies:war
    ```

6.  **Under your start you need checked project property.**
    ```sh
    # in this file you need checked password and username for DB
        src/main/resources/configuration.properties
    ```
7.  **Run Tomcat Server.**
    ```sh
    # that this project starts run tomcat
    ```
    
##  What's can you see in this project ?.

A quick look at the top-level files and directories you'll see in this project.
  .
    ├── src
    ├── .gitignore
    ├── pom.xnl
    └── README.md
  
1.  **`/src`**: This directory will contain all of the code related to what you will see on the front-end of your site (what you see in the browser) such as your site header or a page template. `src` is a convention for “source code”.  
 
2.  **`.gitignore`**: This file tells git which files it should not track / not maintain a version history for.

3.  **`pom.xml`**: This file contains information about the project and configuration details used by Maven to build the project.

4.  **`README.md`**: A text file containing useful reference information about your project.
