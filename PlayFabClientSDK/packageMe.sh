#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.229.241122.jar ../../builds/client-sdk-0.229.241122.jar
