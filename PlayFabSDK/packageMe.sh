#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.123.201207.jar ../../builds/combo-sdk-0.123.201207.jar
