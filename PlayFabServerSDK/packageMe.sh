#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.163.220718.jar ../../builds/server-sdk-0.163.220718.jar
