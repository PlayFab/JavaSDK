#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.265.260805.jar ../../builds/server-sdk-0.265.260805.jar
