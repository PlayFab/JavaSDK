#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.168.220815.jar ../../builds/combo-sdk-0.168.220815.jar
