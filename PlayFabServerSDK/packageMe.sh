#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.178.221207.jar ../../builds/server-sdk-0.178.221207.jar
