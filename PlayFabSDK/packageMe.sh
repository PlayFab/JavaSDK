#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.214.240401.jar ../../builds/combo-sdk-0.214.240401.jar
