#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.189.230512.jar ../../builds/server-sdk-0.189.230512.jar
