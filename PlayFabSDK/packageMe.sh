#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.198.230901.jar ../../builds/combo-sdk-0.198.230901.jar
