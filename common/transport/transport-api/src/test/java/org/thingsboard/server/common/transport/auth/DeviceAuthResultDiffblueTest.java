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
package org.thingsboard.server.common.transport.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;

class DeviceAuthResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceAuthResult#toString()}
   *   <li>{@link DeviceAuthResult#getDeviceId()}
   *   <li>{@link DeviceAuthResult#getErrorMsg()}
   *   <li>{@link DeviceAuthResult#isSuccess()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    DeviceAuthResult ofResult = DeviceAuthResult.of("An error occurred");

    // Act
    String actualToStringResult = ofResult.toString();
    DeviceId actualDeviceId = ofResult.getDeviceId();
    String actualErrorMsg = ofResult.getErrorMsg();

    // Assert
    assertEquals("An error occurred", actualErrorMsg);
    assertEquals("DeviceAuthResult [success=false, deviceId=null, errorMsg=An error occurred]", actualToStringResult);
    assertNull(actualDeviceId);
    assertFalse(ofResult.isSuccess());
  }

  /**
   * Method under test: {@link DeviceAuthResult#of(String)}
   */
  @Test
  void testOf() {
    // Arrange and Act
    DeviceAuthResult actualOfResult = DeviceAuthResult.of("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOfResult.getErrorMsg());
    assertNull(actualOfResult.getDeviceId());
    assertFalse(actualOfResult.isSuccess());
  }

  /**
   * Method under test: {@link DeviceAuthResult#of(DeviceId)}
   */
  @Test
  void testOf2() {
    // Arrange and Act
    DeviceAuthResult actualOfResult = DeviceAuthResult.of((DeviceId) null);

    // Assert
    assertNull(actualOfResult.getErrorMsg());
    assertNull(actualOfResult.getDeviceId());
    assertTrue(actualOfResult.isSuccess());
  }
}
