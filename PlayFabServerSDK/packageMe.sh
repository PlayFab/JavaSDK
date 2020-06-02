#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.111.200602.jar ../../builds/server-sdk-0.111.200602.jar
