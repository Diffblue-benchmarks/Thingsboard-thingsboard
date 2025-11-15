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
package org.thingsboard.server.transport.mqtt.session;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Metric;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.MqttTransportHandler;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugMessageType;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugTopic;

class SparkplugNodeSessionHandlerDiffblueTest {
  /**
   * Test {@link SparkplugNodeSessionHandler#SparkplugNodeSessionHandler(MqttTransportHandler, DeviceSessionCtx, UUID, boolean, SparkplugTopic)}.
   * <ul>
   *   <li>Then return {@link AbstractGatewaySessionHandler#channel} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugNodeSessionHandler#SparkplugNodeSessionHandler(MqttTransportHandler, DeviceSessionCtx, UUID, boolean, SparkplugTopic)}
   */
  @Test
  @DisplayName("Test new SparkplugNodeSessionHandler(MqttTransportHandler, DeviceSessionCtx, UUID, boolean, SparkplugTopic); then return channel is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void SparkplugNodeSessionHandler.<init>(MqttTransportHandler, DeviceSessionCtx, UUID, boolean, SparkplugTopic)"})
  void testNewSparkplugNodeSessionHandler_thenReturnChannelIsNull() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode = new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    // Act
    SparkplugNodeSessionHandler actualSparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent,
        deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    // Assert
    assertNull(actualSparkplugNodeSessionHandler.channel);
    assertNull(actualSparkplugNodeSessionHandler.transportService);
    assertNull(actualSparkplugNodeSessionHandler.gateway);
    assertNull(actualSparkplugNodeSessionHandler.getPayloadAdaptor());
    assertNull(actualSparkplugNodeSessionHandler.gatewayMetricsService);
    assertTrue(actualSparkplugNodeSessionHandler.getNodeBirthMetrics().isEmpty());
    assertTrue(actualSparkplugNodeSessionHandler.mqttQoSMap.isEmpty());
    assertTrue(actualSparkplugNodeSessionHandler.isJsonPayloadType());
    assertTrue(actualSparkplugNodeSessionHandler.isOverwriteDevicesActivity());
    assertSame(sparkplugTopicNode, actualSparkplugNodeSessionHandler.getSparkplugTopicNode());
    assertSame(sessionId2, actualSparkplugNodeSessionHandler.getSessionId());
    MqttTransportContext expectedContext = actualSparkplugNodeSessionHandler.context;
    assertSame(expectedContext, deviceSessionCtx.getContext());
    ConcurrentMap<MqttTopicMatcher, Integer> expectedMqttQoSMap = actualSparkplugNodeSessionHandler.mqttQoSMap;
    assertSame(expectedMqttQoSMap, deviceSessionCtx.getMqttQoSMap());
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#onDeviceTelemetryProto(ListenableFuture, int, List, String)} with {@code contextListenableFuture}, {@code msgId}, {@code postTelemetryMsgList}, {@code deviceName}.
   * <p>
   * Method under test: {@link SparkplugNodeSessionHandler#onDeviceTelemetryProto(ListenableFuture, int, List, String)}
   */
  @Test
  @DisplayName("Test onDeviceTelemetryProto(ListenableFuture, int, List, String) with 'contextListenableFuture', 'msgId', 'postTelemetryMsgList', 'deviceName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SparkplugNodeSessionHandler.onDeviceTelemetryProto(ListenableFuture, int, List, String)"})
  void testOnDeviceTelemetryProtoWithContextListenableFutureMsgIdPostTelemetryMsgListDeviceName()
      throws InterruptedException, ExecutionException {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));
    ListenableFutureTask<MqttDeviceAwareSessionContext> delegate = mock(ListenableFutureTask.class);
    UUID sessionId3 = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap2 = new ConcurrentHashMap<>();
    when(delegate.get()).thenReturn(new DeviceSessionCtx(sessionId3, mqttQoSMap2, new MqttTransportContext()));
    when(delegate.isDone()).thenReturn(true);
    ApiFutureToListenableFuture<MqttDeviceAwareSessionContext> contextListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));

    // Act
    sparkplugNodeSessionHandler.onDeviceTelemetryProto(contextListenableFuture, 1, new ArrayList<>(), "Device Name");

    // Assert
    verify(delegate).get();
    verify(delegate).isDone();
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#onDeviceTelemetryProto(ListenableFuture, int, List, String)} with {@code contextListenableFuture}, {@code msgId}, {@code postTelemetryMsgList}, {@code deviceName}.
   * <p>
   * Method under test: {@link SparkplugNodeSessionHandler#onDeviceTelemetryProto(ListenableFuture, int, List, String)}
   */
  @Test
  @DisplayName("Test onDeviceTelemetryProto(ListenableFuture, int, List, String) with 'contextListenableFuture', 'msgId', 'postTelemetryMsgList', 'deviceName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SparkplugNodeSessionHandler.onDeviceTelemetryProto(ListenableFuture, int, List, String)"})
  void testOnDeviceTelemetryProtoWithContextListenableFutureMsgIdPostTelemetryMsgListDeviceName2() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));
    ListenableFutureTask<MqttDeviceAwareSessionContext> delegate = mock(ListenableFutureTask.class);
    when(delegate.isDone()).thenReturn(false);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ApiFutureToListenableFuture<MqttDeviceAwareSessionContext> contextListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));

    // Act
    sparkplugNodeSessionHandler.onDeviceTelemetryProto(contextListenableFuture, 1, new ArrayList<>(), "Device Name");

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(delegate).isDone();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugNodeSessionHandler#getNodeBirthMetrics()}
   *   <li>{@link SparkplugNodeSessionHandler#getSparkplugTopicNode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SparkplugNodeSessionHandler.getNodeBirthMetrics()",
      "SparkplugTopic SparkplugNodeSessionHandler.getSparkplugTopicNode()"})
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode = new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(null, deviceSessionCtx,
        sessionId2, true, sparkplugTopicNode);

    // Act
    Map<String, Metric> actualNodeBirthMetrics = sparkplugNodeSessionHandler.getNodeBirthMetrics();
    SparkplugTopic actualSparkplugTopicNode = sparkplugNodeSessionHandler.getSparkplugTopicNode();

    // Assert
    assertTrue(actualNodeBirthMetrics.isEmpty());
    assertSame(sparkplugTopicNode, actualSparkplugTopicNode);
  }
}
