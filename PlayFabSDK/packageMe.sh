#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.150.220317.jar ../../builds/combo-sdk-0.150.220317.jar
