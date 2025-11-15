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
package org.thingsboard.server.transport.coap.efento.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PulseCounterTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PulseCounterType#getMajorResolution()}
   *   <li>{@link PulseCounterType#getPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PulseCounterType.getMajorResolution()", "java.lang.String PulseCounterType.getPrefix()"})
  void testGettersAndSetters() {
    // Arrange
    PulseCounterType valueOfResult = PulseCounterType.valueOf("WATER_CNT_ACC");

    // Act
    int actualMajorResolution = valueOfResult.getMajorResolution();

    // Assert
    assertEquals("water_cnt_acc_", valueOfResult.getPrefix());
    assertEquals(100, actualMajorResolution);
  }
}
