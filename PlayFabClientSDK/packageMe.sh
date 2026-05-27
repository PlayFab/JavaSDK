#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.261.260526.jar ../../builds/client-sdk-0.261.260526.jar
