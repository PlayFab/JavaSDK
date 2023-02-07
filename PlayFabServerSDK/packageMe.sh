#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.181.230206.jar ../../builds/server-sdk-0.181.230206.jar
