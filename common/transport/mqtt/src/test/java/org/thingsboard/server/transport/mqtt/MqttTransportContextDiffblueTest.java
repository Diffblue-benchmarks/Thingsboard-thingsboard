package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.handler.ssl.SslHandler;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.common.util.ThingsBoardForkJoinWorkerThreadFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportTenantProfileCache;
import org.thingsboard.server.common.transport.limits.TransportRateLimitService;
import org.thingsboard.server.transport.mqtt.adaptors.JsonMqttAdaptor;
import org.thingsboard.server.transport.mqtt.adaptors.ProtoMqttAdaptor;
import org.thingsboard.server.transport.mqtt.gateway.GatewayMetricsService;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class MqttTransportContextDiffblueTest {
  @InjectMocks private MqttTransportContext mqttTransportContext;

  @Mock private TransportRateLimitService transportRateLimitService;

  @Mock private TransportService transportService;

  /**
   * Test {@link MqttTransportContext#init()}.
   *
   * <p>Method under test: {@link MqttTransportContext#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportContext.init()"})
  void testInit() {
    // Arrange
    doNothing()
        .when(transportService)
        .createGaugeStats(Mockito.<String>any(), Mockito.<AtomicInteger>any());

    // Act
    mqttTransportContext.init();

    // Assert
    verify(transportService).createGaugeStats(eq("openConnections"), isA(AtomicInteger.class));
    ExecutorService executor = mqttTransportContext.getExecutor();
    assertTrue(executor instanceof ForkJoinPool);
    assertTrue(
        ((ForkJoinPool) executor).getFactory() instanceof ThingsBoardForkJoinWorkerThreadFactory);
    assertNull(((ForkJoinPool) executor).getUncaughtExceptionHandler());
    assertEquals(0, ((ForkJoinPool) executor).getActiveThreadCount());
    assertEquals(0, ((ForkJoinPool) executor).getPoolSize());
    assertEquals(0, ((ForkJoinPool) executor).getQueuedSubmissionCount());
    assertEquals(0, ((ForkJoinPool) executor).getRunningThreadCount());
    assertEquals(0L, ((ForkJoinPool) executor).getQueuedTaskCount());
    assertEquals(0L, ((ForkJoinPool) executor).getStealCount());
    assertEquals(50, ((ForkJoinPool) executor).getParallelism());
    assertFalse(((ForkJoinPool) executor).hasQueuedSubmissions());
    assertFalse(((ForkJoinPool) executor).isTerminating());
    assertTrue(((ForkJoinPool) executor).getAsyncMode());
    assertTrue(((ForkJoinPool) executor).isQuiescent());
  }

  /**
   * Test {@link MqttTransportContext#checkAddress(InetSocketAddress)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportContext#checkAddress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test checkAddress(InetSocketAddress); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttTransportContext.checkAddress(InetSocketAddress)"})
  void testCheckAddress_thenReturnFalse() {
    // Arrange
    when(transportRateLimitService.checkAddress(Mockito.<InetSocketAddress>any()))
        .thenReturn(false);

    // Act
    boolean actualCheckAddressResult =
        mqttTransportContext.checkAddress(InetSocketAddress.createUnresolved("foo", 1));

    // Assert
    verify(transportRateLimitService).checkAddress(isA(InetSocketAddress.class));
    assertFalse(actualCheckAddressResult);
  }

  /**
   * Test {@link MqttTransportContext#checkAddress(InetSocketAddress)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportContext#checkAddress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test checkAddress(InetSocketAddress); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttTransportContext.checkAddress(InetSocketAddress)"})
  void testCheckAddress_thenReturnTrue() {
    // Arrange
    when(transportRateLimitService.checkAddress(Mockito.<InetSocketAddress>any())).thenReturn(true);

    // Act
    boolean actualCheckAddressResult =
        mqttTransportContext.checkAddress(InetSocketAddress.createUnresolved("foo", 1));

    // Assert
    verify(transportRateLimitService).checkAddress(isA(InetSocketAddress.class));
    assertTrue(actualCheckAddressResult);
  }

  /**
   * Test {@link MqttTransportContext#onAuthSuccess(InetSocketAddress)}.
   *
   * <p>Method under test: {@link MqttTransportContext#onAuthSuccess(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test onAuthSuccess(InetSocketAddress)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportContext.onAuthSuccess(InetSocketAddress)"})
  void testOnAuthSuccess() {
    // Arrange
    doNothing().when(transportRateLimitService).onAuthSuccess(Mockito.<InetSocketAddress>any());

    // Act
    mqttTransportContext.onAuthSuccess(InetSocketAddress.createUnresolved("foo", 1));

    // Assert
    verify(transportRateLimitService).onAuthSuccess(isA(InetSocketAddress.class));
  }

  /**
   * Test {@link MqttTransportContext#onAuthFailure(InetSocketAddress)}.
   *
   * <p>Method under test: {@link MqttTransportContext#onAuthFailure(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test onAuthFailure(InetSocketAddress)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportContext.onAuthFailure(InetSocketAddress)"})
  void testOnAuthFailure() {
    // Arrange
    doNothing().when(transportRateLimitService).onAuthFailure(Mockito.<InetSocketAddress>any());

    // Act
    mqttTransportContext.onAuthFailure(InetSocketAddress.createUnresolved("foo", 1));

    // Assert
    verify(transportRateLimitService).onAuthFailure(isA(InetSocketAddress.class));
  }

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
  @Tag("MaintainedByDiffblue")
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
