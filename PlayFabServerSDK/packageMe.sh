#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.249.251121.jar ../../builds/server-sdk-0.249.251121.jar
