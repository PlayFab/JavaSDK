#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.171.220907.jar ../../builds/server-sdk-0.171.220907.jar
