#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.236.250512.jar ../../builds/client-sdk-0.236.250512.jar
