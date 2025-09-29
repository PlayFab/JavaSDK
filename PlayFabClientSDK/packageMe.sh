#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.245.250926.jar ../../builds/client-sdk-0.245.250926.jar
