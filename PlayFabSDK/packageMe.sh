#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.103.191218.jar ../../builds/combo-sdk-0.103.191218.jar
