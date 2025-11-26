#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.249.251121.jar ../../builds/client-sdk-0.249.251121.jar
