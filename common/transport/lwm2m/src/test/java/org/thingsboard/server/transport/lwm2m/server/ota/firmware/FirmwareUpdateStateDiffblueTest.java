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
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class FirmwareUpdateStateDiffblueTest {
  /**
   * Method under test: {@link FirmwareUpdateState#fromStateFwByCode(int)}
   */
  @Test
  void testFromStateFwByCode() {
    // Arrange, Act and Assert
    assertEquals(FirmwareUpdateState.DOWNLOADING, FirmwareUpdateState.fromStateFwByCode(1));
    assertThrows(IllegalArgumentException.class, () -> FirmwareUpdateState.fromStateFwByCode(4));
  }

  /**
   * Method under test: {@link FirmwareUpdateState#fromStateFwByType(String)}
   */
  @Test
  void testFromStateFwByType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FirmwareUpdateState.fromStateFwByType("Type"));
    assertEquals(FirmwareUpdateState.IDLE, FirmwareUpdateState.fromStateFwByType("Idle"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FirmwareUpdateState#getCode()}
   *   <li>{@link FirmwareUpdateState#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    FirmwareUpdateState valueOfResult = FirmwareUpdateState.valueOf("IDLE");

    // Act
    int actualCode = valueOfResult.getCode();

    // Assert
    assertEquals("Idle", valueOfResult.getType());
    assertEquals(0, actualCode);
  }
}
