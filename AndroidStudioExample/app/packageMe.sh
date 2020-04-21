#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.109.200421.jar ../../builds/client-sdk-0.109.200421.jar
