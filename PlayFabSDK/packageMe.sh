#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.217.240514.jar ../../builds/combo-sdk-0.217.240514.jar
