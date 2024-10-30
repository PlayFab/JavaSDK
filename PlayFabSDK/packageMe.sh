#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.227.241025.jar ../../builds/combo-sdk-0.227.241025.jar
