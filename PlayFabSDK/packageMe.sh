#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.159.220523.jar ../../builds/combo-sdk-0.159.220523.jar
