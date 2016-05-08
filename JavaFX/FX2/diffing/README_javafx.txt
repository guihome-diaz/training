JAVA FX 2
-----------------------------

History:
* Java6 = JavaFX (failure) 
* Java7 = JavaFX2 (redesign from scratch)
* Java8 = JavaFX8 (same as JavaFX2, the version now matches the current JDK)


------------------
    Maven
------------------
JavaFX2 is NOT designed for Maven. Only JavaFX8 is. 
As a result you must do some tricks to use Maven + JavaFX.

1. You must embedded javaFX as a dependency. 
   => You need to retrieve it from your JDK folder (jfxrt.jar)
   => 2 solutions are possible:
        a) Use a SYSTEM dependency (= set the file path)
        b) Use a project's repository (= setup a Maven repository inside the current project ; then use it). 
           This approach is better because it can be used by Maven Assembly & Shade plugins  
        
2. You must use some ANT script for the packaging. This was originally designed to be used as standalone tool or by NetBeans IDE.
   => You need to add "ant-javafx.jar" from your JDK

3. You must tell maven to include all FXML and other resources
   see <build> <resources> section

4. To create a standalone you have:
   a) Put all dependencies into dedicated folder [maven dependency]
   b) Add some properties to the output jar (MANIFEST + main class) [maven jar]
   c) Generate runnable jar with some launcher script [javafx-ant script]
   d) Package all that [maven assembly]
 
 


** How to setup a Maven repository inside the current project? **
1. Create a root folder to host the repository ("${project.basedir}/libs") + add the <repository> declaration 

2. Manually add each dependency into the local repository:
    mvn install:install-file -Dfile=/usr/lib/jvm/java-7-oracle/jre/lib/jfxrt.jar -DgroupId=com.oracle -DartifactId=javafx -Dversion=2.2 -Dpackaging=jar -DlocalRepositoryPath=libs
    mvn install:install-file -Dfile=/usr/lib/jvm/java-7-oracle/lib/ant-javafx.jar -DgroupId=com.oracle -DartifactId=ant-javafx -Dversion=2.2 -Dpackaging=jar -DlocalRepositoryPath=libs 
    mvn install:install-file -Dfile=javafx-dialogs-0.0.4.jar -DgroupId=ch.makery -DartifactId=javafx-dialogs -Dversion=0.0.4 -Dpackaging=jar -DlocalRepositoryPath=libs 

3. You can now use these libraries as normal dependencies



------------------
FXML
------------------
Put the following command on your FXML attribute to stretch it automatically on window resize: 
    AnchorPane.bottomAnchor="0.0" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="0.0" AnchorPane.topAnchor="0.0"
  
To stretch some input don't forget to add the following: 
    VBox.vgrow="ALWAYS"
    
    
    
------------------
Resources
------------------
Good tutorial:
* http://code.makery.ch/library/javafx-8-tutorial/part1/



------------------
Credits
------------------
* JavaFx2 dialogs: http://code.makery.ch/blog/javafx-2-dialogs/

    