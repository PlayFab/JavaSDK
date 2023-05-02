#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.188.230428.jar ../../builds/client-sdk-0.188.230428.jar
