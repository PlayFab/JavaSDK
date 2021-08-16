#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.135.210816.jar ../../builds/client-sdk-0.135.210816.jar
