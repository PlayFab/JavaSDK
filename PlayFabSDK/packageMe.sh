#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.215.240412.jar ../../builds/combo-sdk-0.215.240412.jar
