#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.191.230609.jar ../../builds/client-sdk-0.191.230609.jar
