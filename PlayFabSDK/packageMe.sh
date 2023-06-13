#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.191.230609.jar ../../builds/combo-sdk-0.191.230609.jar
