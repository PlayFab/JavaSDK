#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.99.191001.jar ../../builds/server-sdk-0.99.191001.jar
