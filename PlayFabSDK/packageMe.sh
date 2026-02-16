#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.254.260213.jar ../../builds/combo-sdk-0.254.260213.jar
