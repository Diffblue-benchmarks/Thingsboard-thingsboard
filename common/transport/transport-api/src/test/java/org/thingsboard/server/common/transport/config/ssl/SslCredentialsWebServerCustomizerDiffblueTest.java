package org.thingsboard.server.common.transport.config.ssl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.net.InetAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.ServerProperties;

class SslCredentialsWebServerCustomizerDiffblueTest {
  /**
   * Test {@link SslCredentialsWebServerCustomizer#httpServerSslCredentials()}.
   * <p>
   * Method under test:
   * {@link SslCredentialsWebServerCustomizer#httpServerSslCredentials()}
   */
  @Test
  @DisplayName("Test httpServerSslCredentials()")
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
   * Test {@link SslCredentialsWebServerCustomizer#httpServerSslCredentials()}.
   * <ul>
   *   <li>Given {@link ServerProperties} (default constructor) Address is
   * {@link InetAddress}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SslCredentialsWebServerCustomizer#httpServerSslCredentials()}
   */
  @Test
  @DisplayName("Test httpServerSslCredentials(); given ServerProperties (default constructor) Address is InetAddress")
  void testHttpServerSslCredentials_givenServerPropertiesAddressIsInetAddress() {
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
