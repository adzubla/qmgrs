package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableJms
public class ProducerApplication implements CommandLineRunner {

    @Autowired
    QueueProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = in.readLine();
            if (line == null || line.equals("")) {
                break;
            }
            producer.send(line);
        }
        System.out.println("DONE");
    }

}
