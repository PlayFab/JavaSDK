#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.205.231110.jar ../../builds/combo-sdk-0.205.231110.jar
