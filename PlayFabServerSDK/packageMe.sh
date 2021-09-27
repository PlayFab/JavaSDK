#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.138.210927.jar ../../builds/server-sdk-0.138.210927.jar
