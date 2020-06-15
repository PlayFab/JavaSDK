#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.112.200615.jar ../../builds/server-sdk-0.112.200615.jar
