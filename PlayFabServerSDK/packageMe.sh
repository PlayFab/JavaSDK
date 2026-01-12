#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.252.260109.jar ../../builds/server-sdk-0.252.260109.jar
