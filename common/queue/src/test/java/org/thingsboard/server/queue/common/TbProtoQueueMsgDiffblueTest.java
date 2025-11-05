package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Duration;
import com.google.protobuf.GeneratedMessageV3;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsgHeaders;

class TbProtoQueueMsgDiffblueTest {
  /**
   * Test {@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3)}.
   *
   * <p>Method under test: {@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3)}
   */
  @Test
  @DisplayName("Test new TbProtoQueueMsg(UUID, GeneratedMessageV3)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbProtoQueueMsg.<init>(UUID, GeneratedMessageV3)"})
  void testNewTbProtoQueueMsg() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Duration defaultInstance = Duration.getDefaultInstance();

    // Act
    TbProtoQueueMsg<GeneratedMessageV3> actualTbProtoQueueMsg =
        new TbProtoQueueMsg<>(key, defaultInstance);

    // Assert
    TbQueueMsgHeaders headers = actualTbProtoQueueMsg.getHeaders();
    assertTrue(headers instanceof DefaultTbQueueMsgHeaders);
    assertTrue(headers.getData().isEmpty());
    assertSame(defaultInstance, actualTbProtoQueueMsg.getValue());
    assertSame(key, actualTbProtoQueueMsg.getKey());
    assertArrayEquals(new byte[] {}, actualTbProtoQueueMsg.getData());
  }
}
