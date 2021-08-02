#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.134.210802.jar ../../builds/client-sdk-0.134.210802.jar
