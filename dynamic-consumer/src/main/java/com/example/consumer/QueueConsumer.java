package com.example.consumer;

import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    public void receive(String queueManeger, String text) {
        System.out.println("Received from " + queueManeger + ": " + text);
    }

}
