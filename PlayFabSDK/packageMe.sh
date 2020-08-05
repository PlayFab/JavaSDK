#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.116.200805.jar ../../builds/combo-sdk-0.116.200805.jar
