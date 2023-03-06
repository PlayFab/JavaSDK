#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.183.230306.jar ../../builds/combo-sdk-0.183.230306.jar
