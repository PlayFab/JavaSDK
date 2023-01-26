#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.180.230123.jar ../../builds/client-sdk-0.180.230123.jar
