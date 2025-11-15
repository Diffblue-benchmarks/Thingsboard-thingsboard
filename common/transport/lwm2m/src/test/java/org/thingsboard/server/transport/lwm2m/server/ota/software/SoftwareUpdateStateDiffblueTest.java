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
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class SoftwareUpdateStateDiffblueTest {
  /**
   * Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}
   */
  @Test
  void testFromUpdateStateSwByCode() {
    // Arrange, Act and Assert
    assertEquals(SoftwareUpdateState.DOWNLOAD_STARTED, SoftwareUpdateState.fromUpdateStateSwByCode(1));
    assertThrows(IllegalArgumentException.class, () -> SoftwareUpdateState.fromUpdateStateSwByCode(5));
  }

  /**
   * Method under test:
   * {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}
   */
  @Test
  void testFromUpdateStateSwByType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SoftwareUpdateState.fromUpdateStateSwByType("Type"));
    assertEquals(SoftwareUpdateState.INITIAL, SoftwareUpdateState.fromUpdateStateSwByType("Initial"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SoftwareUpdateState#getCode()}
   *   <li>{@link SoftwareUpdateState#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    SoftwareUpdateState valueOfResult = SoftwareUpdateState.valueOf("INITIAL");

    // Act
    int actualCode = valueOfResult.getCode();

    // Assert
    assertEquals("Initial", valueOfResult.getType());
    assertEquals(0, actualCode);
  }
}
