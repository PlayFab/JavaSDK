#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.143.211209.jar ../../builds/client-sdk-0.143.211209.jar
