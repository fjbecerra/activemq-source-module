package com.pakius;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.xd.dirt.server.singlenode.SingleNodeApplication;
import org.springframework.xd.dirt.test.SingleNodeIntegrationTestSupport;
import org.springframework.xd.dirt.test.SingletonModuleRegistry;
import org.springframework.xd.dirt.test.process.SingleNodeProcessingChain;
import org.springframework.xd.module.ModuleType;
import org.springframework.xd.test.RandomConfigurationSupport;

import static org.junit.Assert.assertEquals;
import static org.springframework.xd.dirt.test.process.SingleNodeProcessingChainSupport.*;

/**
 * Created by fjbecerra on 12/07/15.
 */
@Ignore
public class SimpleJmsIntegrationTest {

    private static SingleNodeApplication application;

    private static int RECEIVE_TIMEOUT = 5000;

    private static String moduleName = "simple-jms-activemq";

    @BeforeClass
    public static void setUp() {
        RandomConfigurationSupport randomConfigSupport = new RandomConfigurationSupport();
        application = new SingleNodeApplication().run();
        SingleNodeIntegrationTestSupport singleNodeIntegrationTestSupport = new SingleNodeIntegrationTestSupport
                (application);
        singleNodeIntegrationTestSupport.addModuleRegistry(new SingletonModuleRegistry(ModuleType.source,
                moduleName));

    }

    @Test
    public void test() {
        String streamName = "jmsTest";
        String message = "hello world";

        String processingChainUnderTest = moduleName;

        SingleNodeProcessingChain chain = chain(application, streamName, processingChainUnderTest);

        chain.sendPayload(message);

        String result = (String) chain.receivePayload(RECEIVE_TIMEOUT);

        assertEquals("Aggressive Ponytail #freebandnames", result);

        //Unbind the source and sink channels from the message bus
        chain.destroy();
    }
}
