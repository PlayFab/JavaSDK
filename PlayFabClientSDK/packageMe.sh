#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.210.240119.jar ../../builds/client-sdk-0.210.240119.jar
