#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.216.240426.jar ../../builds/combo-sdk-0.216.240426.jar
