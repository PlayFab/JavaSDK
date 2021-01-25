#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.126.210125.jar ../../builds/client-sdk-0.126.210125.jar
