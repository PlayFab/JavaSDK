#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.205.231110.jar ../../builds/server-sdk-0.205.231110.jar
