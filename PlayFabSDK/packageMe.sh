#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.134.210802.jar ../../builds/combo-sdk-0.134.210802.jar
