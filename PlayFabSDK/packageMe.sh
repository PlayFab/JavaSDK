#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.233.250314.jar ../../builds/combo-sdk-0.233.250314.jar
