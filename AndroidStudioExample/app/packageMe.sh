#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.163.220718.jar ../../builds/client-sdk-0.163.220718.jar
