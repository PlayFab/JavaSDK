#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.110.200518.jar ../../builds/combo-sdk-0.110.200518.jar
