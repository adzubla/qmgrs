package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class QueueProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${example.queue}")
    String queue;

    public void send(String text) {
        jmsTemplate.convertAndSend(queue, text);
    }

}
