#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.237.250526.jar ../../builds/combo-sdk-0.237.250526.jar
