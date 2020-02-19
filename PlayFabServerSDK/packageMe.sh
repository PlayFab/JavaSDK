#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.105.200218.jar ../../builds/server-sdk-0.105.200218.jar
