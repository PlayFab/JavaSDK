#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.175.221010.jar ../../builds/combo-sdk-0.175.221010.jar
