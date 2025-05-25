package org.thingsboard.server.service.edge.rpc.constructor.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.gen.edge.v1.QueueUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class QueueMsgConstructorV1DiffblueTest {
  /**
   * Test {@link QueueMsgConstructorV1#constructQueueUpdatedMsg(UpdateMsgType, Queue)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueMsgConstructorV1#constructQueueUpdatedMsg(UpdateMsgType, Queue)}
   */
  @Test
  @DisplayName("Test constructQueueUpdatedMsg(UpdateMsgType, Queue); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"QueueUpdateMsg QueueMsgConstructorV1.constructQueueUpdatedMsg(UpdateMsgType, Queue)"})
  void testConstructQueueUpdatedMsg_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    QueueMsgConstructorV1 queueMsgConstructorV1 = new QueueMsgConstructorV1();

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(2L);
    processingStrategy.setPauseBetweenRetries(2L);
    processingStrategy.setRetries(2);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration queueConfiguration = new TenantProfileQueueConfiguration();
    queueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    queueConfiguration.setConsumerPerPartition(true);
    queueConfiguration.setName("Name");
    queueConfiguration.setPackProcessingTimeout(2L);
    queueConfiguration.setPartitions(2);
    queueConfiguration.setPollInterval(42);
    queueConfiguration.setProcessingStrategy(processingStrategy);
    queueConfiguration.setSubmitStrategy(submitStrategy);
    queueConfiguration.setTopic("Topic");

    Queue queue = new Queue(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), queueConfiguration);
    queue.setTenantId(new TenantId(UUID.randomUUID()));
    queue.setId(new QueueId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    QueueUpdateMsg actualConstructQueueUpdatedMsgResult = queueMsgConstructorV1
        .constructQueueUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, queue);

    // Assert
    assertEquals("", actualConstructQueueUpdatedMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructQueueUpdatedMsgResult.getEntity());
    assertEquals("Name", actualConstructQueueUpdatedMsgResult.getName());
    assertEquals("Topic", actualConstructQueueUpdatedMsgResult.getTopic());
    assertEquals(-7476899250389416711L, actualConstructQueueUpdatedMsgResult.getIdLSB());
    assertEquals(0, actualConstructQueueUpdatedMsgResult.getMsgTypeValue());
    assertEquals(12, actualConstructQueueUpdatedMsgResult.getAllFields().size());
    assertEquals(2, actualConstructQueueUpdatedMsgResult.getPartitions());
    assertEquals(2L, actualConstructQueueUpdatedMsgResult.getPackProcessingTimeout());
    assertEquals(42, actualConstructQueueUpdatedMsgResult.getPollInterval());
    assertEquals(8669210807411032922L, actualConstructQueueUpdatedMsgResult.getIdMSB());
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, actualConstructQueueUpdatedMsgResult.getMsgType());
    assertTrue(actualConstructQueueUpdatedMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructQueueUpdatedMsgResult.getConsumerPerPartition());
    assertTrue(actualConstructQueueUpdatedMsgResult.hasProcessingStrategy());
    assertTrue(actualConstructQueueUpdatedMsgResult.hasSubmitStrategy());
    assertTrue(actualConstructQueueUpdatedMsgResult.isInitialized());
  }

  /**
   * Test {@link QueueMsgConstructorV1#constructQueueDeleteMsg(QueueId)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueMsgConstructorV1#constructQueueDeleteMsg(QueueId)}
   */
  @Test
  @DisplayName("Test constructQueueDeleteMsg(QueueId); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"QueueUpdateMsg QueueMsgConstructorV1.constructQueueDeleteMsg(QueueId)"})
  void testConstructQueueDeleteMsg_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    QueueMsgConstructorV1 queueMsgConstructorV1 = new QueueMsgConstructorV1();

    // Act
    QueueUpdateMsg actualConstructQueueDeleteMsgResult = queueMsgConstructorV1
        .constructQueueDeleteMsg(new QueueId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructQueueDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructQueueDeleteMsgResult.getEntity());
    assertEquals("", actualConstructQueueDeleteMsgResult.getName());
    assertEquals("", actualConstructQueueDeleteMsgResult.getTopic());
    assertEquals(-7476899250389416711L, actualConstructQueueDeleteMsgResult.getIdLSB());
    assertEquals(0, actualConstructQueueDeleteMsgResult.getPartitions());
    assertEquals(0, actualConstructQueueDeleteMsgResult.getPollInterval());
    assertEquals(0L, actualConstructQueueDeleteMsgResult.getPackProcessingTimeout());
    assertEquals(0L, actualConstructQueueDeleteMsgResult.getTenantIdLSB());
    assertEquals(0L, actualConstructQueueDeleteMsgResult.getTenantIdMSB());
    assertEquals(2, actualConstructQueueDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructQueueDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructQueueDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructQueueDeleteMsgResult.getIdMSB());
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualConstructQueueDeleteMsgResult.getMsgType());
    assertFalse(actualConstructQueueDeleteMsgResult.getConsumerPerPartition());
    assertFalse(actualConstructQueueDeleteMsgResult.hasProcessingStrategy());
    assertFalse(actualConstructQueueDeleteMsgResult.hasSubmitStrategy());
    assertTrue(actualConstructQueueDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructQueueDeleteMsgResult.isInitialized());
  }
}
