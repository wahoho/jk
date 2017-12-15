#! /bin/bash

TAG=${1:-uat}
export DOCKER_ID_USER="wahoho"
$(docker login)
docker push "wahoho/jk:${TAG}"