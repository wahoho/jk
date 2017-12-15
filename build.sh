#! /bin/bash

TAG=${1:-uat}

mkdir dev
cd front/
npm run build --optional
cp -r dist/* ../dev/
cd ..
docker build --rm -t "wahoho/jk:${TAG}" .
rm -rf dev