#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.207.231208.jar ../../builds/client-sdk-0.207.231208.jar
