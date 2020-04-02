#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.108.200402.jar ../../builds/server-sdk-0.108.200402.jar
