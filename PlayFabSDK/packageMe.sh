#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.236.250512.jar ../../builds/combo-sdk-0.236.250512.jar
