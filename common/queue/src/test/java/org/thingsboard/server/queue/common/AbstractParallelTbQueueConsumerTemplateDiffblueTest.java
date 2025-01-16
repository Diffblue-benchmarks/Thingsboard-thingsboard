package org.thingsboard.server.queue.common;

import static org.mockito.Mockito.mock;
import java.util.HashMap;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;
import org.thingsboard.server.queue.pubsub.TbPubSubConsumerTemplate;
import org.thingsboard.server.queue.pubsub.TbPubSubSettings;

class AbstractParallelTbQueueConsumerTemplateDiffblueTest {
  /**
   * Test {@link AbstractParallelTbQueueConsumerTemplate#initNewExecutor(int)}.
   * <p>
   * Method under test:
   * {@link AbstractParallelTbQueueConsumerTemplate#initNewExecutor(int)}
   */
  @Test
  @DisplayName("Test initNewExecutor(int)")
  @Disabled("TODO: Complete this test")
  void testInitNewExecutor() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: sasKeyName cannot be empty
    //       at com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider.<init>(SharedAccessSignatureTokenProvider.java:40)
    //       at com.microsoft.azure.servicebus.primitives.Util.getClientSettingsFromConnectionStringBuilder(Util.java:382)
    //       at com.microsoft.azure.servicebus.management.ManagementClient.<init>(ManagementClient.java:31)
    //       at org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin.<init>(TbServiceBusAdmin.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbPubSubConsumerTemplate<TbQueueMsg> tbPubSubConsumerTemplate = new TbPubSubConsumerTemplate<>(admin,
        new TbPubSubSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbPubSubConsumerTemplate.initNewExecutor(3);
  }

  /**
   * Test {@link AbstractParallelTbQueueConsumerTemplate#shutdownExecutor()}.
   * <p>
   * Method under test:
   * {@link AbstractParallelTbQueueConsumerTemplate#shutdownExecutor()}
   */
  @Test
  @DisplayName("Test shutdownExecutor()")
  @Disabled("TODO: Complete this test")
  void testShutdownExecutor() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: sasKeyName cannot be empty
    //       at com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider.<init>(SharedAccessSignatureTokenProvider.java:40)
    //       at com.microsoft.azure.servicebus.primitives.Util.getClientSettingsFromConnectionStringBuilder(Util.java:382)
    //       at com.microsoft.azure.servicebus.management.ManagementClient.<init>(ManagementClient.java:31)
    //       at org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin.<init>(TbServiceBusAdmin.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbPubSubConsumerTemplate<TbQueueMsg> tbPubSubConsumerTemplate = new TbPubSubConsumerTemplate<>(admin,
        new TbPubSubSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbPubSubConsumerTemplate.shutdownExecutor();
  }
}
