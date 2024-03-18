#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.213.240315.jar ../../builds/client-sdk-0.213.240315.jar
