#!/bin/bash
#  
# Script to package a JavaFX2 application
# Author: Guillaume Diaz
# Version: 1.0 - 2016/05
#

echo "JavaFX2 application packager script..."
mkdir target/package
cp src/main/launcher/* target/package/
cp -r target/lib/ target/package/
cp target/diffing-jar-with-dependencies.jar target/package/diffing.jar
chmod 755 target/package/*.sh
echo "Package complete! To run the application:"
echo "  cd target/package"
echo "  ./diffing.sh"
echo " "
