#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.238.250606.jar ../../builds/combo-sdk-0.238.250606.jar
