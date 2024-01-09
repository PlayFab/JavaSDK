#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.208.240105.jar ../../builds/server-sdk-0.208.240105.jar
