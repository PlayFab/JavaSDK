#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.109.200421.jar ../../builds/combo-sdk-0.109.200421.jar
