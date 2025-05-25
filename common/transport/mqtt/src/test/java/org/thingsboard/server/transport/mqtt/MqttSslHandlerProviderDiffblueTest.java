package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rabbitmq.client.TrustEverythingTrustManager;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.KeyManagerFactoryWrapper;
import io.grpc.util.AdvancedTlsX509KeyManager;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.ssl.util.TrustManagerFactoryWrapper;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.config.ssl.KeystoreSslCredentials;
import org.thingsboard.server.common.transport.config.ssl.PemSslCredentials;
import org.thingsboard.server.common.transport.config.ssl.SslCredentials;
import org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig;
import org.thingsboard.server.transport.mqtt.MqttSslHandlerProvider.ThingsboardMqttX509TrustManager;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class MqttSslHandlerProviderDiffblueTest {
  @InjectMocks
  private MqttSslHandlerProvider mqttSslHandlerProvider;

  @Mock
  private SslCredentialsConfig sslCredentialsConfig;

  @Mock
  private TransportService transportService;

  /**
   * Test {@link MqttSslHandlerProvider#mqttSslCredentials()}.
   * <p>
   * Method under test: {@link MqttSslHandlerProvider#mqttSslCredentials()}
   */
  @Test
  @DisplayName("Test mqttSslCredentials()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SslCredentialsConfig MqttSslHandlerProvider.mqttSslCredentials()"})
  void testMqttSslCredentials() {
    // Arrange and Act
    SslCredentialsConfig actualMqttSslCredentialsResult = mqttSslHandlerProvider.mqttSslCredentials();

    // Assert
    assertEquals("MQTT SSL Credentials", actualMqttSslCredentialsResult.getName());
    assertNull(actualMqttSslCredentialsResult.getKeystore());
    assertNull(actualMqttSslCredentialsResult.getPem());
    assertNull(actualMqttSslCredentialsResult.getCredentials());
    assertNull(actualMqttSslCredentialsResult.getType());
    assertFalse(actualMqttSslCredentialsResult.isTrustsOnly());
    assertTrue(actualMqttSslCredentialsResult.isEnabled());
  }

  /**
   * Test {@link MqttSslHandlerProvider#getSslHandler()}.
   * <p>
   * Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler() {
    // Arrange
    when(sslCredentialsConfig.getCredentials()).thenReturn(new KeystoreSslCredentials());

    // Act
    SslHandler actualSslHandler = mqttSslHandlerProvider.getSslHandler();

    // Assert
    verify(sslCredentialsConfig).getCredentials();
    SSLEngine engineResult = actualSslHandler.engine();
    assertNull(engineResult.getApplicationProtocol());
    assertNull(engineResult.getHandshakeApplicationProtocol());
    assertNull(engineResult.getPeerHost());
    assertNull(engineResult.getHandshakeApplicationProtocolSelector());
    assertNull(engineResult.getHandshakeSession());
    assertEquals(-1, engineResult.getPeerPort());
    assertEquals(0L, actualSslHandler.getCloseNotifyReadTimeoutMillis());
    assertEquals(10000L, actualSslHandler.getHandshakeTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyFlushTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyTimeoutMillis());
    assertFalse(actualSslHandler.isSingleDecode());
  }

  /**
   * Test {@link MqttSslHandlerProvider#getSslHandler()}.
   * <p>
   * Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler2() {
    // Arrange
    when(sslCredentialsConfig.getCredentials()).thenReturn(new PemSslCredentials());

    // Act
    SslHandler actualSslHandler = mqttSslHandlerProvider.getSslHandler();

    // Assert
    verify(sslCredentialsConfig).getCredentials();
    SSLEngine engineResult = actualSslHandler.engine();
    assertNull(engineResult.getApplicationProtocol());
    assertNull(engineResult.getHandshakeApplicationProtocol());
    assertNull(engineResult.getPeerHost());
    assertNull(engineResult.getHandshakeApplicationProtocolSelector());
    assertNull(engineResult.getHandshakeSession());
    assertEquals(-1, engineResult.getPeerPort());
    assertEquals(0L, actualSslHandler.getCloseNotifyReadTimeoutMillis());
    assertEquals(10000L, actualSslHandler.getHandshakeTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyFlushTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyTimeoutMillis());
    assertFalse(actualSslHandler.isSingleDecode());
  }

  /**
   * Test {@link MqttSslHandlerProvider#getSslHandler()}.
   * <p>
   * Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler3()
      throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException, CertificateException {
    // Arrange
    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.createKeyManagerFactory())
        .thenReturn(new KeyManagerFactoryWrapper(new AdvancedTlsX509KeyManager()));
    when(sslCredentials.createTrustManagerFactory()).thenReturn(new TrustManagerFactoryWrapper(
        new ThingsboardMqttX509TrustManager(new TrustEverythingTrustManager(), transportService)));
    when(sslCredentialsConfig.getCredentials()).thenReturn(sslCredentials);

    // Act
    SslHandler actualSslHandler = mqttSslHandlerProvider.getSslHandler();

    // Assert
    verify(sslCredentials).createKeyManagerFactory();
    verify(sslCredentials).createTrustManagerFactory();
    verify(sslCredentialsConfig).getCredentials();
    SSLEngine engineResult = actualSslHandler.engine();
    assertNull(engineResult.getApplicationProtocol());
    assertNull(engineResult.getHandshakeApplicationProtocol());
    assertNull(engineResult.getPeerHost());
    assertNull(engineResult.getHandshakeApplicationProtocolSelector());
    assertNull(engineResult.getHandshakeSession());
    assertEquals(-1, engineResult.getPeerPort());
    assertEquals(0L, actualSslHandler.getCloseNotifyReadTimeoutMillis());
    assertEquals(10000L, actualSslHandler.getHandshakeTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyFlushTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyTimeoutMillis());
    assertFalse(actualSslHandler.isSingleDecode());
  }

  /**
   * Test {@link MqttSslHandlerProvider#getSslHandler()}.
   * <p>
   * Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler4()
      throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException, CertificateException {
    // Arrange
    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.createKeyManagerFactory())
        .thenReturn(new io.netty.handler.ssl.util.KeyManagerFactoryWrapper(new AdvancedTlsX509KeyManager()));
    when(sslCredentials.createTrustManagerFactory())
        .thenReturn(new io.grpc.netty.shaded.io.netty.handler.ssl.util.TrustManagerFactoryWrapper(
            new ThingsboardMqttX509TrustManager(new TrustEverythingTrustManager(), transportService)));
    when(sslCredentialsConfig.getCredentials()).thenReturn(sslCredentials);

    // Act
    SslHandler actualSslHandler = mqttSslHandlerProvider.getSslHandler();

    // Assert
    verify(sslCredentials).createKeyManagerFactory();
    verify(sslCredentials).createTrustManagerFactory();
    verify(sslCredentialsConfig).getCredentials();
    SSLEngine engineResult = actualSslHandler.engine();
    assertNull(engineResult.getApplicationProtocol());
    assertNull(engineResult.getHandshakeApplicationProtocol());
    assertNull(engineResult.getPeerHost());
    assertNull(engineResult.getHandshakeApplicationProtocolSelector());
    assertNull(engineResult.getHandshakeSession());
    assertEquals(-1, engineResult.getPeerPort());
    assertEquals(0L, actualSslHandler.getCloseNotifyReadTimeoutMillis());
    assertEquals(10000L, actualSslHandler.getHandshakeTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyFlushTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyTimeoutMillis());
    assertFalse(actualSslHandler.isSingleDecode());
  }
}
