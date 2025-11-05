package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Duration;
import com.google.protobuf.GeneratedMessageV3;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsgHeaders;

class TbProtoJsQueueMsgDiffblueTest {
  /**
   * Test {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}.
   *
   * <p>Method under test: {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}
   */
  @Test
  @DisplayName("Test new TbProtoJsQueueMsg(UUID, GeneratedMessageV3)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbProtoJsQueueMsg.<init>(UUID, GeneratedMessageV3)"})
  void testNewTbProtoJsQueueMsg() throws UnsupportedEncodingException {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Duration defaultInstance = Duration.getDefaultInstance();

    // Act
    TbProtoJsQueueMsg<GeneratedMessageV3> actualTbProtoJsQueueMsg =
        new TbProtoJsQueueMsg<>(key, defaultInstance);

    // Assert
    TbQueueMsgHeaders headers = actualTbProtoJsQueueMsg.getHeaders();
    assertTrue(headers instanceof DefaultTbQueueMsgHeaders);
    assertTrue(headers.getData().isEmpty());
    assertSame(defaultInstance, actualTbProtoJsQueueMsg.getValue());
    assertSame(key, actualTbProtoJsQueueMsg.getKey());
    assertArrayEquals("\"0s\"".getBytes("UTF-8"), actualTbProtoJsQueueMsg.getData());
  }
}
