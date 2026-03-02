#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.255.260227.jar ../../builds/server-sdk-0.255.260227.jar
