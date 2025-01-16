package org.thingsboard.server.service.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.LazyX509Certificate;
import java.io.UnsupportedEncodingException;
import java.security.cert.X509Certificate;
import java.util.Optional;
import oracle.security.crypto.core.DHPublicKey;
import org.apache.sshd.common.config.keys.OpenSshCertificateImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap.LwM2MServerSecurityConfigDefault;
import org.thingsboard.server.common.transport.config.ssl.KeystoreSslCredentials;
import org.thingsboard.server.common.transport.config.ssl.SslCredentials;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportBootstrapConfig;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;

class LwM2MServiceImplDiffblueTest {
  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean)")
  void testGetServerSecurityInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
    when(lwM2MTransportBootstrapConfig.getId()).thenReturn(1);
    when(lwM2MTransportBootstrapConfig.getPort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getSecurePort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSecureHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSslCredentials()).thenReturn(new KeystoreSslCredentials());
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.of(lwM2MTransportBootstrapConfig);

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo = (new LwM2MServiceImpl(new LwM2MTransportServerConfig(),
        bootstrapConfig)).getServerSecurityInfo(true);

    // Assert
    verify(lwM2MTransportBootstrapConfig).getHost();
    verify(lwM2MTransportBootstrapConfig).getId();
    verify(lwM2MTransportBootstrapConfig).getPort();
    verify(lwM2MTransportBootstrapConfig).getSecureHost();
    verify(lwM2MTransportBootstrapConfig).getSecurePort();
    verify(lwM2MTransportBootstrapConfig, atLeast(1)).getSslCredentials();
    assertEquals("", actualServerSecurityInfo.getServerCertificate());
    assertEquals("localhost", actualServerSecurityInfo.getHost());
    assertEquals("localhost", actualServerSecurityInfo.getSecurityHost());
    assertEquals(1, actualServerSecurityInfo.getShortServerId().intValue());
    assertEquals(8080, actualServerSecurityInfo.getPort().intValue());
    assertEquals(8080, actualServerSecurityInfo.getSecurityPort().intValue());
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean)")
  void testGetServerSecurityInfo2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
    when(lwM2MTransportBootstrapConfig.getId()).thenReturn(1);
    when(lwM2MTransportBootstrapConfig.getPort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getSecurePort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSecureHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSslCredentials()).thenReturn(null);
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.of(lwM2MTransportBootstrapConfig);

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo = (new LwM2MServiceImpl(new LwM2MTransportServerConfig(),
        bootstrapConfig)).getServerSecurityInfo(true);

    // Assert
    verify(lwM2MTransportBootstrapConfig).getHost();
    verify(lwM2MTransportBootstrapConfig).getId();
    verify(lwM2MTransportBootstrapConfig).getPort();
    verify(lwM2MTransportBootstrapConfig).getSecureHost();
    verify(lwM2MTransportBootstrapConfig).getSecurePort();
    verify(lwM2MTransportBootstrapConfig, atLeast(1)).getSslCredentials();
    assertEquals("", actualServerSecurityInfo.getServerCertificate());
    assertEquals("localhost", actualServerSecurityInfo.getHost());
    assertEquals("localhost", actualServerSecurityInfo.getSecurityHost());
    assertEquals(1, actualServerSecurityInfo.getShortServerId().intValue());
    assertEquals(8080, actualServerSecurityInfo.getPort().intValue());
    assertEquals(8080, actualServerSecurityInfo.getSecurityPort().intValue());
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean)")
  void testGetServerSecurityInfo3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.getPublicKey()).thenReturn(new DHPublicKey());
    when(sslCredentials.getCertificateChain()).thenReturn(new X509Certificate[]{new LazyX509Certificate(
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1})});
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
    when(lwM2MTransportBootstrapConfig.getId()).thenReturn(1);
    when(lwM2MTransportBootstrapConfig.getPort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getSecurePort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSecureHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSslCredentials()).thenReturn(sslCredentials);
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.of(lwM2MTransportBootstrapConfig);

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo = (new LwM2MServiceImpl(new LwM2MTransportServerConfig(),
        bootstrapConfig)).getServerSecurityInfo(true);

    // Assert
    verify(sslCredentials).getCertificateChain();
    verify(sslCredentials).getPublicKey();
    verify(lwM2MTransportBootstrapConfig).getHost();
    verify(lwM2MTransportBootstrapConfig).getId();
    verify(lwM2MTransportBootstrapConfig).getPort();
    verify(lwM2MTransportBootstrapConfig).getSecureHost();
    verify(lwM2MTransportBootstrapConfig).getSecurePort();
    verify(lwM2MTransportBootstrapConfig, atLeast(1)).getSslCredentials();
    assertEquals("QQFBAUEBQQFBAUEBQQFBAUEBQQFBAUEB", actualServerSecurityInfo.getServerCertificate());
    assertEquals("localhost", actualServerSecurityInfo.getHost());
    assertEquals("localhost", actualServerSecurityInfo.getSecurityHost());
    assertEquals(1, actualServerSecurityInfo.getShortServerId().intValue());
    assertEquals(8080, actualServerSecurityInfo.getPort().intValue());
    assertEquals(8080, actualServerSecurityInfo.getSecurityPort().intValue());
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean)")
  void testGetServerSecurityInfo4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.getPublicKey()).thenReturn(new DHPublicKey());
    when(sslCredentials.getCertificateChain()).thenReturn(new X509Certificate[]{null});
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
    when(lwM2MTransportBootstrapConfig.getId()).thenReturn(1);
    when(lwM2MTransportBootstrapConfig.getPort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getSecurePort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSecureHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSslCredentials()).thenReturn(sslCredentials);
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.of(lwM2MTransportBootstrapConfig);

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo = (new LwM2MServiceImpl(new LwM2MTransportServerConfig(),
        bootstrapConfig)).getServerSecurityInfo(true);

    // Assert
    verify(sslCredentials).getCertificateChain();
    verify(sslCredentials).getPublicKey();
    verify(lwM2MTransportBootstrapConfig).getHost();
    verify(lwM2MTransportBootstrapConfig).getId();
    verify(lwM2MTransportBootstrapConfig).getPort();
    verify(lwM2MTransportBootstrapConfig).getSecureHost();
    verify(lwM2MTransportBootstrapConfig).getSecurePort();
    verify(lwM2MTransportBootstrapConfig, atLeast(1)).getSslCredentials();
    assertEquals("", actualServerSecurityInfo.getServerCertificate());
    assertEquals("localhost", actualServerSecurityInfo.getHost());
    assertEquals("localhost", actualServerSecurityInfo.getSecurityHost());
    assertEquals(1, actualServerSecurityInfo.getShortServerId().intValue());
    assertEquals(8080, actualServerSecurityInfo.getPort().intValue());
    assertEquals(8080, actualServerSecurityInfo.getSecurityPort().intValue());
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <ul>
   *   <li>Given {@link Optional} with {@link LwM2MTransportBootstrapConfig}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean); given Optional with LwM2MTransportBootstrapConfig (default constructor)")
  void testGetServerSecurityInfo_givenOptionalWithLwM2MTransportBootstrapConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig serverConfig = new LwM2MTransportServerConfig();
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.of(new LwM2MTransportBootstrapConfig());

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo = (new LwM2MServiceImpl(serverConfig, bootstrapConfig))
        .getServerSecurityInfo(true);

    // Assert
    assertNull(actualServerSecurityInfo.getPort());
    assertNull(actualServerSecurityInfo.getShortServerId());
    assertNull(actualServerSecurityInfo.getSecurityPort());
    assertNull(actualServerSecurityInfo.getHost());
    assertNull(actualServerSecurityInfo.getSecurityHost());
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>Then return ServerCertificate is {@code /1hBWEFYQVg=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean); given 'X'; then return ServerCertificate is '/1hBWEFYQVg='")
  void testGetServerSecurityInfo_givenX_thenReturnServerCertificateIs1hBWEFYQVg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.getPublicKey()).thenReturn(new OpenSshCertificateImpl());
    when(sslCredentials.getCertificateChain())
        .thenReturn(new X509Certificate[]{new LazyX509Certificate(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})});
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
    when(lwM2MTransportBootstrapConfig.getId()).thenReturn(1);
    when(lwM2MTransportBootstrapConfig.getPort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getSecurePort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSecureHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSslCredentials()).thenReturn(sslCredentials);
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.of(lwM2MTransportBootstrapConfig);

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo = (new LwM2MServiceImpl(new LwM2MTransportServerConfig(),
        bootstrapConfig)).getServerSecurityInfo(true);

    // Assert
    verify(sslCredentials).getCertificateChain();
    verify(sslCredentials).getPublicKey();
    verify(lwM2MTransportBootstrapConfig).getHost();
    verify(lwM2MTransportBootstrapConfig).getId();
    verify(lwM2MTransportBootstrapConfig).getPort();
    verify(lwM2MTransportBootstrapConfig).getSecureHost();
    verify(lwM2MTransportBootstrapConfig).getSecurePort();
    verify(lwM2MTransportBootstrapConfig, atLeast(1)).getSslCredentials();
    assertEquals("/1hBWEFYQVg=", actualServerSecurityInfo.getServerCertificate());
    assertEquals("localhost", actualServerSecurityInfo.getHost());
    assertEquals("localhost", actualServerSecurityInfo.getSecurityHost());
    assertEquals(1, actualServerSecurityInfo.getShortServerId().intValue());
    assertEquals(8080, actualServerSecurityInfo.getPort().intValue());
    assertEquals(8080, actualServerSecurityInfo.getSecurityPort().intValue());
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean); then return 'null'")
  void testGetServerSecurityInfo_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig serverConfig = new LwM2MTransportServerConfig();
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.empty();

    // Act and Assert
    assertNull((new LwM2MServiceImpl(serverConfig, bootstrapConfig)).getServerSecurityInfo(true));
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <ul>
   *   <li>Then return ServerCertificate is {@code QVhBWEFYQVg=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean); then return ServerCertificate is 'QVhBWEFYQVg='")
  void testGetServerSecurityInfo_thenReturnServerCertificateIsQVhBWEFYQVg() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.getPublicKey()).thenReturn(new DHPublicKey());
    when(sslCredentials.getCertificateChain())
        .thenReturn(new X509Certificate[]{new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))});
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
    when(lwM2MTransportBootstrapConfig.getId()).thenReturn(1);
    when(lwM2MTransportBootstrapConfig.getPort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getSecurePort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSecureHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSslCredentials()).thenReturn(sslCredentials);
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.of(lwM2MTransportBootstrapConfig);

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo = (new LwM2MServiceImpl(new LwM2MTransportServerConfig(),
        bootstrapConfig)).getServerSecurityInfo(true);

    // Assert
    verify(sslCredentials).getCertificateChain();
    verify(sslCredentials).getPublicKey();
    verify(lwM2MTransportBootstrapConfig).getHost();
    verify(lwM2MTransportBootstrapConfig).getId();
    verify(lwM2MTransportBootstrapConfig).getPort();
    verify(lwM2MTransportBootstrapConfig).getSecureHost();
    verify(lwM2MTransportBootstrapConfig).getSecurePort();
    verify(lwM2MTransportBootstrapConfig, atLeast(1)).getSslCredentials();
    assertEquals("QVhBWEFYQVg=", actualServerSecurityInfo.getServerCertificate());
    assertEquals("localhost", actualServerSecurityInfo.getHost());
    assertEquals("localhost", actualServerSecurityInfo.getSecurityHost());
    assertEquals(1, actualServerSecurityInfo.getShortServerId().intValue());
    assertEquals(8080, actualServerSecurityInfo.getPort().intValue());
    assertEquals(8080, actualServerSecurityInfo.getSecurityPort().intValue());
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <ul>
   *   <li>Then return ServerCertificate is {@code QVhBWEFYQVg=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean); then return ServerCertificate is 'QVhBWEFYQVg='")
  void testGetServerSecurityInfo_thenReturnServerCertificateIsQVhBWEFYQVg2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.getPublicKey()).thenReturn(new OpenSshCertificateImpl());
    when(sslCredentials.getCertificateChain())
        .thenReturn(new X509Certificate[]{new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))});
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
    when(lwM2MTransportBootstrapConfig.getId()).thenReturn(1);
    when(lwM2MTransportBootstrapConfig.getPort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getSecurePort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSecureHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSslCredentials()).thenReturn(sslCredentials);
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.of(lwM2MTransportBootstrapConfig);

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo = (new LwM2MServiceImpl(new LwM2MTransportServerConfig(),
        bootstrapConfig)).getServerSecurityInfo(true);

    // Assert
    verify(sslCredentials).getCertificateChain();
    verify(sslCredentials).getPublicKey();
    verify(lwM2MTransportBootstrapConfig).getHost();
    verify(lwM2MTransportBootstrapConfig).getId();
    verify(lwM2MTransportBootstrapConfig).getPort();
    verify(lwM2MTransportBootstrapConfig).getSecureHost();
    verify(lwM2MTransportBootstrapConfig).getSecurePort();
    verify(lwM2MTransportBootstrapConfig, atLeast(1)).getSslCredentials();
    assertEquals("QVhBWEFYQVg=", actualServerSecurityInfo.getServerCertificate());
    assertEquals("localhost", actualServerSecurityInfo.getHost());
    assertEquals("localhost", actualServerSecurityInfo.getSecurityHost());
    assertEquals(1, actualServerSecurityInfo.getShortServerId().intValue());
    assertEquals(8080, actualServerSecurityInfo.getPort().intValue());
    assertEquals(8080, actualServerSecurityInfo.getSecurityPort().intValue());
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <ul>
   *   <li>Then return ServerCertificate is {@code QQFBAUEBQQFBAUEBQQFBAQ==}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean); then return ServerCertificate is 'QQFBAUEBQQFBAUEBQQFBAQ=='")
  void testGetServerSecurityInfo_thenReturnServerCertificateIsQqfbauebqqfbauebqqfbaq() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.getPublicKey()).thenReturn(new DHPublicKey());
    when(sslCredentials.getCertificateChain()).thenReturn(new X509Certificate[]{
        new LazyX509Certificate(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1})});
    LwM2MTransportBootstrapConfig lwM2MTransportBootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
    when(lwM2MTransportBootstrapConfig.getId()).thenReturn(1);
    when(lwM2MTransportBootstrapConfig.getPort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getSecurePort()).thenReturn(8080);
    when(lwM2MTransportBootstrapConfig.getHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSecureHost()).thenReturn("localhost");
    when(lwM2MTransportBootstrapConfig.getSslCredentials()).thenReturn(sslCredentials);
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.of(lwM2MTransportBootstrapConfig);

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo = (new LwM2MServiceImpl(new LwM2MTransportServerConfig(),
        bootstrapConfig)).getServerSecurityInfo(true);

    // Assert
    verify(sslCredentials).getCertificateChain();
    verify(sslCredentials).getPublicKey();
    verify(lwM2MTransportBootstrapConfig).getHost();
    verify(lwM2MTransportBootstrapConfig).getId();
    verify(lwM2MTransportBootstrapConfig).getPort();
    verify(lwM2MTransportBootstrapConfig).getSecureHost();
    verify(lwM2MTransportBootstrapConfig).getSecurePort();
    verify(lwM2MTransportBootstrapConfig, atLeast(1)).getSslCredentials();
    assertEquals("QQFBAUEBQQFBAUEBQQFBAQ==", actualServerSecurityInfo.getServerCertificate());
    assertEquals("localhost", actualServerSecurityInfo.getHost());
    assertEquals("localhost", actualServerSecurityInfo.getSecurityHost());
    assertEquals(1, actualServerSecurityInfo.getShortServerId().intValue());
    assertEquals(8080, actualServerSecurityInfo.getPort().intValue());
    assertEquals(8080, actualServerSecurityInfo.getSecurityPort().intValue());
  }

  /**
   * Test {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return not BootstrapServerIs.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MServiceImpl#getServerSecurityInfo(boolean)}
   */
  @Test
  @DisplayName("Test getServerSecurityInfo(boolean); when 'false'; then return not BootstrapServerIs")
  void testGetServerSecurityInfo_whenFalse_thenReturnNotBootstrapServerIs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig serverConfig = new LwM2MTransportServerConfig();
    Optional<LwM2MTransportBootstrapConfig> bootstrapConfig = Optional.of(mock(LwM2MTransportBootstrapConfig.class));

    // Act
    LwM2MServerSecurityConfigDefault actualServerSecurityInfo = (new LwM2MServiceImpl(serverConfig, bootstrapConfig))
        .getServerSecurityInfo(false);

    // Assert
    assertNull(actualServerSecurityInfo.getPort());
    assertNull(actualServerSecurityInfo.getShortServerId());
    assertNull(actualServerSecurityInfo.getSecurityPort());
    assertNull(actualServerSecurityInfo.getHost());
    assertNull(actualServerSecurityInfo.getSecurityHost());
    assertFalse(actualServerSecurityInfo.isBootstrapServerIs());
  }
}
