#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.223.240816.jar ../../builds/combo-sdk-0.223.240816.jar
