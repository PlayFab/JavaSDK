#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.211.240202.jar ../../builds/server-sdk-0.211.240202.jar
