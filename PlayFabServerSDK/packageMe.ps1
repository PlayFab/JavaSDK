mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  server-sdk-0.148.220305.jar -Destination ../../builds/server-sdk-0.148.220305.jar