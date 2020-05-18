#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.110.200518.jar ../../builds/client-sdk-0.110.200518.jar
