#!/bin/bash
javac App.java
javac Printer.java
javac InputManager.java
javac GameLogic.java

mv *.class target/

cd target/
java App