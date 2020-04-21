#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.109.200421.jar ../../builds/server-sdk-0.109.200421.jar
