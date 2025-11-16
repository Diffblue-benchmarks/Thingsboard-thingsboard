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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Duration;
import com.google.protobuf.GeneratedMessageV3;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsgHeaders;

class TbProtoQueueMsgDiffblueTest {
  /**
   * Test {@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3)}.
   *
   * <p>Method under test: {@link TbProtoQueueMsg#TbProtoQueueMsg(UUID, GeneratedMessageV3)}
   */
  @Test
  @DisplayName("Test new TbProtoQueueMsg(UUID, GeneratedMessageV3)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbProtoQueueMsg.<init>(UUID, GeneratedMessageV3)"})
  void testNewTbProtoQueueMsg() {
    // Arrange
    UUID key = UUID.randomUUID();
    Duration defaultInstance = Duration.getDefaultInstance();

    // Act
    TbProtoQueueMsg<GeneratedMessageV3> actualTbProtoQueueMsg =
        new TbProtoQueueMsg<>(key, defaultInstance);

    // Assert
    TbQueueMsgHeaders headers = actualTbProtoQueueMsg.getHeaders();
    assertTrue(headers instanceof DefaultTbQueueMsgHeaders);
    assertTrue(headers.getData().isEmpty());
    assertSame(defaultInstance, actualTbProtoQueueMsg.getValue());
    assertSame(key, actualTbProtoQueueMsg.getKey());
    assertArrayEquals(new byte[] {}, actualTbProtoQueueMsg.getData());
  }
}
