#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.225.240913.jar ../../builds/client-sdk-0.225.240913.jar
