#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.244.250912.jar ../../builds/client-sdk-0.244.250912.jar
