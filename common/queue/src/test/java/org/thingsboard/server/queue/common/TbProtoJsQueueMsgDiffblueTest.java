package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.api.Advice;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageV3;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsgHeaders;

class TbProtoJsQueueMsgDiffblueTest {
  /**
   * Test
   * {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3, TbQueueMsgHeaders)}.
   * <p>
   * Method under test:
   * {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3, TbQueueMsgHeaders)}
   */
  @Test
  @DisplayName("Test new TbProtoJsQueueMsg(UUID, GeneratedMessageV3, TbQueueMsgHeaders)")
  void testNewTbProtoJsQueueMsg() {
    // Arrange
    UUID key = UUID.randomUUID();
    Advice defaultInstance = Advice.getDefaultInstance();
    DefaultTbQueueMsgHeaders headers = new DefaultTbQueueMsgHeaders();

    // Act
    TbProtoJsQueueMsg<GeneratedMessageV3> actualTbProtoJsQueueMsg = new TbProtoJsQueueMsg<>(key, defaultInstance,
        headers);

    // Assert
    TbQueueMsgHeaders headers2 = actualTbProtoJsQueueMsg.getHeaders();
    assertTrue(headers2 instanceof DefaultTbQueueMsgHeaders);
    assertSame(headers, headers2);
    assertSame(defaultInstance, actualTbProtoJsQueueMsg.getValue());
    assertSame(key, actualTbProtoJsQueueMsg.getKey());
  }

  /**
   * Test {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}.
   * <p>
   * Method under test:
   * {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}
   */
  @Test
  @DisplayName("Test new TbProtoJsQueueMsg(UUID, GeneratedMessageV3)")
  void testNewTbProtoJsQueueMsg2() throws UnsupportedEncodingException {
    // Arrange
    UUID key = UUID.randomUUID();
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    TbProtoJsQueueMsg<GeneratedMessageV3> actualTbProtoJsQueueMsg = new TbProtoJsQueueMsg<>(key, defaultInstance);

    // Assert
    TbQueueMsgHeaders headers = actualTbProtoJsQueueMsg.getHeaders();
    assertTrue(headers instanceof DefaultTbQueueMsgHeaders);
    assertTrue(headers.getData().isEmpty());
    assertSame(defaultInstance, actualTbProtoJsQueueMsg.getValue());
    assertSame(key, actualTbProtoJsQueueMsg.getKey());
    byte[] expectedData = "{\n}".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualTbProtoJsQueueMsg.getData());
  }

  /**
   * Test {@link TbProtoJsQueueMsg#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code "} and {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoJsQueueMsg#getData()}
   */
  @Test
  @DisplayName("Test getData(); then return array of byte with '\"' and '\"'")
  void testGetData_thenReturnArrayOfByteWithQuotationMarkAndQuotationMark() {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = new TbProtoJsQueueMsg<>(key,
        BytesValue.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{'"', '"'}, tbProtoJsQueueMsg.getData());
  }

  /**
   * Test {@link TbProtoJsQueueMsg#getData()}.
   * <ul>
   *   <li>Then return {@code { }} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProtoJsQueueMsg#getData()}
   */
  @Test
  @DisplayName("Test getData(); then return '{ }' Bytes is 'UTF-8'")
  void testGetData_thenReturnLeftCurlyBracketSpaceRightCurlyBracketBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance());

    // Act
    byte[] actualData = tbProtoJsQueueMsg.getData();

    // Assert
    assertArrayEquals("{\n}".getBytes("UTF-8"), actualData);
  }
}
