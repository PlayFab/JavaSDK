#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.133.210628.jar ../../builds/client-sdk-0.133.210628.jar
