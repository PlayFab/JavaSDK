#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.212.240301.jar ../../builds/client-sdk-0.212.240301.jar
