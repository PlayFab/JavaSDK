#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.216.240426.jar ../../builds/server-sdk-0.216.240426.jar
