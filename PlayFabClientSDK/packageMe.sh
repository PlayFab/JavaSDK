#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.153.220406.jar ../../builds/client-sdk-0.153.220406.jar
