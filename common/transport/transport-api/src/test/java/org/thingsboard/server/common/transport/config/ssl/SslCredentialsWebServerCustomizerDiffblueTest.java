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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties.ForwardHeadersStrategy;
import org.springframework.boot.web.server.Shutdown;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.Ssl.ClientAuth;
import org.springframework.util.unit.DataSize;

class SslCredentialsWebServerCustomizerDiffblueTest {
  /**
   * Test {@link SslCredentialsWebServerCustomizer#httpServerSslCredentials()}.
   *
   * <p>Method under test: {@link SslCredentialsWebServerCustomizer#httpServerSslCredentials()}
   */
  @Test
  @DisplayName("Test httpServerSslCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SslCredentialsConfig SslCredentialsWebServerCustomizer.httpServerSslCredentials()"
  })
  void testHttpServerSslCredentials() {
    // Arrange
    Ssl ssl = new Ssl();
    ssl.setBundle("Bundle");
    ssl.setCertificate("Certificate");
    ssl.setCertificatePrivateKey("Certificate Private Key");
    ssl.setCiphers(new String[] {"Ciphers"});
    ssl.setClientAuth(ClientAuth.NONE);
    ssl.setEnabled(true);
    ssl.setEnabledProtocols(new String[] {"Enabled Protocols"});
    ssl.setKeyAlias("Key Alias");
    ssl.setKeyPassword("iloveyou");
    ssl.setKeyStore("Key Store");
    ssl.setKeyStorePassword("iloveyou");
    ssl.setKeyStoreProvider("Key Store Provider");
    ssl.setKeyStoreType("Key Store Type");
    ssl.setProtocol("Protocol");
    ssl.setTrustCertificate("Trust Certificate");
    ssl.setTrustCertificatePrivateKey("Trust Certificate Private Key");
    ssl.setTrustStore("Trust Store");
    ssl.setTrustStorePassword("iloveyou");
    ssl.setTrustStoreProvider("Trust Store Provider");
    ssl.setTrustStoreType("Trust Store Type");

    ServerProperties serverProperties = new ServerProperties();
    serverProperties.setAddress(mock(InetAddress.class));
    serverProperties.setForwardHeadersStrategy(ForwardHeadersStrategy.NATIVE);
    serverProperties.setMaxHttpRequestHeaderSize(DataSize.ofBytes(1L));
    serverProperties.setPort(8080);
    serverProperties.setServerHeader("Server Header");
    serverProperties.setShutdown(Shutdown.GRACEFUL);
    serverProperties.setSsl(ssl);

    // Act
    SslCredentialsConfig actualHttpServerSslCredentialsResult =
        new SslCredentialsWebServerCustomizer(serverProperties).httpServerSslCredentials();

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
