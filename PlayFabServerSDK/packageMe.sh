#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.229.241122.jar ../../builds/server-sdk-0.229.241122.jar
