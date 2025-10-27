#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.247.251024.jar ../../builds/server-sdk-0.247.251024.jar
