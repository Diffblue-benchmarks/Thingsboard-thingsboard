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
package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class X509BootstrapClientCredentialDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link X509BootstrapClientCredential}
   *   <li>{@link X509BootstrapClientCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void X509BootstrapClientCredential.<init>()",
      "LwM2MSecurityMode X509BootstrapClientCredential.getSecurityMode()"})
  void testGettersAndSetters() {
    // Arrange and Act
    X509BootstrapClientCredential actualX509BootstrapClientCredential = new X509BootstrapClientCredential();
    LwM2MSecurityMode actualSecurityMode = actualX509BootstrapClientCredential.getSecurityMode();

    // Assert
    assertNull(actualX509BootstrapClientCredential.getClientPublicKeyOrId());
    assertNull(actualX509BootstrapClientCredential.getClientSecretKey());
    assertEquals(LwM2MSecurityMode.X509, actualSecurityMode);
  }
}
