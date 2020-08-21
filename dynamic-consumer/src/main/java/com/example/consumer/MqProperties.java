package com.example.consumer;

import com.ibm.mq.spring.boot.MQConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ConfigurationProperties("mq")
@Configuration
public class MqProperties {

    private List<MQConfigurationProperties> servers;

    public List<MQConfigurationProperties> getServers() {
        return servers;
    }

    public void setServers(List<MQConfigurationProperties> servers) {
        this.servers = servers;
    }

}
