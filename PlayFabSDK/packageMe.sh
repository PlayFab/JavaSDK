#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.145.220131.jar ../../builds/combo-sdk-0.145.220131.jar
