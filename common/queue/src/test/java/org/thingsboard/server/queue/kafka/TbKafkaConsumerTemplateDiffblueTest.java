package org.thingsboard.server.queue.kafka;

import static org.mockito.Mockito.mock;
import java.util.HashMap;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;

class TbKafkaConsumerTemplateDiffblueTest {
  /**
   * Test {@link TbKafkaConsumerTemplate#doPoll(long)}.
   * <p>
   * Method under test: {@link TbKafkaConsumerTemplate#doPoll(long)}
   */
  @Test
  @DisplayName("Test doPoll(long)")
  @Disabled("TODO: Complete this test")
  void testDoPoll() {
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
    TbKafkaConsumerTemplate.TbKafkaConsumerTemplateBuilder<TbQueueMsg> builderResult = TbKafkaConsumerTemplate
        .builder();
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbKafkaConsumerTemplate.TbKafkaConsumerTemplateBuilder<TbQueueMsg> groupIdResult = builderResult
        .admin(new TbServiceBusAdmin(serviceBusSettings, new HashMap<>()))
        .clientId("42")
        .decoder(mock(TbKafkaDecoder.class))
        .groupId("42");
    TbKafkaConsumerTemplate.TbKafkaConsumerTemplateBuilder<TbQueueMsg> settingsResult = groupIdResult
        .settings(new TbKafkaSettings());
    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    TbKafkaConsumerTemplate<TbQueueMsg> buildResult = settingsResult
        .statsService(new TbKafkaConsumerStatsService(kafkaSettings, new TbKafkaConsumerStatisticConfig()))
        .topic("Topic")
        .build();

    // Act
    buildResult.doPoll(1L);
  }

  /**
   * Test {@link TbKafkaConsumerTemplate#doCommit()}.
   * <p>
   * Method under test: {@link TbKafkaConsumerTemplate#doCommit()}
   */
  @Test
  @DisplayName("Test doCommit()")
  @Disabled("TODO: Complete this test")
  void testDoCommit() {
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
    TbKafkaConsumerTemplate.TbKafkaConsumerTemplateBuilder<TbQueueMsg> builderResult = TbKafkaConsumerTemplate
        .builder();
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbKafkaConsumerTemplate.TbKafkaConsumerTemplateBuilder<TbQueueMsg> groupIdResult = builderResult
        .admin(new TbServiceBusAdmin(serviceBusSettings, new HashMap<>()))
        .clientId("42")
        .decoder(mock(TbKafkaDecoder.class))
        .groupId("42");
    TbKafkaConsumerTemplate.TbKafkaConsumerTemplateBuilder<TbQueueMsg> settingsResult = groupIdResult
        .settings(new TbKafkaSettings());
    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    TbKafkaConsumerTemplate<TbQueueMsg> buildResult = settingsResult
        .statsService(new TbKafkaConsumerStatsService(kafkaSettings, new TbKafkaConsumerStatisticConfig()))
        .topic("Topic")
        .build();

    // Act
    buildResult.doCommit();
  }
}
