#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.99.191001.jar ../../builds/combo-sdk-0.99.191001.jar
