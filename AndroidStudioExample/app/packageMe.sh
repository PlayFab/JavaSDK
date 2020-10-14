#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.121.201014.jar ../../builds/client-sdk-0.121.201014.jar
