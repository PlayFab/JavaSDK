#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.249.251121.jar ../../builds/combo-sdk-0.249.251121.jar
