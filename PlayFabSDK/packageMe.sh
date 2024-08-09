#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.222.240809.jar ../../builds/combo-sdk-0.222.240809.jar
