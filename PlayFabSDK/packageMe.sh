#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.262.260605.jar ../../builds/combo-sdk-0.262.260605.jar
