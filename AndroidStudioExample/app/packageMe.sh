#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.250.251205.jar ../../builds/client-sdk-0.250.251205.jar
