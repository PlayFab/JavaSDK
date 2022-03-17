#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.150.220317.jar ../../builds/client-sdk-0.150.220317.jar
