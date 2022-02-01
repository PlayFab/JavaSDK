#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.145.220131.jar ../../builds/client-sdk-0.145.220131.jar
