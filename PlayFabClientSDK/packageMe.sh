#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.182.230220.jar ../../builds/client-sdk-0.182.230220.jar
