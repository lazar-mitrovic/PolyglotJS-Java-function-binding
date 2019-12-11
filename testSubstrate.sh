#!/usr/bin/env bash

javac -d build Test.java
pushd build
native-image --language:js Test
popd
./build/test
