#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.108.200402.jar ../../builds/combo-sdk-0.108.200402.jar
