package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.handler.ssl.SslHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.transport.TransportTenantProfileCache;
import org.thingsboard.server.transport.mqtt.adaptors.JsonMqttAdaptor;
import org.thingsboard.server.transport.mqtt.adaptors.ProtoMqttAdaptor;
import org.thingsboard.server.transport.mqtt.gateway.GatewayMetricsService;

class MqttTransportContextDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttTransportContext#getDisconnectTimeout()}
   *   <li>{@link MqttTransportContext#getGatewayMetricsService()}
   *   <li>{@link MqttTransportContext#getJsonMqttAdaptor()}
   *   <li>{@link MqttTransportContext#getMaxPayloadSize()}
   *   <li>{@link MqttTransportContext#getMessageQueueSizePerDeviceLimit()}
   *   <li>{@link MqttTransportContext#getProtoMqttAdaptor()}
   *   <li>{@link MqttTransportContext#getSslHandler()}
   *   <li>{@link MqttTransportContext#getSslHandlerProvider()}
   *   <li>{@link MqttTransportContext#getTenantProfileCache()}
   *   <li>{@link MqttTransportContext#getTimeout()}
   *   <li>{@link MqttTransportContext#isProxyEnabled()}
   *   <li>{@link MqttTransportContext#isSkipValidityCheckForClientCert()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long MqttTransportContext.getDisconnectTimeout()",
    "GatewayMetricsService MqttTransportContext.getGatewayMetricsService()",
    "JsonMqttAdaptor MqttTransportContext.getJsonMqttAdaptor()",
    "Integer MqttTransportContext.getMaxPayloadSize()",
    "int MqttTransportContext.getMessageQueueSizePerDeviceLimit()",
    "ProtoMqttAdaptor MqttTransportContext.getProtoMqttAdaptor()",
    "SslHandler MqttTransportContext.getSslHandler()",
    "MqttSslHandlerProvider MqttTransportContext.getSslHandlerProvider()",
    "TransportTenantProfileCache MqttTransportContext.getTenantProfileCache()",
    "long MqttTransportContext.getTimeout()",
    "boolean MqttTransportContext.isProxyEnabled()",
    "boolean MqttTransportContext.isSkipValidityCheckForClientCert()",
    "void MqttTransportContext.setSslHandler(SslHandler)"
  })
  void testGettersAndSetters() {
    // Arrange
    MqttTransportContext mqttTransportContext = new MqttTransportContext();

    // Act
    long actualDisconnectTimeout = mqttTransportContext.getDisconnectTimeout();
    GatewayMetricsService actualGatewayMetricsService =
        mqttTransportContext.getGatewayMetricsService();
    JsonMqttAdaptor actualJsonMqttAdaptor = mqttTransportContext.getJsonMqttAdaptor();
    Integer actualMaxPayloadSize = mqttTransportContext.getMaxPayloadSize();
    int actualMessageQueueSizePerDeviceLimit =
        mqttTransportContext.getMessageQueueSizePerDeviceLimit();
    ProtoMqttAdaptor actualProtoMqttAdaptor = mqttTransportContext.getProtoMqttAdaptor();
    SslHandler actualSslHandler = mqttTransportContext.getSslHandler();
    MqttSslHandlerProvider actualSslHandlerProvider = mqttTransportContext.getSslHandlerProvider();
    TransportTenantProfileCache actualTenantProfileCache =
        mqttTransportContext.getTenantProfileCache();
    long actualTimeout = mqttTransportContext.getTimeout();
    boolean actualIsProxyEnabledResult = mqttTransportContext.isProxyEnabled();

    // Assert
    assertNull(actualSslHandler);
    assertNull(actualMaxPayloadSize);
    assertNull(actualTenantProfileCache);
    assertNull(actualSslHandlerProvider);
    assertNull(actualJsonMqttAdaptor);
    assertNull(actualProtoMqttAdaptor);
    assertNull(actualGatewayMetricsService);
    assertEquals(0, actualMessageQueueSizePerDeviceLimit);
    assertEquals(0L, actualDisconnectTimeout);
    assertEquals(0L, actualTimeout);
    assertFalse(actualIsProxyEnabledResult);
    assertFalse(mqttTransportContext.isSkipValidityCheckForClientCert());
  }
}
