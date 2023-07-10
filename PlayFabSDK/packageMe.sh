#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.193.230707.jar ../../builds/combo-sdk-0.193.230707.jar
