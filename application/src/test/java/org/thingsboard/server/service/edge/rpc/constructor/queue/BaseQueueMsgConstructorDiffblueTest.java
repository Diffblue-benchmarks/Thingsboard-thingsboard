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
import org.thingsboard.server.gen.edge.v1.QueueUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseQueueMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseQueueMsgConstructor#constructQueueDeleteMsg(QueueId)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueMsgConstructor#constructQueueDeleteMsg(QueueId)}
   */
  @Test
  @DisplayName("Test constructQueueDeleteMsg(QueueId); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"QueueUpdateMsg BaseQueueMsgConstructor.constructQueueDeleteMsg(QueueId)"})
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
