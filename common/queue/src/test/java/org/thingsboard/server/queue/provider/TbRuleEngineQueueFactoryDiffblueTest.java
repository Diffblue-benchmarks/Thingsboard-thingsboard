package org.thingsboard.server.queue.provider;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.sqs.TbAwsSqsQueueAttributes;
import org.thingsboard.server.queue.sqs.TbAwsSqsSettings;

@ContextConfiguration(classes = {AwsSqsTbRuleEngineQueueFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbRuleEngineQueueFactoryDiffblueTest {
  @MockBean
  private TbAwsSqsQueueAttributes tbAwsSqsQueueAttributes;

  @MockBean
  private TbAwsSqsSettings tbAwsSqsSettings;

  @MockBean
  private TbQueueCoreSettings tbQueueCoreSettings;

  @MockBean
  private TbQueueEdgeSettings tbQueueEdgeSettings;

  @MockBean
  private TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;

  @MockBean
  private TbQueueRuleEngineSettings tbQueueRuleEngineSettings;

  @MockBean
  private TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;

  @Autowired
  private TbRuleEngineQueueFactory tbRuleEngineQueueFactory;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TopicService topicService;

  /**
   * Test
   * {@link TbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue, Integer)}
   * with {@code configuration}, {@code partitionId}.
   * <p>
   * Method under test:
   * {@link TbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue, Integer)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue, Integer) with 'configuration', 'partitionId'")
  @Disabled("TODO: Complete this test")
  void testCreateToRuleEngineMsgConsumerWithConfigurationPartitionId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbRuleEngineQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.AwsSqsTbRuleEngineQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3273 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.sqs.TbAwsSqsQueueAttributes tbAwsSqsQueueAttributes;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.sqs.TbAwsSqsSettings tbAwsSqsSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbRuleEngineQueueFactory tbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(new Queue(), 1);
  }
}
