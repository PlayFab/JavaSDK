#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.208.240105.jar ../../builds/combo-sdk-0.208.240105.jar
