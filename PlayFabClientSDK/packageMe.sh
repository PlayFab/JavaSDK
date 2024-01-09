#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.208.240105.jar ../../builds/client-sdk-0.208.240105.jar
