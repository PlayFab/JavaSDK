#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.141.211108.jar ../../builds/server-sdk-0.141.211108.jar
