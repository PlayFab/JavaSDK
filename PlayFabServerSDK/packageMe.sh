#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.177.221107.jar ../../builds/server-sdk-0.177.221107.jar
