#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.206.231124.jar ../../builds/client-sdk-0.206.231124.jar
