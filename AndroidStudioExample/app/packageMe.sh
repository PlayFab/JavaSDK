#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.232.250228.jar ../../builds/client-sdk-0.232.250228.jar
