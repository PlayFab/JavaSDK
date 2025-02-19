mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  combo-sdk-0.231.250214.jar -Destination ../../builds/combo-sdk-0.231.250214.jar