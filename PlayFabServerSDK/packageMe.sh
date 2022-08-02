#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.164.220801.jar ../../builds/server-sdk-0.164.220801.jar
