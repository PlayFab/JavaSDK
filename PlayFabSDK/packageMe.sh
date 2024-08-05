#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.221.240802.jar ../../builds/combo-sdk-0.221.240802.jar
