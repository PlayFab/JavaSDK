#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.162.220704.jar ../../builds/client-sdk-0.162.220704.jar
