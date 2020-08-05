mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  client-sdk-0.116.200805.jar -Destination ../../builds/client-sdk-0.116.200805.jar