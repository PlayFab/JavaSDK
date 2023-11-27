#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.206.231124.jar ../../builds/server-sdk-0.206.231124.jar
