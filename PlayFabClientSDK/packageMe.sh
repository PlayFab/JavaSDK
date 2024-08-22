#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.223.240816.jar ../../builds/client-sdk-0.223.240816.jar
