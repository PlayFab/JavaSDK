#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.247.251024.jar ../../builds/combo-sdk-0.247.251024.jar
