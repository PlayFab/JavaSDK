mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  client-sdk-0.226.241014.jar -Destination ../../builds/client-sdk-0.226.241014.jar