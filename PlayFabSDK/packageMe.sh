#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.163.220718.jar ../../builds/combo-sdk-0.163.220718.jar
