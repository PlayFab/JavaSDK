#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.182.230220.jar ../../builds/combo-sdk-0.182.230220.jar
