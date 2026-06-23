#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.263.260619.jar ../../builds/server-sdk-0.263.260619.jar
