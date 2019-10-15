#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.100.191015.jar ../../builds/client-sdk-0.100.191015.jar
