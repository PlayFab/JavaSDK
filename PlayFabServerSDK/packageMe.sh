#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.116.200805.jar ../../builds/server-sdk-0.116.200805.jar
