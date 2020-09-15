#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.119.200914.jar ../../builds/client-sdk-0.119.200914.jar
