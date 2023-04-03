#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.186.230403.jar ../../builds/server-sdk-0.186.230403.jar
