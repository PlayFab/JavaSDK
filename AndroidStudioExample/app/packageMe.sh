#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.238.250606.jar ../../builds/client-sdk-0.238.250606.jar
