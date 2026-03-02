#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.255.260227.jar ../../builds/combo-sdk-0.255.260227.jar
