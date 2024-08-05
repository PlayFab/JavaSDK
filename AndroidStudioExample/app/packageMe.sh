#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.221.240802.jar ../../builds/client-sdk-0.221.240802.jar
