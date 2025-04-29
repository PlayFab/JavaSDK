#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.235.250428.jar ../../builds/combo-sdk-0.235.250428.jar
