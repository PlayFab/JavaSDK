#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.251.251219.jar ../../builds/server-sdk-0.251.251219.jar
