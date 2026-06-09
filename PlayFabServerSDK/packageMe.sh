#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.262.260605.jar ../../builds/server-sdk-0.262.260605.jar
