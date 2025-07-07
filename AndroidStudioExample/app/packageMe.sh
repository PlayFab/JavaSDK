#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.240.250704.jar ../../builds/client-sdk-0.240.250704.jar
