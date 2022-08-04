#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.167.220804.jar ../../builds/combo-sdk-0.167.220804.jar
