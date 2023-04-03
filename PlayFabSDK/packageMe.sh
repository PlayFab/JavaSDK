#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.186.230403.jar ../../builds/combo-sdk-0.186.230403.jar
