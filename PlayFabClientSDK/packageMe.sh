#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.176.221024.jar ../../builds/client-sdk-0.176.221024.jar
