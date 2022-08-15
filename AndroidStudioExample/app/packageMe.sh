#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.168.220815.jar ../../builds/client-sdk-0.168.220815.jar
