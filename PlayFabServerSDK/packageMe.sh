#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.107.200330.jar ../../builds/server-sdk-0.107.200330.jar
