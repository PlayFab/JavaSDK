#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.111.200602.jar ../../builds/client-sdk-0.111.200602.jar
