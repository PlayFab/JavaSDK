#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.103.191218.jar ../../builds/server-sdk-0.103.191218.jar
