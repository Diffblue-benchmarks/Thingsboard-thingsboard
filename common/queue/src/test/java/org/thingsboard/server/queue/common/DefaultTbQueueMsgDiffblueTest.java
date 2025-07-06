package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;

class DefaultTbQueueMsgDiffblueTest {
  /**
   * Test {@link DefaultTbQueueMsg#getHeaders()}.
   *
   * <ul>
   *   <li>Then return Data Empty.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbQueueMsg#getHeaders()}
   */
  @Test
  @DisplayName("Test getHeaders(); then return Data Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DefaultTbQueueMsgHeaders DefaultTbQueueMsg.getHeaders()"})
  void testGetHeaders_thenReturnDataEmpty() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertTrue(
        new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()))
            .getHeaders()
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}.
   *
   * <ul>
   *   <li>Then return Key toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}
   */
  @Test
  @DisplayName(
      "Test new DefaultTbQueueMsg(TbQueueMsg); then return Key toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueMsg.<init>(TbQueueMsg)"})
  void testNewDefaultTbQueueMsg_thenReturnKeyToStringIs784f394c42b6435a983cB7beff2784f9()
      throws UnsupportedEncodingException {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DefaultTbQueueMsg actualDefaultTbQueueMsg =
        new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()));

    // Assert
    UUID key2 = actualDefaultTbQueueMsg.getKey();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", key2.toString());
    assertTrue(actualDefaultTbQueueMsg.getHeaders().getData().isEmpty());
    assertSame(key, key2);
    byte[] expectedData = "{\n}".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualDefaultTbQueueMsg.getData());
  }

  /**
   * Test {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}.
   *
   * <ul>
   *   <li>When {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)} with msg is {@link
   *       TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}
   */
  @Test
  @DisplayName(
      "Test new DefaultTbQueueMsg(TbQueueMsg); when DefaultTbQueueMsg(TbQueueMsg) with msg is TbProtoJsQueueMsg(UUID, GeneratedMessageV3)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueMsg.<init>(TbQueueMsg)"})
  void testNewDefaultTbQueueMsg_whenDefaultTbQueueMsgWithMsgIsTbProtoJsQueueMsg()
      throws UnsupportedEncodingException {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DefaultTbQueueMsg actualDefaultTbQueueMsg =
        new DefaultTbQueueMsg(
            new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance())));

    // Assert
    UUID key2 = actualDefaultTbQueueMsg.getKey();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", key2.toString());
    assertTrue(actualDefaultTbQueueMsg.getHeaders().getData().isEmpty());
    assertSame(key, key2);
    byte[] expectedData = "{\n}".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualDefaultTbQueueMsg.getData());
  }
}
