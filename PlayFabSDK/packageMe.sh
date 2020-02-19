#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.105.200218.jar ../../builds/combo-sdk-0.105.200218.jar
