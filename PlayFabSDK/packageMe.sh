#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.258.260410.jar ../../builds/combo-sdk-0.258.260410.jar
