#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.117.200817.jar ../../builds/server-sdk-0.117.200817.jar
