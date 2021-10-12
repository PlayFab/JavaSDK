#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.139.211012.jar ../../builds/client-sdk-0.139.211012.jar
