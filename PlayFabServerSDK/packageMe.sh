#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.237.250526.jar ../../builds/server-sdk-0.237.250526.jar
