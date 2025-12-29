#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.251.251219.jar ../../builds/combo-sdk-0.251.251219.jar
