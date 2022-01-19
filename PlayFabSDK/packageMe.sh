#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.144.220118.jar ../../builds/combo-sdk-0.144.220118.jar
