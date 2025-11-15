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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;

class DefaultTbQueueMsgDiffblueTest {
  /**
   * Method under test: {@link DefaultTbQueueMsg#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DefaultTbQueueMsg#equals(Object)}
   */
  @Test
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

  /**
   * Method under test: {@link DefaultTbQueueMsg#getHeaders()}
   */
  @Test
  void testGetHeaders() {
    // Arrange
    UUID key = UUID.randomUUID();

    // Act and Assert
    assertTrue((new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()))).getHeaders()
        .getData()
        .isEmpty());
  }

  /**
   * Method under test: {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}
   */
  @Test
  void testNewDefaultTbQueueMsg() throws UnsupportedEncodingException {
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
}
