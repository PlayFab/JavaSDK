#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.111.200602.jar ../../builds/combo-sdk-0.111.200602.jar
