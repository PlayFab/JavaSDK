#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.148.220305.jar ../../builds/server-sdk-0.148.220305.jar
