#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.218.240524.jar ../../builds/combo-sdk-0.218.240524.jar
