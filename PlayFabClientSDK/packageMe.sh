#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.158.220509.jar ../../builds/client-sdk-0.158.220509.jar
