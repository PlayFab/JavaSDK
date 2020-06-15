#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.112.200615.jar ../../builds/combo-sdk-0.112.200615.jar
