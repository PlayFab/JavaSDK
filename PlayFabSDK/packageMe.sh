#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.158.220509.jar ../../builds/combo-sdk-0.158.220509.jar
