#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.256.260313.jar ../../builds/client-sdk-0.256.260313.jar
