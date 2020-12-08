#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.123.201207.jar ../../builds/client-sdk-0.123.201207.jar
