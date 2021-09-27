#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.138.210927.jar ../../builds/combo-sdk-0.138.210927.jar
