#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.130.210427.jar ../../builds/server-sdk-0.130.210427.jar
