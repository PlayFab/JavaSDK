#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.188.230428.jar ../../builds/server-sdk-0.188.230428.jar
