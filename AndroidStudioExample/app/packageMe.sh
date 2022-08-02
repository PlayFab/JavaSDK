#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.164.220801.jar ../../builds/client-sdk-0.164.220801.jar
