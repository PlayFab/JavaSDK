#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.95.190821.jar ../../builds/client-sdk-0.95.190821.jar
