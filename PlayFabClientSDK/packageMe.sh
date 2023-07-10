#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.193.230707.jar ../../builds/client-sdk-0.193.230707.jar
