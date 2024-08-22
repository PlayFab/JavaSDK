mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  server-sdk-0.223.240816.jar -Destination ../../builds/server-sdk-0.223.240816.jar