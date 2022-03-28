#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.152.220328.jar ../../builds/client-sdk-0.152.220328.jar
