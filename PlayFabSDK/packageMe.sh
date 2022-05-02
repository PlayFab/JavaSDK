#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.156.220502.jar ../../builds/combo-sdk-0.156.220502.jar
