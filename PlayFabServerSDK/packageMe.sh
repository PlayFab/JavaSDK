#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.139.211012.jar ../../builds/server-sdk-0.139.211012.jar
