#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.253.260123.jar ../../builds/combo-sdk-0.253.260123.jar
