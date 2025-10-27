#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.247.251024.jar ../../builds/client-sdk-0.247.251024.jar
