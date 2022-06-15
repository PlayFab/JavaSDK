#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.160.220607.jar ../../builds/combo-sdk-0.160.220607.jar
