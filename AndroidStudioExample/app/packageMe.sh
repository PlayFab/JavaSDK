#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.177.221107.jar ../../builds/client-sdk-0.177.221107.jar
