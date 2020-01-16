#!/usr/bin/env bash

javac -d build Test.java
java -agentlib:native-image-agent=config-merge-dir=META-INF/native-image -classpath build Test

# native-image-agent will create required reflection configuration
