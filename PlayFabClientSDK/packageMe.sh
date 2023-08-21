#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.197.230818.jar ../../builds/client-sdk-0.197.230818.jar
