#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.210.240119.jar ../../builds/combo-sdk-0.210.240119.jar
