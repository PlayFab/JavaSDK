#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.101.191029.jar ../../builds/client-sdk-0.101.191029.jar
