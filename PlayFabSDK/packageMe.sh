#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.153.220406.jar ../../builds/combo-sdk-0.153.220406.jar
