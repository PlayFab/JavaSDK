#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.252.260109.jar ../../builds/client-sdk-0.252.260109.jar
