package com.example.consumer;

import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.mq.spring.boot.MQConfigurationProperties;
import com.ibm.mq.spring.boot.MQConnectionFactoryCustomizer;
import com.ibm.mq.spring.boot.MQConnectionFactoryFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;

import javax.jms.JMSException;
import java.util.List;

@Configuration
@EnableJms
public class JmsConfig implements JmsListenerConfigurer {

    @Autowired
    private ObjectProvider<List<MQConnectionFactoryCustomizer>> factoryCustomizers;

    @Autowired
    private DefaultJmsListenerContainerFactoryConfigurer configurer;

    @Autowired
    private QmProperties qmProperties;

    @Autowired
    private QueueConsumer queueConsumer;

    @Value("${example.queue}")
    private String destination;

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
        for (MQConfigurationProperties properties : qmProperties.getList()) {
            String queueManager = properties.getQueueManager();

            MQConnectionFactory connectionFactory = new MQConnectionFactoryFactory(properties, factoryCustomizers.getIfAvailable()).createConnectionFactory(MQConnectionFactory.class);

            DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
            configurer.configure(factory, connectionFactory);

            SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
            endpoint.setId("jmsEndpoint-" + queueManager);
            endpoint.setDestination(destination);
            endpoint.setMessageListener(message -> {
                try {
                    queueConsumer.receive(queueManager, message.getBody(String.class));
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            });
            registrar.registerEndpoint(endpoint, factory);
        }
    }

}
