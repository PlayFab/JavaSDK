#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.180.230123.jar ../../builds/server-sdk-0.180.230123.jar
