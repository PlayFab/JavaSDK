#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.137.210913.jar ../../builds/combo-sdk-0.137.210913.jar
