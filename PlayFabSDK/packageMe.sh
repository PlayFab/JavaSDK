#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.207.231208.jar ../../builds/combo-sdk-0.207.231208.jar
