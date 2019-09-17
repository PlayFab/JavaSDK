#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.98.190916.jar ../../builds/client-sdk-0.98.190916.jar
