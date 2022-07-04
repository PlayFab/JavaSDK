#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.162.220704.jar ../../builds/combo-sdk-0.162.220704.jar
