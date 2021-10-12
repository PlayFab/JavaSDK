#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.139.211012.jar ../../builds/combo-sdk-0.139.211012.jar
