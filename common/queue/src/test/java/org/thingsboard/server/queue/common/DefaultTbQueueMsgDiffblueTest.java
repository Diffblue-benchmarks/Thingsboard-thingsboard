package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.google.api.Advice;
import com.google.protobuf.GeneratedMessageV3;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;

class DefaultTbQueueMsgDiffblueTest {
  /**
   * Test {@link DefaultTbQueueMsg#getHeaders()}.
   * <ul>
   *   <li>Then return Data Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueMsg#getHeaders()}
   */
  @Test
  @DisplayName("Test getHeaders(); then return Data Empty")
  void testGetHeaders_thenReturnDataEmpty() {
    // Arrange
    UUID key = UUID.randomUUID();

    // Act and Assert
    assertTrue((new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()))).getHeaders()
        .getData()
        .isEmpty());
  }

  /**
   * Test {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}.
   * <ul>
   *   <li>Then return Headers Data Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test new DefaultTbQueueMsg(TbQueueMsg); then return Headers Data Empty")
  void testNewDefaultTbQueueMsg_thenReturnHeadersDataEmpty() throws UnsupportedEncodingException {
    // Arrange
    UUID key = UUID.randomUUID();

    // Act
    DefaultTbQueueMsg actualDefaultTbQueueMsg = new DefaultTbQueueMsg(
        new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()));

    // Assert
    assertTrue(actualDefaultTbQueueMsg.getHeaders().getData().isEmpty());
    assertSame(key, actualDefaultTbQueueMsg.getKey());
    byte[] expectedData = "{\n}".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualDefaultTbQueueMsg.getData());
  }

  /**
   * Test {@link DefaultTbQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    DefaultTbQueueMsgHeaders defaultTbQueueMsgHeaders = mock(DefaultTbQueueMsgHeaders.class);
    when(defaultTbQueueMsgHeaders.getData()).thenReturn(new HashMap<>());
    TbProtoJsQueueMsg<GeneratedMessageV3> msg = mock(TbProtoJsQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.randomUUID());
    when(msg.getHeaders()).thenReturn(defaultTbQueueMsgHeaders);
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(msg);
    UUID key = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(defaultTbQueueMsg,
        new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance())));
  }

  /**
   * Test {@link DefaultTbQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws UnsupportedEncodingException {
    // Arrange
    DefaultTbQueueMsgHeaders defaultTbQueueMsgHeaders = mock(DefaultTbQueueMsgHeaders.class);
    when(defaultTbQueueMsgHeaders.getData()).thenReturn(new HashMap<>());
    TbProtoJsQueueMsg<GeneratedMessageV3> msg = mock(TbProtoJsQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.randomUUID());
    when(msg.getHeaders()).thenReturn(defaultTbQueueMsgHeaders);

    // Act and Assert
    assertNotEquals(new DefaultTbQueueMsg(msg), "42");
  }
}
