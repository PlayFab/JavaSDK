#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.217.240514.jar ../../builds/server-sdk-0.217.240514.jar
