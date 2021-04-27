#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.130.210427.jar ../../builds/client-sdk-0.130.210427.jar
