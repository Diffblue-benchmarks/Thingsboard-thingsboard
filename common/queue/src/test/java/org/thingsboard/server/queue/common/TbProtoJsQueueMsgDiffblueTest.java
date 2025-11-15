/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
   * <p>
   * Method under test: {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3, TbQueueMsgHeaders)}
   */
  @Test
  @DisplayName("Test new TbProtoJsQueueMsg(UUID, GeneratedMessageV3, TbQueueMsgHeaders)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbProtoJsQueueMsg.<init>(UUID, GeneratedMessageV3, TbQueueMsgHeaders)"})
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
   * Method under test: {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}
   */
  @Test
  @DisplayName("Test new TbProtoJsQueueMsg(UUID, GeneratedMessageV3)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbProtoJsQueueMsg.<init>(UUID, GeneratedMessageV3)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbProtoJsQueueMsg.getData()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbProtoJsQueueMsg.getData()"})
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
