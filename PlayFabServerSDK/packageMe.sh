#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.102.191121.jar ../../builds/server-sdk-0.102.191121.jar
