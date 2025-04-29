#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.235.250428.jar ../../builds/client-sdk-0.235.250428.jar
