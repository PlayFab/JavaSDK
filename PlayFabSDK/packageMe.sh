#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.135.210816.jar ../../builds/combo-sdk-0.135.210816.jar
