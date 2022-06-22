mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  client-sdk-0.161.220621.jar -Destination ../../builds/client-sdk-0.161.220621.jar