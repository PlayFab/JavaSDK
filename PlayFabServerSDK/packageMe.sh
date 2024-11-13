#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.228.241108.jar ../../builds/server-sdk-0.228.241108.jar
