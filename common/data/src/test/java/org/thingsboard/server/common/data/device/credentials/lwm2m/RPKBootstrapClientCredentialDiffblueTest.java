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
import org.junit.jupiter.api.Test;

class RPKBootstrapClientCredentialDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link RPKBootstrapClientCredential}
   *   <li>{@link RPKBootstrapClientCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RPKBootstrapClientCredential actualRpkBootstrapClientCredential = new RPKBootstrapClientCredential();
    LwM2MSecurityMode actualSecurityMode = actualRpkBootstrapClientCredential.getSecurityMode();

    // Assert
    assertNull(actualRpkBootstrapClientCredential.getClientPublicKeyOrId());
    assertNull(actualRpkBootstrapClientCredential.getClientSecretKey());
    assertEquals(LwM2MSecurityMode.RPK, actualSecurityMode);
  }
}
