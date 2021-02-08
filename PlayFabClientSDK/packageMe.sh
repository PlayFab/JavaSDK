#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.127.210208.jar ../../builds/client-sdk-0.127.210208.jar
