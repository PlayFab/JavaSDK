#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.149.220316.jar ../../builds/client-sdk-0.149.220316.jar
