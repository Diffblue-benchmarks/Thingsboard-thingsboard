package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.google.api.Advice;
import com.google.protobuf.GeneratedMessageV3;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;

class IdMsgPairDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IdMsgPair#IdMsgPair(UUID, TbProtoQueueMsg)}
   *   <li>{@link IdMsgPair#getMsg()}
   *   <li>{@link IdMsgPair#getUuid()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID uuid = UUID.randomUUID();
    UUID key = UUID.randomUUID();
    TbProtoQueueMsg<GeneratedMessageV3> msg = new TbProtoQueueMsg<>(key, Advice.getDefaultInstance());

    // Act
    IdMsgPair<GeneratedMessageV3> actualIdMsgPair = new IdMsgPair<>(uuid, msg);
    TbProtoQueueMsg<GeneratedMessageV3> actualMsg = actualIdMsgPair.getMsg();

    // Assert
    assertSame(msg, actualMsg);
    assertSame(uuid, actualIdMsgPair.getUuid());
  }
}
