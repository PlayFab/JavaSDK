#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.165.220802.jar ../../builds/server-sdk-0.165.220802.jar
