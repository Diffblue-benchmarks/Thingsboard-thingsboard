package org.thingsboard.server.transport.lwm2m.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.transport.config.ssl.KeystoreSslCredentials;
import org.thingsboard.server.common.transport.config.ssl.SslCredentials;
import org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig;

@ExtendWith(MockitoExtension.class)
class LwM2MTransportBootstrapConfigDiffblueTest {
  @InjectMocks private LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig;

  @Mock private SslCredentialsConfig sslCredentialsConfig;

  /**
   * Test {@link LwM2MTransportBootstrapConfig#lwm2mBootstrapCredentials()}.
   *
   * <p>Method under test: {@link LwM2MTransportBootstrapConfig#lwm2mBootstrapCredentials()}
   */
  @Test
  @DisplayName("Test lwm2mBootstrapCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SslCredentialsConfig LwM2MTransportBootstrapConfig.lwm2mBootstrapCredentials()"
  })
  void testLwm2mBootstrapCredentials() {
    // Arrange and Act
    SslCredentialsConfig actualLwm2mBootstrapCredentialsResult =
        new LwM2MTransportBootstrapConfig().lwm2mBootstrapCredentials();

    // Assert
    assertEquals(
        "LWM2M Bootstrap DTLS Credentials", actualLwm2mBootstrapCredentialsResult.getName());
    assertNull(actualLwm2mBootstrapCredentialsResult.getKeystore());
    assertNull(actualLwm2mBootstrapCredentialsResult.getPem());
    assertNull(actualLwm2mBootstrapCredentialsResult.getCredentials());
    assertNull(actualLwm2mBootstrapCredentialsResult.getType());
    assertFalse(actualLwm2mBootstrapCredentialsResult.isTrustsOnly());
    assertTrue(actualLwm2mBootstrapCredentialsResult.isEnabled());
  }

  /**
   * Test {@link LwM2MTransportBootstrapConfig#getSslCredentials()}.
   *
   * <p>Method under test: {@link LwM2MTransportBootstrapConfig#getSslCredentials()}
   */
  @Test
  @DisplayName("Test getSslCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslCredentials LwM2MTransportBootstrapConfig.getSslCredentials()"})
  void testGetSslCredentials() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    when(sslCredentialsConfig.getCredentials()).thenReturn(keystoreSslCredentials);

    // Act
    SslCredentials actualSslCredentials = lwM2MTransportBootstrapConfig.getSslCredentials();

    // Assert
    verify(sslCredentialsConfig).getCredentials();
    assertSame(keystoreSslCredentials, actualSslCredentials);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String LwM2MTransportBootstrapConfig.getHost()",
    "Integer LwM2MTransportBootstrapConfig.getId()",
    "Integer LwM2MTransportBootstrapConfig.getPort()",
    "String LwM2MTransportBootstrapConfig.getSecureHost()",
    "Integer LwM2MTransportBootstrapConfig.getSecurePort()"
  })
  void testGettersAndSetters() {
    // Arrange
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig =
        new LwM2MTransportBootstrapConfig();

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
