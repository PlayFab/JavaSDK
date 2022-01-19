#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.144.220118.jar ../../builds/server-sdk-0.144.220118.jar
