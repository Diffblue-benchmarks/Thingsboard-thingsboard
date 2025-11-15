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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OtherServiceShutdownEventDiffblueTest {
  /**
   * Test {@link OtherServiceShutdownEvent#OtherServiceShutdownEvent(Object, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return ServiceId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtherServiceShutdownEvent#OtherServiceShutdownEvent(Object, String, List)}
   */
  @Test
  @DisplayName("Test new OtherServiceShutdownEvent(Object, String, List); when ArrayList(); then return ServiceId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtherServiceShutdownEvent.<init>(Object, String, List)"})
  void testNewOtherServiceShutdownEvent_whenArrayList_thenReturnServiceIdIs42() {
    // Arrange and Act
    OtherServiceShutdownEvent actualOtherServiceShutdownEvent = new OtherServiceShutdownEvent("Source", "42",
        new ArrayList<>());

    // Assert
    assertEquals("42", actualOtherServiceShutdownEvent.getServiceId());
    assertEquals("Source", actualOtherServiceShutdownEvent.getSource());
    assertTrue(actualOtherServiceShutdownEvent.getServiceTypes().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtherServiceShutdownEvent#getServiceId()}
   *   <li>{@link OtherServiceShutdownEvent#getServiceTypes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String OtherServiceShutdownEvent.getServiceId()",
      "java.util.Set OtherServiceShutdownEvent.getServiceTypes()"})
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
}
