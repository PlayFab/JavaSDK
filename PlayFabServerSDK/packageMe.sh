#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.128.210315.jar ../../builds/server-sdk-0.128.210315.jar
