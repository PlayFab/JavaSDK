#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.171.220907.jar ../../builds/client-sdk-0.171.220907.jar
