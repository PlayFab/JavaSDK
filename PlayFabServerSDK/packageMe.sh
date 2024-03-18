#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.213.240315.jar ../../builds/server-sdk-0.213.240315.jar
