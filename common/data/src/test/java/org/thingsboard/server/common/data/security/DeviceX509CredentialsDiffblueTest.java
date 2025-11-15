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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceX509CredentialsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceX509Credentials#DeviceX509Credentials(String)}
   *   <li>{@link DeviceX509Credentials#toString()}
   *   <li>{@link DeviceX509Credentials#getCredentialsId()}
   *   <li>{@link DeviceX509Credentials#getCredentialsType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceX509Credentials.<init>(String)", "String DeviceX509Credentials.getCredentialsId()",
      "DeviceCredentialsType DeviceX509Credentials.getCredentialsType()", "String DeviceX509Credentials.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceX509Credentials actualDeviceX509Credentials = new DeviceX509Credentials("Sha3 Hash");
    String actualToStringResult = actualDeviceX509Credentials.toString();
    String actualCredentialsId = actualDeviceX509Credentials.getCredentialsId();

    // Assert
    assertEquals("DeviceX509Credentials [SHA3=Sha3 Hash]", actualToStringResult);
    assertEquals("Sha3 Hash", actualCredentialsId);
    assertEquals(DeviceCredentialsType.X509_CERTIFICATE, actualDeviceX509Credentials.getCredentialsType());
  }
}
