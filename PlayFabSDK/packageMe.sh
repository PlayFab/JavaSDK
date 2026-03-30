#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.257.260327.jar ../../builds/combo-sdk-0.257.260327.jar
