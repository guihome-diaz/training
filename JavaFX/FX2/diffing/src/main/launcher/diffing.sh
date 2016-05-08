#!/bin/bash
#
# Simple script to execute the JavaFX application using Java7. 
#
# (i) due to the JavaFX dialogs you cannot run that application with Java8.40+ 
#     ==> You must switch to the official JFX Dialogs and recompile
#
echo "Launching application with Java7" 
/usr/lib/jvm/java-7-oracle/bin/java -jar diffing.jar
