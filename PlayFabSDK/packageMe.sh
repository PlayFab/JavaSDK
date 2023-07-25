#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.195.230721.jar ../../builds/combo-sdk-0.195.230721.jar
