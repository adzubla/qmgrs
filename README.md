
# Spring Boot Application with two JMS servers

Related <a href="https://dev.to/adzubla/using-multiple-jms-servers-with-spring-boot-3cbm">dev.to</a> article.

This is an example using two JMS servers in the same Spring Boot Application.

### Start brokers

To run this example you need to start two instaces of IBM MQ, with QM1 and QM2:

    ./qm1_start.sh
    ./qm2_start.sh

### Build

    mvn clean install

### Consumer

Execute consumer. 

    ./consumer.sh

### Producers
    
Open two producers, each one in its own terminal:

    # Uses QM1
    ./producer1.sh

    # Uses QM2
    ./producer2.sh

Type anything and it will be sent to the queue.

# Dynamic creation of listeners

Execute the dynamice version os the consumer instead.

    ./dynamic-consumer.sh
