#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.135.210816.jar ../../builds/server-sdk-0.135.210816.jar
