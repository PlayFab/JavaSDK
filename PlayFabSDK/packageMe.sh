#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.261.260526.jar ../../builds/combo-sdk-0.261.260526.jar
