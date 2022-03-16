#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.149.220316.jar ../../builds/combo-sdk-0.149.220316.jar
