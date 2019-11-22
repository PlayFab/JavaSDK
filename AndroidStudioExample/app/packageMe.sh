#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.102.191121.jar ../../builds/client-sdk-0.102.191121.jar
