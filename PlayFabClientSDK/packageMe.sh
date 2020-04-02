#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.108.200402.jar ../../builds/client-sdk-0.108.200402.jar
