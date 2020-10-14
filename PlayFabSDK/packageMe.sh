#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.121.201014.jar ../../builds/combo-sdk-0.121.201014.jar
