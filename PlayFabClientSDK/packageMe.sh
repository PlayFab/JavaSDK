#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.129.210406.jar ../../builds/client-sdk-0.129.210406.jar
