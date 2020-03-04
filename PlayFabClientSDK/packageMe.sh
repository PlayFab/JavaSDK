#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.106.200303.jar ../../builds/client-sdk-0.106.200303.jar
