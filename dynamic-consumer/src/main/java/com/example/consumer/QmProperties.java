package com.example.consumer;

import com.ibm.mq.spring.boot.MQConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ConfigurationProperties("qm")
@Configuration
public class QmProperties {

    private List<MQConfigurationProperties> list;

    public List<MQConfigurationProperties> getList() {
        return list;
    }

    public void setList(List<MQConfigurationProperties> list) {
        this.list = list;
    }

}
