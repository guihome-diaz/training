# JavaFX2 

This is a working JavaFX2 project with:
* Maven support
* JavaFX dialogs (3rd party)
* Creation of a standalone uber jar + packaging scripts


## Maven configuration

JavaFX2 is NOT designed for Maven. Only JavaFX8 is. 
As a result you must do some tricks to use Maven + JavaFX.

#### 1. Add JavaFX as a dependency

**Alternative 1** 

Use a `SYSTEM dependency` (= set the file path) and retrieve JavaFX from your JDK folder (`jfxrt.jar`)

```xml  
    <properties>
        <javafx.version>2.2</javafx.version>
        <jdk7.home>/usr/lib/jvm/java-7-oracle</jdk7.home>
        <javafx.home>${jdk7.home}/jre/lib/jfxrt.jar</javafx.home>
        <javafx.ant>${jdk7.home}/lib/ant-javafx.jar</javafx.ant>      
    </properties>
    ...
    <dependencies>
        <dependency>
            <groupId>com.oracle</groupId>
            <artifactId>javafx</artifactId>
            <version>${javafx.version}</version>
            <scope>system</scope>
            <systemPath>${jdk7.home}/jre/lib/jfxrt.jar</systemPath>
        </dependency>
    </dependencies>
```
  
**Alternative 2** (recommended)

use a `project's repository` = setup a Maven repository inside the current project then use it. 

* Create a root folder to host the repository `${project.basedir}/libs` 
* Add the local repository declaration 
```xml
    <repositories>
        <repository>
            <id>in-project</id>
            <name>In Project Repository</name>
            <url>file://${project.basedir}/libs</url>
        </repository>
    </repositories>
```

* Manually add each dependency into the local repository:
```bash
mvn install:install-file -Dfile=/usr/lib/jvm/java-7-oracle/jre/lib/jfxrt.jar -DgroupId=com.oracle -DartifactId=javafx -Dversion=2.2 -Dpackaging=jar -DlocalRepositoryPath=libs

mvn install:install-file -Dfile=/usr/lib/jvm/java-7-oracle/lib/ant-javafx.jar -DgroupId=com.oracle -DartifactId=ant-javafx -Dversion=2.2 -Dpackaging=jar -DlocalRepositoryPath=libs

mvn install:install-file -Dfile=javafx-dialogs-0.0.4.jar -DgroupId=ch.makery -DartifactId=javafx-dialogs -Dversion=0.0.4 -Dpackaging=jar -DlocalRepositoryPath=libs
```

* You can now use these libraries as normal dependencies
```xml

    <dependencies>
        <dependency>
            <groupId>com.oracle</groupId>
            <artifactId>javafx</artifactId>
            <version>2.2</version>
        </dependency>
    </dependencies>
```   




#### 2. Ant script for the packaging

You must use some ANT script. This was originally designed to be used as standalone tool or by NetBeans IDE.

* You need to add `ant-javafx.jar` from your JDK


#### 3. Resources

You must tell Maven to include all FXML and other resources (css, images, ...). 
```xml
    <build>
        <!-- Artifact name -->
        <finalName>diffing</finalName>
        
        <!-- Include all resources in the output artifact (FXML, CSS, images, etc.) -->
        <resources>
            <resource>
                <filtering>false</filtering>
                <directory>${basedir}/src/main/java</directory>
                <includes>
                    <include>**/*.fxml</include>
                </includes>
            </resource>
            <resource>
                <filtering>false</filtering>
                <directory>${basedir}/src/main/resources</directory>
                <includes>
                    <include>**/*.*</include>
                </includes>
            </resource>
        </resources>
```

#### 4. To create a standalone you have:

* Put all dependencies into dedicated folder [`maven dependency`]
* Add some properties to the output jar (MANIFEST + main class) [`maven jar`]
* Generate runnable jar with some launcher script [`javafx-ant script`]
* Package all that [`maven assembly`]
 


## FXML

* To stretch layout, add the FXML attributes: 

`AnchorPane.bottomAnchor="0.0" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="0.0" AnchorPane.topAnchor="0.0"`
  
  
* To stretch inputs (text area, butons, label, web view): `VBox.vgrow="ALWAYS"`
    
    
    
## Resources
* [JavaFX tutorial](http://code.makery.ch/library/javafx-8-tutorial/part1/)



## Credits
* [JavaFX dialogs - Markery.ch](http://code.makery.ch/blog/javafx-2-dialogs/)

    