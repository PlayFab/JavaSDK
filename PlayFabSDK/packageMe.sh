#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.98.190916.jar ../../builds/combo-sdk-0.98.190916.jar
