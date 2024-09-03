#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.224.240830.jar ../../builds/server-sdk-0.224.240830.jar
