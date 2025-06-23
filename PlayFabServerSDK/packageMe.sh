#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.239.250620.jar ../../builds/server-sdk-0.239.250620.jar
