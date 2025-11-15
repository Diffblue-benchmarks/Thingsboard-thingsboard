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

class LwM2MFirmwareUpdateStrategyDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByCode(int)}
   */
  @Test
  void testFromStrategyFwByCode() {
    // Arrange, Act and Assert
    assertEquals(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY, LwM2MFirmwareUpdateStrategy.fromStrategyFwByCode(1));
    assertEquals(LwM2MFirmwareUpdateStrategy.OBJ_19_BINARY, LwM2MFirmwareUpdateStrategy.fromStrategyFwByCode(3));
    assertThrows(IllegalArgumentException.class, () -> LwM2MFirmwareUpdateStrategy.fromStrategyFwByCode(0));
  }

  /**
   * Method under test:
   * {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByType(String)}
   */
  @Test
  void testFromStrategyFwByType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LwM2MFirmwareUpdateStrategy.fromStrategyFwByType("Type"));
    assertEquals(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY,
        LwM2MFirmwareUpdateStrategy.fromStrategyFwByType("ObjectId 5, Binary"));
  }
}
