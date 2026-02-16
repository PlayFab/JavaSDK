#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.254.260213.jar ../../builds/server-sdk-0.254.260213.jar
