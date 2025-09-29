#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.245.250926.jar ../../builds/combo-sdk-0.245.250926.jar
