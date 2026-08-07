#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.265.260805.jar ../../builds/combo-sdk-0.265.260805.jar
