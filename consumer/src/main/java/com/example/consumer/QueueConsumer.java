package com.example.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @JmsListener(destination = "${example.queue}", containerFactory = "qm1JmsListenerContainerFactory")
    public void receive1(String text) {
        System.out.println("Received from qm1: " + text);
    }

    @JmsListener(destination = "${example.queue}", containerFactory = "qm2JmsListenerContainerFactory")
    public void receive2(String text) {
        System.out.println("Received from qm2: " + text);
    }

}
