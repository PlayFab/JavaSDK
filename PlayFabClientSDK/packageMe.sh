#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.144.220118.jar ../../builds/client-sdk-0.144.220118.jar
