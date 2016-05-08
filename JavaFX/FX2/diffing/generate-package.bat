@echo off
rem ==== Application packager =====
rem = Script version 1.0, 2016/05 =
rem = Author: Guillaume Diaz      =
rem ===============================

echo.
echo ###########################
echo #  Packaging application  #
echo ###########################
echo.

mkdir target\diffing
mkdir target\diffing\lib
copy target\lib\* target\diffing\lib\
copy target\diffing-jar-with-dependencies.jar target\diffing\diffing.jar
copy src\main\launcher\* target\diffing\

echo.
echo #### Package complete ####
echo Go to "target\diffing" and execute the .bat file
echo.
