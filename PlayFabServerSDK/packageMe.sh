#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.221.240802.jar ../../builds/server-sdk-0.221.240802.jar
