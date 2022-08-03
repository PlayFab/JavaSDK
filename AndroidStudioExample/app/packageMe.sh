#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.165.220802.jar ../../builds/client-sdk-0.165.220802.jar
