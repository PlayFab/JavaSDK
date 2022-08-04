#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.167.220804.jar ../../builds/server-sdk-0.167.220804.jar
