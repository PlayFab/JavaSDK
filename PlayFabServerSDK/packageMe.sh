#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.232.250228.jar ../../builds/server-sdk-0.232.250228.jar
