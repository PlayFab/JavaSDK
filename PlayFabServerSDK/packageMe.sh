#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.100.191015.jar ../../builds/server-sdk-0.100.191015.jar
