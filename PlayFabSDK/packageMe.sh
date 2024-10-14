#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.226.241014.jar ../../builds/combo-sdk-0.226.241014.jar
