#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.99.191001.jar ../../builds/client-sdk-0.99.191001.jar
