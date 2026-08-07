#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.265.260805.jar ../../builds/client-sdk-0.265.260805.jar
