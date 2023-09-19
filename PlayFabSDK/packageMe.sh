#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.199.230915.jar ../../builds/combo-sdk-0.199.230915.jar
