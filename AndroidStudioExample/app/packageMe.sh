#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.214.240401.jar ../../builds/client-sdk-0.214.240401.jar
