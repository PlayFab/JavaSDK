#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.231.250214.jar ../../builds/combo-sdk-0.231.250214.jar
