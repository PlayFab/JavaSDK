#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.129.210406.jar ../../builds/server-sdk-0.129.210406.jar
