#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.219.240621.jar ../../builds/server-sdk-0.219.240621.jar
