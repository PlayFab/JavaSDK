#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.95.190821.jar ../../builds/server-sdk-0.95.190821.jar
