package org.thingsboard.server.service.edge.rpc.constructor.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.gen.edge.v1.QueueUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class QueueMsgConstructorV2DiffblueTest {
  /**
   * Test {@link QueueMsgConstructorV2#constructQueueUpdatedMsg(UpdateMsgType, Queue)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link QueueMsgConstructorV2#constructQueueUpdatedMsg(UpdateMsgType,
   * Queue)}
   */
  @Test
  @DisplayName(
      "Test constructQueueUpdatedMsg(UpdateMsgType, Queue); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "QueueUpdateMsg QueueMsgConstructorV2.constructQueueUpdatedMsg(UpdateMsgType, Queue)"
  })
  void testConstructQueueUpdatedMsg_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    QueueMsgConstructorV2 queueMsgConstructorV2 = new QueueMsgConstructorV2();

    // Act
    QueueUpdateMsg actualConstructQueueUpdatedMsgResult =
        queueMsgConstructorV2.constructQueueUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
            new Queue(new QueueId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    assertEquals("", actualConstructQueueUpdatedMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructQueueUpdatedMsgResult.getName());
    assertEquals("", actualConstructQueueUpdatedMsgResult.getTopic());
    assertEquals(
        "{\"id\":{\"entityType\":\"QUEUE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId\""
            + ":null,\"name\":null,\"topic\":null,\"pollInterval\":0,\"partitions\":0,\"consumerPerPartition\":false,"
            + "\"packProcessingTimeout\":0,\"submitStrategy\":null,\"processingStrategy\":null,\"additionalInfo\":null}",
        actualConstructQueueUpdatedMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructQueueUpdatedMsgResult.getIdLSB());
    assertEquals(0, actualConstructQueueUpdatedMsgResult.getMsgTypeValue());
    assertEquals(0, actualConstructQueueUpdatedMsgResult.getPartitions());
    assertEquals(0, actualConstructQueueUpdatedMsgResult.getPollInterval());
    assertEquals(0L, actualConstructQueueUpdatedMsgResult.getPackProcessingTimeout());
    assertEquals(0L, actualConstructQueueUpdatedMsgResult.getTenantIdLSB());
    assertEquals(0L, actualConstructQueueUpdatedMsgResult.getTenantIdMSB());
    assertEquals(3, actualConstructQueueUpdatedMsgResult.getAllFields().size());
    assertEquals(311, actualConstructQueueUpdatedMsgResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualConstructQueueUpdatedMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructQueueUpdatedMsgResult.getMsgType());
    assertFalse(actualConstructQueueUpdatedMsgResult.getConsumerPerPartition());
    assertFalse(actualConstructQueueUpdatedMsgResult.hasProcessingStrategy());
    assertFalse(actualConstructQueueUpdatedMsgResult.hasSubmitStrategy());
    assertTrue(actualConstructQueueUpdatedMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructQueueUpdatedMsgResult.isInitialized());
  }
}
