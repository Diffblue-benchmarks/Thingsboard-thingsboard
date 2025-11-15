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

class FirmwareDeliveryMethodDiffblueTest {
  /**
   * Method under test: {@link FirmwareDeliveryMethod#fromStateFwByCode(int)}
   */
  @Test
  void testFromStateFwByCode() {
    // Arrange, Act and Assert
    assertEquals(FirmwareDeliveryMethod.PUSH, FirmwareDeliveryMethod.fromStateFwByCode(1));
    assertThrows(IllegalArgumentException.class, () -> FirmwareDeliveryMethod.fromStateFwByCode(3));
  }

  /**
   * Method under test: {@link FirmwareDeliveryMethod#fromStateFwByType(String)}
   */
  @Test
  void testFromStateFwByType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FirmwareDeliveryMethod.fromStateFwByType("Type"));
    assertEquals(FirmwareDeliveryMethod.PULL, FirmwareDeliveryMethod.fromStateFwByType("Pull only"));
  }
}
