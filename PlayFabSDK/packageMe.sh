#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.224.240830.jar ../../builds/combo-sdk-0.224.240830.jar
