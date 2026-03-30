#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.257.260327.jar ../../builds/server-sdk-0.257.260327.jar
