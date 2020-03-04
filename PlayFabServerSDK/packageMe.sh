#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.106.200303.jar ../../builds/server-sdk-0.106.200303.jar
