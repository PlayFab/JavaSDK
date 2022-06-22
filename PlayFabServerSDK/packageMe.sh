#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.161.220621.jar ../../builds/server-sdk-0.161.220621.jar
