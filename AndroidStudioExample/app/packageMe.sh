#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.138.210927.jar ../../builds/client-sdk-0.138.210927.jar
