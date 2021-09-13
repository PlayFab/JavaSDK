#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.137.210913.jar ../../builds/server-sdk-0.137.210913.jar
