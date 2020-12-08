#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.123.201207.jar ../../builds/server-sdk-0.123.201207.jar
