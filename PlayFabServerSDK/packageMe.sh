#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.152.220328.jar ../../builds/server-sdk-0.152.220328.jar
