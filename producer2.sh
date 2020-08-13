cd producer || exit 1

export IBM_MQ_QUEUEMANAGER='QM2'
export IBM_MQ_CONNNAME='localhost(1415)'

mvn spring-boot:run
