#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.96.190828.jar ../../builds/combo-sdk-0.96.190828.jar
