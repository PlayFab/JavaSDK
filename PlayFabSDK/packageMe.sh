#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  combo-sdk-0.143.211209.jar ../../builds/combo-sdk-0.143.211209.jar
