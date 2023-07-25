#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.195.230721.jar ../../builds/server-sdk-0.195.230721.jar
