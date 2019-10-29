#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.101.191029.jar ../../builds/combo-sdk-0.101.191029.jar
