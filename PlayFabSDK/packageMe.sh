#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.213.240315.jar ../../builds/combo-sdk-0.213.240315.jar
