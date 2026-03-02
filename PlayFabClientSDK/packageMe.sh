#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.255.260227.jar ../../builds/client-sdk-0.255.260227.jar
