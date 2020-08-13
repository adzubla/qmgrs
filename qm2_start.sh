#!/usr/bin/env bash

docker run \
      --env LICENSE=accept \
      --env MQ_QMGR_NAME=QM2 \
      --publish 1415:1414 \
      --publish 9444:9443 \
      --detach \
      ibmcom/mq

echo
echo https://localhost:9444/ibmmq/console
echo
echo User: admin
echo Password: passw0rd
echo
