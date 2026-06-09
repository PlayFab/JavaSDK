#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.262.260605.jar ../../builds/client-sdk-0.262.260605.jar
