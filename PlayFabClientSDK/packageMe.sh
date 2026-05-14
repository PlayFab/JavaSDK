#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.260.260512.jar ../../builds/client-sdk-0.260.260512.jar
