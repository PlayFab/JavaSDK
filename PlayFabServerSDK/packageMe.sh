#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.244.250912.jar ../../builds/server-sdk-0.244.250912.jar
