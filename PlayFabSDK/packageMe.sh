#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.146.220214.jar ../../builds/combo-sdk-0.146.220214.jar
