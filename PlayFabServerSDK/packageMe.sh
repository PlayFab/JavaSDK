#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.235.250428.jar ../../builds/server-sdk-0.235.250428.jar
