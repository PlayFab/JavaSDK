#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.224.240830.jar ../../builds/client-sdk-0.224.240830.jar
