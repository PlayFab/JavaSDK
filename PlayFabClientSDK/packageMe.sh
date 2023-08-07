#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.196.230804.jar ../../builds/client-sdk-0.196.230804.jar
