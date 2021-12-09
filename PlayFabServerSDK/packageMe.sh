#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.143.211209.jar ../../builds/server-sdk-0.143.211209.jar
