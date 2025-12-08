#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.250.251205.jar ../../builds/server-sdk-0.250.251205.jar
