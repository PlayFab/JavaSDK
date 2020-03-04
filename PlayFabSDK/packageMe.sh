#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.106.200303.jar ../../builds/combo-sdk-0.106.200303.jar
