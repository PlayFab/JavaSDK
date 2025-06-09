#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.238.250606.jar ../../builds/server-sdk-0.238.250606.jar
