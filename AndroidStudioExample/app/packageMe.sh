#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.115.200730.jar ../../builds/client-sdk-0.115.200730.jar
