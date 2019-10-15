#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.100.191015.jar ../../builds/combo-sdk-0.100.191015.jar
