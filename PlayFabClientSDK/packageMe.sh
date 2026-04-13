#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.258.260410.jar ../../builds/client-sdk-0.258.260410.jar
