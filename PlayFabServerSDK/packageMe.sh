#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.223.240816.jar ../../builds/server-sdk-0.223.240816.jar
