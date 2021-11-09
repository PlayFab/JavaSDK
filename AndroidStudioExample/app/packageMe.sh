#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.141.211108.jar ../../builds/client-sdk-0.141.211108.jar
