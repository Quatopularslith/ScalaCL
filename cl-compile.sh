#!/bin/sh
lein compile
lein uberjar
rm -f -r "cl-classes"
rm -f -r "dev-resources"
rm -f -r "lib/stale"
rm -f -r "test"
sbt update