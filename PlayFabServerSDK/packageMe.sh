#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.236.250512.jar ../../builds/server-sdk-0.236.250512.jar
