#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.267.260922.jar ../../builds/server-sdk-0.267.260922.jar
