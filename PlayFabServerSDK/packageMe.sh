#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.98.190916.jar ../../builds/server-sdk-0.98.190916.jar
