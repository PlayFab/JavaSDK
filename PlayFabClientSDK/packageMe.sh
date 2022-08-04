#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.167.220804.jar ../../builds/client-sdk-0.167.220804.jar
