#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.132.210521.jar ../../builds/combo-sdk-0.132.210521.jar
