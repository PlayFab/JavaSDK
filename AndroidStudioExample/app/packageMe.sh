#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.218.240524.jar ../../builds/client-sdk-0.218.240524.jar
