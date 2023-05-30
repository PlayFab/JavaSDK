#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.190.230529.jar ../../builds/server-sdk-0.190.230529.jar
