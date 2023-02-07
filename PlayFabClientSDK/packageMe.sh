#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.181.230206.jar ../../builds/client-sdk-0.181.230206.jar
