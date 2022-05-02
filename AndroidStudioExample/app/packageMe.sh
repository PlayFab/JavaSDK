#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.156.220502.jar ../../builds/client-sdk-0.156.220502.jar
