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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;

class ValidateDeviceCredentialsResponseDiffblueTest {
  /**
   * Test {@link ValidateDeviceCredentialsResponse#hasDeviceInfo()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateDeviceCredentialsResponse#hasDeviceInfo()}
   */
  @Test
  @DisplayName("Test hasDeviceInfo(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateDeviceCredentialsResponse.hasDeviceInfo()"})
  void testHasDeviceInfo_thenReturnFalse() {
    // Arrange
    ValidateDeviceCredentialsResponse validateDeviceCredentialsResponse =
        new ValidateDeviceCredentialsResponse(null, new DeviceProfile(), "Credentials");

    // Act and Assert
    assertFalse(validateDeviceCredentialsResponse.hasDeviceInfo());
  }

  /**
   * Test {@link ValidateDeviceCredentialsResponse#hasDeviceInfo()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateDeviceCredentialsResponse#hasDeviceInfo()}
   */
  @Test
  @DisplayName("Test hasDeviceInfo(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateDeviceCredentialsResponse.hasDeviceInfo()"})
  void testHasDeviceInfo_thenReturnTrue() {
    // Arrange
    TransportDeviceInfo deviceInfo = new TransportDeviceInfo();
    ValidateDeviceCredentialsResponse validateDeviceCredentialsResponse =
        new ValidateDeviceCredentialsResponse(deviceInfo, new DeviceProfile(), "Credentials");

    // Act and Assert
    assertTrue(validateDeviceCredentialsResponse.hasDeviceInfo());
  }
}
