#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.242.250801.jar ../../builds/combo-sdk-0.242.250801.jar
