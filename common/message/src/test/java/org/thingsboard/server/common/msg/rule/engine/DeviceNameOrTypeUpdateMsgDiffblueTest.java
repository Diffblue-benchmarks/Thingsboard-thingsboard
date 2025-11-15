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
package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceNameOrTypeUpdateMsgDiffblueTest {
  /**
   * Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg = new DeviceNameOrTypeUpdateMsg(new TenantId(UUID.randomUUID()),
        mock(DeviceId.class), "Device Name", "Device Type");

    // Act and Assert
    assertNotEquals(deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(new TenantId(UUID.randomUUID()), null, "Device Name", "Device Type"));
  }

  /**
   * Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceNameOrTypeUpdateMsg(new TenantId(UUID.randomUUID()), mock(DeviceId.class), "Device Name",
        "Device Type"), "42");
  }

  /**
   * Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg = new DeviceNameOrTypeUpdateMsg(null, mock(DeviceId.class),
        "Device Name", "Device Type");

    // Act and Assert
    assertNotEquals(deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(new TenantId(UUID.randomUUID()), null, "Device Name", "Device Type"));
  }
}
