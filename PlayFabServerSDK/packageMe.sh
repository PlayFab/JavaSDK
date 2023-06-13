#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.191.230609.jar ../../builds/server-sdk-0.191.230609.jar
