#!/usr/bin/bash
rm *.class
javac *.java

rmiregistry

java RMIServer
java RMICLient