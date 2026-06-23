#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.263.260619.jar ../../builds/client-sdk-0.263.260619.jar
