#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.153.220406.jar ../../builds/server-sdk-0.153.220406.jar
