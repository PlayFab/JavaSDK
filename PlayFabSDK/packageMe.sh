#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.177.221107.jar ../../builds/combo-sdk-0.177.221107.jar
