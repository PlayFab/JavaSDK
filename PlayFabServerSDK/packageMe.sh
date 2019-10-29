#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.101.191029.jar ../../builds/server-sdk-0.101.191029.jar
