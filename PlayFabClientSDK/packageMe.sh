#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.186.230403.jar ../../builds/client-sdk-0.186.230403.jar
