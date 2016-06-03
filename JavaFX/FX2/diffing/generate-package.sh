#!/bin/bash
#  
# Script to package a JavaFX2 application
# Author: Guillaume Diaz
# Version: 1.0 - 2016/05
#

echo "JavaFX2 application packager script..."
mkdir target/diffing-ui-fx2
cp src/main/launcher/* target/diffing-ui-fx2/
cp -r target/lib/ target/diffing-ui-fx2/
cp target/diffing-ui-fx2-jar-with-dependencies.jar target/diffing-ui-fx2/diffing.jar
chmod 755 target/diffing-ui-fx2/*.sh
echo "Package complete! To run the application:"
echo "  cd target/diffing-ui-fx2"
echo "  ./diffing.sh"
echo " "
