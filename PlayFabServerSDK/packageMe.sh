#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.225.240913.jar ../../builds/server-sdk-0.225.240913.jar
