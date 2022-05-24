#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.159.220523.jar ../../builds/server-sdk-0.159.220523.jar
