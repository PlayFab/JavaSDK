#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.112.200615.jar ../../builds/client-sdk-0.112.200615.jar
