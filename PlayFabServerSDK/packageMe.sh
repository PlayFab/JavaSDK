#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.110.200518.jar ../../builds/server-sdk-0.110.200518.jar
