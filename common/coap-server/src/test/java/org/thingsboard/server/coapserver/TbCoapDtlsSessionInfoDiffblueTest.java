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
package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;

class TbCoapDtlsSessionInfoDiffblueTest {
  /**
   * Method under test:
   * {@link TbCoapDtlsSessionInfo#TbCoapDtlsSessionInfo(ValidateDeviceCredentialsResponse, DeviceProfile)}
   */
  @Test
  void testNewTbCoapDtlsSessionInfo() {
    // Arrange
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    TbCoapDtlsSessionInfo actualTbCoapDtlsSessionInfo = new TbCoapDtlsSessionInfo(msg, deviceProfile);

    // Assert
    assertSame(deviceProfile, actualTbCoapDtlsSessionInfo.getDeviceProfile());
    assertSame(msg, actualTbCoapDtlsSessionInfo.getMsg());
  }
}
