#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.192.230623.jar ../../builds/client-sdk-0.192.230623.jar
