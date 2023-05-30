#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.190.230529.jar ../../builds/combo-sdk-0.190.230529.jar
