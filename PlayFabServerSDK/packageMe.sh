#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.126.210125.jar ../../builds/server-sdk-0.126.210125.jar
