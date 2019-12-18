#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.103.191218.jar ../../builds/client-sdk-0.103.191218.jar
