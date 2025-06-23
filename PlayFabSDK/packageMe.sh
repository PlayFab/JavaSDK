#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.239.250620.jar ../../builds/combo-sdk-0.239.250620.jar
