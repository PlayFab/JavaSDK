#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.133.210628.jar ../../builds/combo-sdk-0.133.210628.jar
