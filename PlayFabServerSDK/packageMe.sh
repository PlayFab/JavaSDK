#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.176.221024.jar ../../builds/server-sdk-0.176.221024.jar
