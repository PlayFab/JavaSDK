#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.96.190828.jar ../../builds/client-sdk-0.96.190828.jar
