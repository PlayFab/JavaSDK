#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.260.260512.jar ../../builds/combo-sdk-0.260.260512.jar
