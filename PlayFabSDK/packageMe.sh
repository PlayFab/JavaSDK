#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.176.221024.jar ../../builds/combo-sdk-0.176.221024.jar
