package org.thingsboard.server.queue.provider;

import org.springframework.test.context.TestPropertySource;

//locations="classpath:/application-test.yml",
@TestPropertySource(properties ={"queue.type=aws-sqs","service.type=monolith"})
public class AwsSqsMonolithQueueFactoryDiffblueBase {
}
