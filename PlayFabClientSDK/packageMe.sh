#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.190.230529.jar ../../builds/client-sdk-0.190.230529.jar
