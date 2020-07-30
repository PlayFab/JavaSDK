#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.115.200730.jar ../../builds/combo-sdk-0.115.200730.jar
