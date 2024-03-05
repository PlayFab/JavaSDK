mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  combo-sdk-0.212.240301.jar -Destination ../../builds/combo-sdk-0.212.240301.jar