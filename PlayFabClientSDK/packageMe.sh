#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.230.250117.jar ../../builds/client-sdk-0.230.250117.jar
