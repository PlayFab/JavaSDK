mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  server-sdk-0.243.250815.jar -Destination ../../builds/server-sdk-0.243.250815.jar