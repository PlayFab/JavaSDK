#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.161.220621.jar ../../builds/client-sdk-0.161.220621.jar
