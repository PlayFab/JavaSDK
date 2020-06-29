#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.113.200629.jar ../../builds/combo-sdk-0.113.200629.jar
