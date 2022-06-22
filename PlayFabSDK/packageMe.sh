#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.161.220621.jar ../../builds/combo-sdk-0.161.220621.jar
