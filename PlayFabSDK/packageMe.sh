#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.114.200713.jar ../../builds/combo-sdk-0.114.200713.jar
