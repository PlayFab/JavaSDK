mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  server-sdk-0.240.250704.jar -Destination ../../builds/server-sdk-0.240.250704.jar