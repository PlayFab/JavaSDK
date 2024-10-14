#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.226.241014.jar ../../builds/server-sdk-0.226.241014.jar
