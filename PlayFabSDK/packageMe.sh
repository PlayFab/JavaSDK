#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.229.241122.jar ../../builds/combo-sdk-0.229.241122.jar
