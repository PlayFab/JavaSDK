#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.178.221207.jar ../../builds/combo-sdk-0.178.221207.jar
