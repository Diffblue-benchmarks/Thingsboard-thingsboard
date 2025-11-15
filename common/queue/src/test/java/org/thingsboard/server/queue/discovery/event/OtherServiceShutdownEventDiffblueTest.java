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
package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.grpc.netty.shaded.io.netty.channel.group.DefaultChannelGroup;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OtherServiceShutdownEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OtherServiceShutdownEvent#getServiceId()}
   *   <li>{@link OtherServiceShutdownEvent#getServiceTypes()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    OtherServiceShutdownEvent otherServiceShutdownEvent = new OtherServiceShutdownEvent("Source", "42",
        new ArrayList<>());

    // Act
    String actualServiceId = otherServiceShutdownEvent.getServiceId();

    // Assert
    assertEquals("42", actualServiceId);
    assertTrue(otherServiceShutdownEvent.getServiceTypes().isEmpty());
  }

  /**
   * Method under test:
   * {@link OtherServiceShutdownEvent#OtherServiceShutdownEvent(Object, String, List)}
   */
  @Test
  void testNewOtherServiceShutdownEvent() {
    // Arrange and Act
    OtherServiceShutdownEvent actualOtherServiceShutdownEvent = new OtherServiceShutdownEvent("Source", "42",
        new ArrayList<>());

    // Assert
    assertEquals("42", actualOtherServiceShutdownEvent.getServiceId());
    assertEquals("Source", actualOtherServiceShutdownEvent.getSource());
    assertTrue(actualOtherServiceShutdownEvent.getServiceTypes().isEmpty());
  }

  /**
   * Method under test:
   * {@link OtherServiceShutdownEvent#OtherServiceShutdownEvent(Object, String, List)}
   */
  @Test
  void testNewOtherServiceShutdownEvent2() {
    // Arrange
    DefaultChannelGroup defaultChannelGroup = mock(DefaultChannelGroup.class);

    // Act
    OtherServiceShutdownEvent actualOtherServiceShutdownEvent = new OtherServiceShutdownEvent(defaultChannelGroup, "42",
        new ArrayList<>());

    // Assert
    assertEquals("42", actualOtherServiceShutdownEvent.getServiceId());
    assertTrue(actualOtherServiceShutdownEvent.getServiceTypes().isEmpty());
    assertSame(defaultChannelGroup, actualOtherServiceShutdownEvent.getSource());
  }
}
