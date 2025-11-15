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
package org.thingsboard.server.transport.lwm2m.server.ota.firmware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class FirmwareUpdateResultDiffblueTest {
  /**
   * Method under test: {@link FirmwareUpdateResult#fromUpdateResultFwByCode(int)}
   */
  @Test
  void testFromUpdateResultFwByCode() {
    // Arrange, Act and Assert
    assertEquals(FirmwareUpdateResult.UPDATE_SUCCESSFULLY, FirmwareUpdateResult.fromUpdateResultFwByCode(1));
    assertThrows(IllegalArgumentException.class, () -> FirmwareUpdateResult.fromUpdateResultFwByCode(10));
  }

  /**
   * Method under test:
   * {@link FirmwareUpdateResult#fromUpdateResultFwByType(String)}
   */
  @Test
  void testFromUpdateResultFwByType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FirmwareUpdateResult.fromUpdateResultFwByType("Type"));
    assertEquals(FirmwareUpdateResult.INITIAL, FirmwareUpdateResult.fromUpdateResultFwByType("Initial value"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FirmwareUpdateResult#getCode()}
   *   <li>{@link FirmwareUpdateResult#getType()}
   *   <li>{@link FirmwareUpdateResult#isAgain()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    FirmwareUpdateResult valueOfResult = FirmwareUpdateResult.valueOf("INITIAL");

    // Act
    int actualCode = valueOfResult.getCode();
    String actualType = valueOfResult.getType();

    // Assert
    assertEquals("Initial value", actualType);
    assertEquals(0, actualCode);
    assertFalse(valueOfResult.isAgain());
  }
}
