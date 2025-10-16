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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MSecurityMode;

class NoSecLwM2MBootstrapServerCredentialDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NoSecLwM2MBootstrapServerCredential}
   *   <li>{@link NoSecLwM2MBootstrapServerCredential#getSecurityMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoSecLwM2MBootstrapServerCredential.<init>()",
    "LwM2MSecurityMode NoSecLwM2MBootstrapServerCredential.getSecurityMode()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NoSecLwM2MBootstrapServerCredential actualNoSecLwM2MBootstrapServerCredential =
        new NoSecLwM2MBootstrapServerCredential();
    LwM2MSecurityMode actualSecurityMode =
        actualNoSecLwM2MBootstrapServerCredential.getSecurityMode();

    // Assert
    assertEquals("U", actualNoSecLwM2MBootstrapServerCredential.getBinding());
    assertNull(actualNoSecLwM2MBootstrapServerCredential.getPort());
    assertNull(actualNoSecLwM2MBootstrapServerCredential.getHost());
    assertNull(actualNoSecLwM2MBootstrapServerCredential.getServerCertificate());
    assertNull(actualNoSecLwM2MBootstrapServerCredential.getServerPublicKey());
    assertEquals(
        0, actualNoSecLwM2MBootstrapServerCredential.getBootstrapServerAccountTimeout().intValue());
    assertEquals(1, actualNoSecLwM2MBootstrapServerCredential.getClientHoldOffTime().intValue());
    assertEquals(1, actualNoSecLwM2MBootstrapServerCredential.getDefaultMinPeriod().intValue());
    assertEquals(123, actualNoSecLwM2MBootstrapServerCredential.getShortServerId().intValue());
    assertEquals(300, actualNoSecLwM2MBootstrapServerCredential.getLifetime().intValue());
    assertEquals(LwM2MSecurityMode.NO_SEC, actualSecurityMode);
    assertFalse(actualNoSecLwM2MBootstrapServerCredential.isBootstrapServerIs());
    assertTrue(actualNoSecLwM2MBootstrapServerCredential.isNotifIfDisabled());
  }
}
