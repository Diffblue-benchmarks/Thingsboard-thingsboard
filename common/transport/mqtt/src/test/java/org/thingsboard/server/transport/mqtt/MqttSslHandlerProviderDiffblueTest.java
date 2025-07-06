package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.handler.ssl.SslHandler;
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
import org.thingsboard.server.common.transport.config.ssl.KeystoreSslCredentials;
import org.thingsboard.server.common.transport.config.ssl.PemSslCredentials;
import org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class MqttSslHandlerProviderDiffblueTest {
  @InjectMocks private MqttSslHandlerProvider mqttSslHandlerProvider;

  @Mock private SslCredentialsConfig sslCredentialsConfig;

  /**
   * Test {@link MqttSslHandlerProvider#mqttSslCredentials()}.
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#mqttSslCredentials()}
   */
  @Test
  @DisplayName("Test mqttSslCredentials()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SslCredentialsConfig MqttSslHandlerProvider.mqttSslCredentials()"})
  void testMqttSslCredentials() {
    // Arrange and Act
    SslCredentialsConfig actualMqttSslCredentialsResult =
        mqttSslHandlerProvider.mqttSslCredentials();

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
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
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
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
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
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler_thenThrowRuntimeException() {
    // Arrange
    when(sslCredentialsConfig.getCredentials())
        .thenThrow(new RuntimeException("Failed to get SSL context"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mqttSslHandlerProvider.getSslHandler());
    verify(sslCredentialsConfig).getCredentials();
  }
}
