#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.256.260313.jar ../../builds/server-sdk-0.256.260313.jar
