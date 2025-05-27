#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.237.250526.jar ../../builds/client-sdk-0.237.250526.jar
