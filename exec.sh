#!/bin/bash

gum spin javac App.java Printer.java InputManager.java GameLogic.java --spinner dot --title "Compiling Java files..."

mv *.class target/

cd target/
java App