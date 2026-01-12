#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.252.260109.jar ../../builds/combo-sdk-0.252.260109.jar
