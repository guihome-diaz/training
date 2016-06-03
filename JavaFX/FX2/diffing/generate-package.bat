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

mkdir target\diffing-ui-fx2
mkdir target\diffing-ui-fx2\lib
copy target\lib\* target\diffing-ui-fx2\lib\
copy target\diffing-ui-fx2-jar-with-dependencies.jar target\diffing-ui-fx2\diffing.jar
copy src\main\launcher\* target\diffing\

echo.
echo #### Package complete ####
echo Go to "target\diffing-ui-fx2" and execute the diffing.bat file
echo.
