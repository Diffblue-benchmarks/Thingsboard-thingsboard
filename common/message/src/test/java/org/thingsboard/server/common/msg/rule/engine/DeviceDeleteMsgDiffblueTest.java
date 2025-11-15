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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceDeleteMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceDeleteMsg#equals(Object)}
   *   <li>{@link DeviceDeleteMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(null, null);
    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(null, null);

    // Act and Assert
    assertEquals(deviceDeleteMsg, deviceDeleteMsg2);
    int expectedHashCodeResult = deviceDeleteMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceDeleteMsg2.hashCode());
  }

  /**
   * Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(new TenantId(UUID.randomUUID()), mock(DeviceId.class));

    // Act and Assert
    assertNotEquals(deviceDeleteMsg, new DeviceDeleteMsg(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceDeleteMsg(new TenantId(UUID.randomUUID()), mock(DeviceId.class)), "42");
  }

  /**
   * Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(null, mock(DeviceId.class));

    // Act and Assert
    assertNotEquals(deviceDeleteMsg, new DeviceDeleteMsg(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(null, mock(DeviceId.class));

    // Act and Assert
    assertNotEquals(deviceDeleteMsg, new DeviceDeleteMsg(null, null));
  }

  /**
   * Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(null, null);

    // Act and Assert
    assertNotEquals(deviceDeleteMsg, new DeviceDeleteMsg(null, new DeviceId(UUID.randomUUID())));
  }
}
