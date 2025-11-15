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
package org.thingsboard.server.transport.lwm2m.server.ota.software;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class SoftwareUpdateResultDiffblueTest {
  /**
   * Method under test: {@link SoftwareUpdateResult#fromUpdateResultSwByCode(int)}
   */
  @Test
  void testFromUpdateResultSwByCode() {
    // Arrange, Act and Assert
    assertEquals(SoftwareUpdateResult.DOWNLOADING, SoftwareUpdateResult.fromUpdateResultSwByCode(1));
    assertThrows(IllegalArgumentException.class, () -> SoftwareUpdateResult.fromUpdateResultSwByCode(13));
  }

  /**
   * Method under test:
   * {@link SoftwareUpdateResult#fromUpdateResultSwByType(String)}
   */
  @Test
  void testFromUpdateResultSwByType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SoftwareUpdateResult.fromUpdateResultSwByType("Type"));
    assertEquals(SoftwareUpdateResult.INITIAL, SoftwareUpdateResult.fromUpdateResultSwByType("Initial value"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SoftwareUpdateResult#getCode()}
   *   <li>{@link SoftwareUpdateResult#getType()}
   *   <li>{@link SoftwareUpdateResult#isAgain()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    SoftwareUpdateResult valueOfResult = SoftwareUpdateResult.valueOf("INITIAL");

    // Act
    int actualCode = valueOfResult.getCode();
    String actualType = valueOfResult.getType();

    // Assert
    assertEquals("Initial value", actualType);
    assertEquals(0, actualCode);
    assertFalse(valueOfResult.isAgain());
  }
}
