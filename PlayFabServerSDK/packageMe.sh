#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.246.251010.jar ../../builds/server-sdk-0.246.251010.jar
