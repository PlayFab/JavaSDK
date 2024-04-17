mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  server-sdk-0.215.240412.jar -Destination ../../builds/server-sdk-0.215.240412.jar