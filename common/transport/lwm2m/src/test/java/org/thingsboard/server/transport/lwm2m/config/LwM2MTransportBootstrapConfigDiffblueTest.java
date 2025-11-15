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
package org.thingsboard.server.transport.lwm2m.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig;

class LwM2MTransportBootstrapConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MTransportBootstrapConfig#getHost()}
   *   <li>{@link LwM2MTransportBootstrapConfig#getId()}
   *   <li>{@link LwM2MTransportBootstrapConfig#getPort()}
   *   <li>{@link LwM2MTransportBootstrapConfig#getSecureHost()}
   *   <li>{@link LwM2MTransportBootstrapConfig#getSecurePort()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig = new LwM2MTransportBootstrapConfig();

    // Act
    String actualHost = lwM2MTransportBootstrapConfig.getHost();
    Integer actualId = lwM2MTransportBootstrapConfig.getId();
    Integer actualPort = lwM2MTransportBootstrapConfig.getPort();
    String actualSecureHost = lwM2MTransportBootstrapConfig.getSecureHost();

    // Assert
    assertNull(actualId);
    assertNull(actualPort);
    assertNull(lwM2MTransportBootstrapConfig.getSecurePort());
    assertNull(actualHost);
    assertNull(actualSecureHost);
  }

  /**
   * Method under test:
   * {@link LwM2MTransportBootstrapConfig#lwm2mBootstrapCredentials()}
   */
  @Test
  void testLwm2mBootstrapCredentials() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SslCredentialsConfig actualLwm2mBootstrapCredentialsResult = (new LwM2MTransportBootstrapConfig())
        .lwm2mBootstrapCredentials();

    // Assert
    assertEquals("LWM2M Bootstrap DTLS Credentials", actualLwm2mBootstrapCredentialsResult.getName());
    assertNull(actualLwm2mBootstrapCredentialsResult.getKeystore());
    assertNull(actualLwm2mBootstrapCredentialsResult.getPem());
    assertNull(actualLwm2mBootstrapCredentialsResult.getCredentials());
    assertNull(actualLwm2mBootstrapCredentialsResult.getType());
    assertFalse(actualLwm2mBootstrapCredentialsResult.isTrustsOnly());
    assertTrue(actualLwm2mBootstrapCredentialsResult.isEnabled());
  }
}
