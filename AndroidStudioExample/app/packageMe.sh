#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.160.220607.jar ../../builds/client-sdk-0.160.220607.jar
