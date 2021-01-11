#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.125.210111.jar ../../builds/client-sdk-0.125.210111.jar
