package org.thingsboard.server.transport.lwm2m.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig;

class LwM2MTransportBootstrapConfigDiffblueTest {
  /**
   * Test {@link LwM2MTransportBootstrapConfig#lwm2mBootstrapCredentials()}.
   * <p>
   * Method under test:
   * {@link LwM2MTransportBootstrapConfig#lwm2mBootstrapCredentials()}
   */
  @Test
  @DisplayName("Test lwm2mBootstrapCredentials()")
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

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
}
