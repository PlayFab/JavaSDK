#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.152.220328.jar ../../builds/combo-sdk-0.152.220328.jar
