#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.220.240719.jar ../../builds/server-sdk-0.220.240719.jar
