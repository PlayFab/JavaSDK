#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.192.230623.jar ../../builds/server-sdk-0.192.230623.jar
