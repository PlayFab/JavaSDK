#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.250.251205.jar ../../builds/combo-sdk-0.250.251205.jar
