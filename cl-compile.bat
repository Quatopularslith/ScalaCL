@echo off
echo "Compiling..."
call lein compile
echo "Building Jar..."
call lein uberjar
echo "Cleaning..."
rmdir /Q /S "cl-classes"
rmdir /Q /S "dev-resources"
rmdir /Q /S "lib/stale"
rmdir /Q /S "test"
echo "Refreshing..."
call sbt update
echo "Done"