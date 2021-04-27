mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  client-sdk-0.130.210427.jar -Destination ../../builds/client-sdk-0.130.210427.jar