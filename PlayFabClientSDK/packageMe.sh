#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.174.220926.jar ../../builds/client-sdk-0.174.220926.jar
