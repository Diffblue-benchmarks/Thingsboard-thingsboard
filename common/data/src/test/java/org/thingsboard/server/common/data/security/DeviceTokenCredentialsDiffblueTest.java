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
package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DeviceTokenCredentialsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceTokenCredentials#DeviceTokenCredentials(String)}
   *   <li>{@link DeviceTokenCredentials#toString()}
   *   <li>{@link DeviceTokenCredentials#getCredentialsId()}
   *   <li>{@link DeviceTokenCredentials#getCredentialsType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceTokenCredentials actualDeviceTokenCredentials = new DeviceTokenCredentials("ABC123");
    String actualToStringResult = actualDeviceTokenCredentials.toString();
    String actualCredentialsId = actualDeviceTokenCredentials.getCredentialsId();

    // Assert
    assertEquals("ABC123", actualCredentialsId);
    assertEquals("DeviceTokenCredentials [token=ABC123]", actualToStringResult);
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualDeviceTokenCredentials.getCredentialsType());
  }
}
