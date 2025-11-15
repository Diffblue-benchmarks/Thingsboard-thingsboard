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
package org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MSecurityMode;

class RPKLwM2MBootstrapServerCredentialDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link RPKLwM2MBootstrapServerCredential}
   *   <li>{@link RPKLwM2MBootstrapServerCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RPKLwM2MBootstrapServerCredential actualRpkLwM2MBootstrapServerCredential = new RPKLwM2MBootstrapServerCredential();
    LwM2MSecurityMode actualSecurityMode = actualRpkLwM2MBootstrapServerCredential.getSecurityMode();

    // Assert
    assertEquals("U", actualRpkLwM2MBootstrapServerCredential.getBinding());
    assertNull(actualRpkLwM2MBootstrapServerCredential.getPort());
    assertNull(actualRpkLwM2MBootstrapServerCredential.getHost());
    assertNull(actualRpkLwM2MBootstrapServerCredential.getServerCertificate());
    assertNull(actualRpkLwM2MBootstrapServerCredential.getServerPublicKey());
    assertEquals(0, actualRpkLwM2MBootstrapServerCredential.getBootstrapServerAccountTimeout().intValue());
    assertEquals(1, actualRpkLwM2MBootstrapServerCredential.getClientHoldOffTime().intValue());
    assertEquals(1, actualRpkLwM2MBootstrapServerCredential.getDefaultMinPeriod().intValue());
    assertEquals(123, actualRpkLwM2MBootstrapServerCredential.getShortServerId().intValue());
    assertEquals(300, actualRpkLwM2MBootstrapServerCredential.getLifetime().intValue());
    assertEquals(LwM2MSecurityMode.RPK, actualSecurityMode);
    assertFalse(actualRpkLwM2MBootstrapServerCredential.isBootstrapServerIs());
    assertTrue(actualRpkLwM2MBootstrapServerCredential.isNotifIfDisabled());
  }
}
