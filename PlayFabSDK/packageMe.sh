#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.243.250815.jar ../../builds/combo-sdk-0.243.250815.jar
