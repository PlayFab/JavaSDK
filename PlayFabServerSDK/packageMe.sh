#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.121.201014.jar ../../builds/server-sdk-0.121.201014.jar
