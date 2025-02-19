#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.231.250214.jar ../../builds/server-sdk-0.231.250214.jar
