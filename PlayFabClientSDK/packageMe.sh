#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.117.200817.jar ../../builds/client-sdk-0.117.200817.jar
