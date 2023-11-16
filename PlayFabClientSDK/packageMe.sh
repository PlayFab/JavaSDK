#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.205.231110.jar ../../builds/client-sdk-0.205.231110.jar
