#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.174.220926.jar ../../builds/combo-sdk-0.174.220926.jar
