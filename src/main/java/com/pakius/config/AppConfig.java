package com.pakius.config;

import com.pakius.InMessageHandler;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



/**
 * Created by fjbecerra on 12/07/15.
 */

@Configuration
@ComponentScan(basePackages = "com.pakius")
public class AppConfig {

    @Bean
    ActiveMQConnectionFactory connectionFactory()
    {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        return activeMQConnectionFactory;
    }



    @Bean
    InMessageHandler inMessageHandler() {
        return new InMessageHandler();
    }



}
