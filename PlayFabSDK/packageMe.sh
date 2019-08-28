#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.95.190821.jar ../../builds/combo-sdk-0.95.190821.jar
