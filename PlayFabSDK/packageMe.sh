#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.232.250228.jar ../../builds/combo-sdk-0.232.250228.jar
