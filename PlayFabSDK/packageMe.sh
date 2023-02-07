#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.181.230206.jar ../../builds/combo-sdk-0.181.230206.jar
