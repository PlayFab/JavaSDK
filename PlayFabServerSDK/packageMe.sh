#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.122.201027.jar ../../builds/server-sdk-0.122.201027.jar
