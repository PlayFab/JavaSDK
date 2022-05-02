#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.156.220502.jar ../../builds/server-sdk-0.156.220502.jar
