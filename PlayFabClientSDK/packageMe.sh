#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.116.200805.jar ../../builds/client-sdk-0.116.200805.jar
