#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.241.250718.jar ../../builds/client-sdk-0.241.250718.jar
