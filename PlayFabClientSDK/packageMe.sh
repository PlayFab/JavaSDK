#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.195.230721.jar ../../builds/client-sdk-0.195.230721.jar
