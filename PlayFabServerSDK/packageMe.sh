#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.230.250117.jar ../../builds/server-sdk-0.230.250117.jar
