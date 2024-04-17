#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.215.240412.jar ../../builds/client-sdk-0.215.240412.jar
