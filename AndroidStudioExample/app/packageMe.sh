#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.189.230512.jar ../../builds/client-sdk-0.189.230512.jar
