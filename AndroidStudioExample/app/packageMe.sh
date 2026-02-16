#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.254.260213.jar ../../builds/client-sdk-0.254.260213.jar
