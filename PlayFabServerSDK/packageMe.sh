#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.168.220815.jar ../../builds/server-sdk-0.168.220815.jar
