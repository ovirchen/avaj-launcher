#!/bin/sh
mkdir out
find ./ -name "*.java" > sources.txt
javac @sources.txt -d out
cd out
java com/simulator/Simulator ../scenario.txt
cat -e simulation.txt
cd ../
rm -rf out