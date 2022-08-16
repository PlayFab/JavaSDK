#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.169.220816.jar ../../builds/combo-sdk-0.169.220816.jar
