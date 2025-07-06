package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageV3;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsgHeaders;

class TbProtoJsQueueMsgDiffblueTest {
  /**
   * Test {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3, TbQueueMsgHeaders)}.
   *
   * <p>Method under test: {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3,
   * TbQueueMsgHeaders)}
   */
  @Test
  @DisplayName("Test new TbProtoJsQueueMsg(UUID, GeneratedMessageV3, TbQueueMsgHeaders)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbProtoJsQueueMsg.<init>(UUID, GeneratedMessageV3, TbQueueMsgHeaders)"})
  void testNewTbProtoJsQueueMsg() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Advice defaultInstance = Advice.getDefaultInstance();
    DefaultTbQueueMsgHeaders headers = new DefaultTbQueueMsgHeaders();

    // Act
    TbProtoJsQueueMsg<GeneratedMessageV3> actualTbProtoJsQueueMsg =
        new TbProtoJsQueueMsg<>(key, defaultInstance, headers);

    // Assert
    TbQueueMsgHeaders headers2 = actualTbProtoJsQueueMsg.getHeaders();
    assertTrue(headers2 instanceof DefaultTbQueueMsgHeaders);
    UUID key2 = actualTbProtoJsQueueMsg.getKey();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", key2.toString());
    assertSame(headers, headers2);
    assertSame(defaultInstance, actualTbProtoJsQueueMsg.getValue());
    assertSame(key, key2);
  }

  /**
   * Test {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}.
   *
   * <p>Method under test: {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}
   */
  @Test
  @DisplayName("Test new TbProtoJsQueueMsg(UUID, GeneratedMessageV3)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbProtoJsQueueMsg.<init>(UUID, GeneratedMessageV3)"})
  void testNewTbProtoJsQueueMsg2() throws UnsupportedEncodingException {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    TbProtoJsQueueMsg<GeneratedMessageV3> actualTbProtoJsQueueMsg =
        new TbProtoJsQueueMsg<>(key, defaultInstance);

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
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code "} and {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link TbProtoJsQueueMsg#getData()}
   */
  @Test
  @DisplayName("Test getData(); then return array of byte with '\"' and '\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbProtoJsQueueMsg.getData()"})
  void testGetData_thenReturnArrayOfByteWithQuotationMarkAndQuotationMark() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg =
        new TbProtoJsQueueMsg<>(key, BytesValue.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[] {'"', '"'}, tbProtoJsQueueMsg.getData());
  }

  /**
   * Test {@link TbProtoJsQueueMsg#getData()}.
   *
   * <ul>
   *   <li>Then return {@code { }} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TbProtoJsQueueMsg#getData()}
   */
  @Test
  @DisplayName("Test getData(); then return '{ }' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbProtoJsQueueMsg.getData()"})
  void testGetData_thenReturnLeftCurlyBracketSpaceRightCurlyBracketBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg =
        new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance());

    // Act
    byte[] actualData = tbProtoJsQueueMsg.getData();

    // Assert
    assertArrayEquals("{\n}".getBytes("UTF-8"), actualData);
  }
}
