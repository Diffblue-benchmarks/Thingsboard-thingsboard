package org.thingsboard.server.queue.common;

import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueCallback;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusProducerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;
import org.thingsboard.server.queue.discovery.PartitionService;

@ContextConfiguration(classes = {TbRuleEngineProducerService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbRuleEngineProducerServiceDiffblueTest {
  @MockBean
  private PartitionService partitionService;

  @Autowired
  private TbRuleEngineProducerService tbRuleEngineProducerService;

  /**
   * Test
   * {@link TbRuleEngineProducerService#sendToRuleEngine(TbQueueProducer, TenantId, TbMsg, TbQueueCallback)}
   * with {@code producer}, {@code tenantId}, {@code tbMsg}, {@code callback}.
   * <p>
   * Method under test:
   * {@link TbRuleEngineProducerService#sendToRuleEngine(TbQueueProducer, TenantId, TbMsg, TbQueueCallback)}
   */
  @Test
  @DisplayName("Test sendToRuleEngine(TbQueueProducer, TenantId, TbMsg, TbQueueCallback) with 'producer', 'tenantId', 'tbMsg', 'callback'")
  @Disabled("TODO: Complete this test")
  void testSendToRuleEngineWithProducerTenantIdTbMsgCallback() {
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

    TbServiceBusProducerTemplate<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> producer = new TbServiceBusProducerTemplate<>(
        admin, new TbServiceBusSettings(), "Default Topic");

    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    tbRuleEngineProducerService.sendToRuleEngine(producer, tenantId, null,
        new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class)));
  }
}
