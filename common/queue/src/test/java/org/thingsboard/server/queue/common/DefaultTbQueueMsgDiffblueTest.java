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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.GeneratedMessageV3;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DefaultTbQueueMsgHeaders DefaultTbQueueMsg.getHeaders()"})
  void testGetHeaders_thenReturnDataEmpty() throws UnsupportedEncodingException {
    // Arrange
    TbProtoJsQueueMsg<GeneratedMessageV3> msg = mock(TbProtoJsQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.randomUUID());
    when(msg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());

    // Act
    DefaultTbQueueMsgHeaders actualHeaders = new DefaultTbQueueMsg(msg).getHeaders();

    // Assert
    verify(msg).getData();
    verify(msg).getHeaders();
    verify(msg).getKey();
    assertTrue(actualHeaders.getData().isEmpty());
  }

  /**
   * Test {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}.
   *
   * <ul>
   *   <li>Then return Headers Data Empty.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test new DefaultTbQueueMsg(TbQueueMsg); then return Headers Data Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbQueueMsg.<init>(TbQueueMsg)"})
  void testNewDefaultTbQueueMsg_thenReturnHeadersDataEmpty() throws UnsupportedEncodingException {
    // Arrange
    TbProtoJsQueueMsg<GeneratedMessageV3> msg = mock(TbProtoJsQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    UUID randomUUIDResult = UUID.randomUUID();
    when(msg.getKey()).thenReturn(randomUUIDResult);
    when(msg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());

    // Act
    DefaultTbQueueMsg actualDefaultTbQueueMsg = new DefaultTbQueueMsg(msg);

    // Assert
    verify(msg).getData();
    verify(msg).getHeaders();
    verify(msg).getKey();
    assertTrue(actualDefaultTbQueueMsg.getHeaders().getData().isEmpty());
    assertSame(randomUUIDResult, actualDefaultTbQueueMsg.getKey());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualDefaultTbQueueMsg.getData());
  }
}
