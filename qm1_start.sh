#!/usr/bin/env bash

docker run \
      --env LICENSE=accept \
      --env MQ_QMGR_NAME=QM1 \
      --publish 1414:1414 \
      --publish 9443:9443 \
      --detach \
      ibmcom/mq

echo
echo https://localhost:9443/ibmmq/console
echo
echo User: admin
echo Password: passw0rd
echo
