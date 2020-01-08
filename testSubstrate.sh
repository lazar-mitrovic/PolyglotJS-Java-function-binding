#!/usr/bin/env bash

rm -rd build
mkdir -p build/
cp -rd META-INF build/
javac -d build Test.java
pushd build
native-image --language:js Test
popd
./build/test
