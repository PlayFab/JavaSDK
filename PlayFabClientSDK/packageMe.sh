#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.118.200901.jar ../../builds/client-sdk-0.118.200901.jar
