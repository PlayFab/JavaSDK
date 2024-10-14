#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.226.241014.jar ../../builds/client-sdk-0.226.241014.jar
