#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.228.241108.jar ../../builds/combo-sdk-0.228.241108.jar
