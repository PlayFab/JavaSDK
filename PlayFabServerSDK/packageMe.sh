#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.182.230220.jar ../../builds/server-sdk-0.182.230220.jar
