#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.256.260313.jar ../../builds/combo-sdk-0.256.260313.jar
