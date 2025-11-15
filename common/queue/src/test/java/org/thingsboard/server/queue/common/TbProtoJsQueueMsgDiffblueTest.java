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
import com.google.api.Advice;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageV3;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsgHeaders;

class TbProtoJsQueueMsgDiffblueTest {
  /**
   * Method under test: {@link TbProtoJsQueueMsg#getData()}
   */
  @Test
  void testGetData() throws UnsupportedEncodingException {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance());

    // Act
    byte[] actualData = tbProtoJsQueueMsg.getData();

    // Assert
    assertArrayEquals("{\n}".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test: {@link TbProtoJsQueueMsg#getData()}
   */
  @Test
  void testGetData2() {
    // Arrange
    UUID key = UUID.randomUUID();
    TbProtoJsQueueMsg<GeneratedMessageV3> tbProtoJsQueueMsg = new TbProtoJsQueueMsg<>(key,
        BytesValue.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{'"', '"'}, tbProtoJsQueueMsg.getData());
  }

  /**
   * Method under test:
   * {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3, TbQueueMsgHeaders)}
   */
  @Test
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
   * Method under test:
   * {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}
   */
  @Test
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
}
