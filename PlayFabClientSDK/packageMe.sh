#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.128.210315.jar ../../builds/client-sdk-0.128.210315.jar
