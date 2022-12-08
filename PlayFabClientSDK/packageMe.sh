#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.178.221207.jar ../../builds/client-sdk-0.178.221207.jar
