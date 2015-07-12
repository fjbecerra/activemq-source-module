package com.pakius;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by fjbecerra on 08/07/2015.
 */
@MessageEndpoint
public class InMessageHandler {
    private static final Logger log = LoggerFactory.getLogger(InMessageHandler.class);

    @ServiceActivator(inputChannel = "input")
    public void handleMessage(String message) {
        log.info("Received message: '{}'" , message);
    }

}
