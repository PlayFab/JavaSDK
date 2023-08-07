#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.196.230804.jar ../../builds/combo-sdk-0.196.230804.jar
