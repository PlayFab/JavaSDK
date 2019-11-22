#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.102.191121.jar ../../builds/combo-sdk-0.102.191121.jar
