#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.206.231124.jar ../../builds/combo-sdk-0.206.231124.jar
