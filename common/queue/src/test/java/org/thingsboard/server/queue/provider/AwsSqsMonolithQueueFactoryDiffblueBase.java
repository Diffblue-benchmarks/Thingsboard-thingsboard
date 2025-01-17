package org.thingsboard.server.queue.provider;

import org.springframework.test.context.TestPropertySource;

//locations="classpath:application-test.yml",
//locations="/application-test.yml",
//locations = "classpath:application.properties"
//@TestPropertySource(locations = "classpath:application.properties",properties ={"queue.type=aws-sqs","service.type=monolith"})
//@TestPropertySource(locations = "classpath:application-test.yml",properties ={"queue.type=aws-sqs","service.type=monolith"})
//@TestPropertySource(locations = {"file:C:/Users/sdodd/Projects/SecondThingsboard/thingsboard/common/queue/src/test/resources/application-test.yml"},properties ={"queue.type=aws-sqs","service.type=monolith"})
@TestPropertySource(locations = {"file:C:/Users/sdodd/Projects/SecondThingsboard/thingsboard/common/queue/src/test/resources/application.properties"},properties ={"queue.type=aws-sqs","service.type=monolith"})


public class AwsSqsMonolithQueueFactoryDiffblueBase {
}
