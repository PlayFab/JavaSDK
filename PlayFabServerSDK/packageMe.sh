#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.149.220316.jar ../../builds/server-sdk-0.149.220316.jar
