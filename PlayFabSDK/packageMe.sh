#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.225.240913.jar ../../builds/combo-sdk-0.225.240913.jar
