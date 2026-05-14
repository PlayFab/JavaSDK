#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.260.260512.jar ../../builds/server-sdk-0.260.260512.jar
