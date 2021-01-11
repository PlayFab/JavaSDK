#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.125.210111.jar ../../builds/server-sdk-0.125.210111.jar
