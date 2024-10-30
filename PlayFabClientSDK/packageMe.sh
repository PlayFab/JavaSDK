#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.227.241025.jar ../../builds/client-sdk-0.227.241025.jar
