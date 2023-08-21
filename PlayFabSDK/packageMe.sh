#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.197.230818.jar ../../builds/combo-sdk-0.197.230818.jar
