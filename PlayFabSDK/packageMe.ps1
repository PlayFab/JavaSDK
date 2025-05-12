mvn package

pushd ../
New-Item -ItemType Directory -Force ./builds
popd

cd target
Copy-Item  combo-sdk-0.236.250512.jar -Destination ../../builds/combo-sdk-0.236.250512.jar