#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.114.200713.jar ../../builds/server-sdk-0.114.200713.jar
