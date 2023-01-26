#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.180.230123.jar ../../builds/combo-sdk-0.180.230123.jar
