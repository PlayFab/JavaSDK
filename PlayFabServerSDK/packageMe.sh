#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.215.240412.jar ../../builds/server-sdk-0.215.240412.jar
