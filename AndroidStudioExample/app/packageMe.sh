#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.146.220214.jar ../../builds/client-sdk-0.146.220214.jar
