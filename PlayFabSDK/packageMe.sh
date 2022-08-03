#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.165.220802.jar ../../builds/combo-sdk-0.165.220802.jar
