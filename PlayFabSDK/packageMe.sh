#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.128.210315.jar ../../builds/combo-sdk-0.128.210315.jar
