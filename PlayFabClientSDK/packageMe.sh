#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.199.230915.jar ../../builds/client-sdk-0.199.230915.jar
