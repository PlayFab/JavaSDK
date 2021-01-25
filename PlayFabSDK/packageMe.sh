#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.126.210125.jar ../../builds/combo-sdk-0.126.210125.jar
