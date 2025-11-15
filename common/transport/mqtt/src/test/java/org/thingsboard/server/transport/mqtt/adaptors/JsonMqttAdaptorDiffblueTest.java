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
package org.thingsboard.server.transport.mqtt.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.transport.session.SessionContext;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttDeviceAwareSessionContext;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

@ContextConfiguration(classes = {JsonMqttAdaptor.class})
@ExtendWith(SpringExtension.class)
class JsonMqttAdaptorDiffblueTest {
  @Autowired
  private JsonMqttAdaptor jsonMqttAdaptor;

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code requestId}, {@code chunk}, {@code firmwareType}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  @DisplayName("Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"})
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType() throws UnsupportedEncodingException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code requestId}, {@code chunk}, {@code firmwareType}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  @DisplayName("Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"})
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType2() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code requestId}, {@code chunk}, {@code firmwareType}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  @DisplayName("Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"})
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType3() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code requestId}, {@code chunk}, {@code firmwareType}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  @DisplayName("Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"})
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType4() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("#"), 1);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code requestId}, {@code chunk}, {@code firmwareType}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  @DisplayName("Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"})
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType5() throws UnsupportedEncodingException {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v2/fw/response/42/chunk/1"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

    // Assert
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

    // Assert
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson3() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("#"), 1);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

    // Assert
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_givenA() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = new JsonArray(3);
    json.add('A');

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_givenFalse() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = new JsonArray(3);
    json.add(false);
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>Given null.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; given null")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_givenNull() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = new JsonArray(3);
    json.add('\u0000');
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; given 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_givenTrue() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = new JsonArray(3);
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>Given valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; given valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_givenValueOfOne() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = new JsonArray(3);
    json.add(Integer.valueOf(1));

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_givenZero() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 0);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

    // Assert
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_thenThrowIllegalStateException() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("foo"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", new JsonArray(3)));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; when JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_whenJsonArrayWithCapacityIsThree() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>When {@link JsonElement}.</li>
   *   <li>Then calls {@link SessionContext#nextMsgId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; when JsonElement; then calls nextMsgId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_whenJsonElement_thenCallsNextMsgId() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        mock(JsonElement.class));

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then calls {@link SessionContext#nextMsgId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; when JsonNull (default constructor); then calls nextMsgId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_whenJsonNull_thenCallsNextMsgId() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonNull());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then calls {@link SessionContext#nextMsgId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; when JsonObject (default constructor); then calls nextMsgId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"})
  void testCreateMqttPublishMsgWithCtxTopicJson_whenJsonObject_thenCallsNextMsgId() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonObject());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/disconnect"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish3() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/disconnect"));
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <ul>
   *   <li>Given {@link MqttTopicMatcher#MqttTopicMatcher(String)} with {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); given MqttTopicMatcher(String) with 'Topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish_givenMqttTopicMatcherWithTopic() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/disconnect"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish_givenZero() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/disconnect"), 0);
    UUID sessionId = UUID.randomUUID();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish_thenThrowIllegalStateException() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("v1/gateway/disconnect"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/disconnect"));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then calls {@link SessionContext#nextMsgId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when empty string; then calls nextMsgId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish_whenEmptyString_thenCallsNextMsgId() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(ctx, "", 1);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/disconnect"));
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish_whenNull() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), null, 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }
}
