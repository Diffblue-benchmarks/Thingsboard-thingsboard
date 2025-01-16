package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.kafka.KafkaTbQueueMsg;

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
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertTrue((new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()))).getHeaders()
        .getData()
        .isEmpty());
  }

  /**
   * Test {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}.
   * <ul>
   *   <li>Then return Key toString is
   * {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test new DefaultTbQueueMsg(TbQueueMsg); then return Key toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  void testNewDefaultTbQueueMsg_thenReturnKeyToStringIs784f394c42b6435a983cB7beff2784f9()
      throws UnsupportedEncodingException {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DefaultTbQueueMsg actualDefaultTbQueueMsg = new DefaultTbQueueMsg(
        new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()));

    // Assert
    UUID key2 = actualDefaultTbQueueMsg.getKey();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", key2.toString());
    assertTrue(actualDefaultTbQueueMsg.getHeaders().getData().isEmpty());
    assertSame(key, key2);
    byte[] expectedData = "{\n}".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualDefaultTbQueueMsg.getData());
  }

  /**
   * Test {@link DefaultTbQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different")
  @Disabled("TODO: Complete this test")
  void testEquals_whenOtherIsDifferent() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Invalid UUID string: Key
    //       at java.base/java.util.UUID.fromString1(UUID.java:280)
    //       at java.base/java.util.UUID.fromString(UUID.java:258)
    //       at org.thingsboard.server.queue.kafka.KafkaTbQueueMsg.<init>(KafkaTbQueueMsg.java:31)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(
        new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8"))));

    // Act
    defaultTbQueueMsg.equals(new DefaultTbQueueMsg(
        new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8")))));
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
    when(msg.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(msg.getHeaders()).thenReturn(defaultTbQueueMsgHeaders);
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(msg);
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
    when(msg.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(msg.getHeaders()).thenReturn(defaultTbQueueMsgHeaders);
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(msg);
    TbProtoJsQueueMsg<GeneratedMessageV3> msg2 = mock(TbProtoJsQueueMsg.class);
    when(msg2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg2.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(msg2.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());

    // Act and Assert
    assertNotEquals(defaultTbQueueMsg, new DefaultTbQueueMsg(msg2));
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() throws UnsupportedEncodingException {
    // Arrange
    DefaultTbQueueMsgHeaders defaultTbQueueMsgHeaders = mock(DefaultTbQueueMsgHeaders.class);
    when(defaultTbQueueMsgHeaders.getData()).thenReturn(new HashMap<>());
    TbProtoJsQueueMsg<GeneratedMessageV3> msg = mock(TbProtoJsQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.randomUUID());
    when(msg.getHeaders()).thenReturn(defaultTbQueueMsgHeaders);
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(msg);
    TbProtoJsQueueMsg<GeneratedMessageV3> msg2 = mock(TbProtoJsQueueMsg.class);
    when(msg2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg2.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(msg2.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());

    // Act and Assert
    assertNotEquals(defaultTbQueueMsg, new DefaultTbQueueMsg(msg2));
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() throws UnsupportedEncodingException {
    // Arrange
    DefaultTbQueueMsgHeaders defaultTbQueueMsgHeaders = mock(DefaultTbQueueMsgHeaders.class);
    when(defaultTbQueueMsgHeaders.getData()).thenReturn(new HashMap<>());
    TbProtoJsQueueMsg<GeneratedMessageV3> msg = mock(TbProtoJsQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(null);
    when(msg.getHeaders()).thenReturn(defaultTbQueueMsgHeaders);
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(msg);
    TbProtoJsQueueMsg<GeneratedMessageV3> msg2 = mock(TbProtoJsQueueMsg.class);
    when(msg2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg2.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(msg2.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());

    // Act and Assert
    assertNotEquals(defaultTbQueueMsg, new DefaultTbQueueMsg(msg2));
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() throws UnsupportedEncodingException {
    // Arrange
    DefaultTbQueueMsgHeaders defaultTbQueueMsgHeaders = mock(DefaultTbQueueMsgHeaders.class);
    when(defaultTbQueueMsgHeaders.getData()).thenReturn(new HashMap<>());
    TbProtoJsQueueMsg<GeneratedMessageV3> msg = mock(TbProtoJsQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(msg.getHeaders()).thenReturn(defaultTbQueueMsgHeaders);

    // Act and Assert
    assertNotEquals(new DefaultTbQueueMsg(msg), 1);
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() throws UnsupportedEncodingException {
    // Arrange
    DefaultTbQueueMsgHeaders defaultTbQueueMsgHeaders = mock(DefaultTbQueueMsgHeaders.class);
    when(defaultTbQueueMsgHeaders.getData()).thenReturn(new HashMap<>());
    TbProtoJsQueueMsg<GeneratedMessageV3> msg = mock(TbProtoJsQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(null);
    when(msg.getHeaders()).thenReturn(defaultTbQueueMsgHeaders);
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(msg);
    TbProtoJsQueueMsg<GeneratedMessageV3> msg2 = mock(TbProtoJsQueueMsg.class);
    when(msg2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg2.getKey()).thenReturn(null);
    when(msg2.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());

    // Act and Assert
    assertNotEquals(defaultTbQueueMsg, new DefaultTbQueueMsg(msg2));
  }

  /**
   * Test {@link DefaultTbQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'")
  @Disabled("TODO: Complete this test")
  void testEquals_whenOtherIsNull() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new DefaultTbQueueMsg(
        new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8"))))).equals(null);
  }

  /**
   * Test {@link DefaultTbQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is same")
  @Disabled("TODO: Complete this test")
  void testEquals_whenOtherIsSame() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new DefaultTbQueueMsg(
        new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8")))))
        .equals(new DefaultTbQueueMsg(
            new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link DefaultTbQueueMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type")
  @Disabled("TODO: Complete this test")
  void testEquals_whenOtherIsWrongType() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new DefaultTbQueueMsg(
        new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8")))))
        .equals("Different type to DefaultTbQueueMsg");
  }
}
