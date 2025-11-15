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
package org.thingsboard.server.common.transport.config.ssl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.net.InetAddress;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.ServerProperties;

class SslCredentialsWebServerCustomizerDiffblueTest {
  /**
   * Method under test:
   * {@link SslCredentialsWebServerCustomizer#httpServerSslCredentials()}
   */
  @Test
  void testHttpServerSslCredentials() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SslCredentialsConfig actualHttpServerSslCredentialsResult = (new SslCredentialsWebServerCustomizer(
        new ServerProperties())).httpServerSslCredentials();

    // Assert
    assertEquals("HTTP Server SSL Credentials", actualHttpServerSslCredentialsResult.getName());
    assertNull(actualHttpServerSslCredentialsResult.getKeystore());
    assertNull(actualHttpServerSslCredentialsResult.getPem());
    assertNull(actualHttpServerSslCredentialsResult.getCredentials());
    assertNull(actualHttpServerSslCredentialsResult.getType());
    assertFalse(actualHttpServerSslCredentialsResult.isTrustsOnly());
    assertTrue(actualHttpServerSslCredentialsResult.isEnabled());
  }

  /**
   * Method under test:
   * {@link SslCredentialsWebServerCustomizer#httpServerSslCredentials()}
   */
  @Test
  void testHttpServerSslCredentials2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ServerProperties serverProperties = new ServerProperties();
    serverProperties.setAddress(mock(InetAddress.class));

    // Act
    SslCredentialsConfig actualHttpServerSslCredentialsResult = (new SslCredentialsWebServerCustomizer(
        serverProperties)).httpServerSslCredentials();

    // Assert
    assertEquals("HTTP Server SSL Credentials", actualHttpServerSslCredentialsResult.getName());
    assertNull(actualHttpServerSslCredentialsResult.getKeystore());
    assertNull(actualHttpServerSslCredentialsResult.getPem());
    assertNull(actualHttpServerSslCredentialsResult.getCredentials());
    assertNull(actualHttpServerSslCredentialsResult.getType());
    assertFalse(actualHttpServerSslCredentialsResult.isTrustsOnly());
    assertTrue(actualHttpServerSslCredentialsResult.isEnabled());
  }
}
