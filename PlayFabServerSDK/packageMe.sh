#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.233.250314.jar ../../builds/server-sdk-0.233.250314.jar
