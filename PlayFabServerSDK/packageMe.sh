#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.245.250926.jar ../../builds/server-sdk-0.245.250926.jar
