#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.210.240119.jar ../../builds/server-sdk-0.210.240119.jar
