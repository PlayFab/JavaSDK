#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.234.250328.jar ../../builds/combo-sdk-0.234.250328.jar
