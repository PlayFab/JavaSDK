#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.239.250620.jar ../../builds/client-sdk-0.239.250620.jar
