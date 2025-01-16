package org.thingsboard.server.transport.mqtt.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.transport.session.SessionContext;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttDeviceAwareSessionContext;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

@ContextConfiguration(classes = {JsonMqttAdaptor.class})
@ExtendWith(SpringExtension.class)
class MqttTransportAdaptorDiffblueTest {
  @Autowired
  private MqttTransportAdaptor mqttTransportAdaptor;

  /**
   * Test
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}.
   * <p>
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])")
  void testCreateMqttPublishMsg() throws UnsupportedEncodingException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
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
   * Test
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}.
   * <ul>
   *   <li>Given {@code AT_MOST_ONCE}.</li>
   *   <li>Then calls {@link SessionContext#nextMsgId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); given 'AT_MOST_ONCE'; then calls nextMsgId()")
  void testCreateMqttPublishMsg_givenAtMostOnce_thenCallsNextMsgId() throws UnsupportedEncodingException {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

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
   * Test
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return zero.</li>
   *   <li>Then calls {@link MqttTopicMatcher#matches(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); given Function apply(Object) return zero; then calls matches(String)")
  void testCreateMqttPublishMsg_givenFunctionApplyReturnZero_thenCallsMatches() throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(0);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic"));
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
   * Test
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}.
   * <ul>
   *   <li>Given {@link MqttTopicMatcher} {@link MqttTopicMatcher#matches(String)}
   * return {@code true}.</li>
   *   <li>Then calls {@link MqttTopicMatcher#matches(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); given MqttTopicMatcher matches(String) return 'true'; then calls matches(String)")
  void testCreateMqttPublishMsg_givenMqttTopicMatcherMatchesReturnTrue_thenCallsMatches()
      throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic"));
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
   * Test
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}.
   * <ul>
   *   <li>Given {@link MqttTopicMatcher#MqttTopicMatcher(String)} with
   * {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); given MqttTopicMatcher(String) with 'Topic'")
  void testCreateMqttPublishMsg_givenMqttTopicMatcherWithTopic() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

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
   * Test
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}.
   * <ul>
   *   <li>Given {@link MqttTopicMatcher#MqttTopicMatcher(String)} with topic is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); given MqttTopicMatcher(String) with topic is '42'")
  void testCreateMqttPublishMsg_givenMqttTopicMatcherWithTopicIs42() throws UnsupportedEncodingException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("42"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
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
   * Test
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}.
   * <ul>
   *   <li>Given {@link MqttTopicMatcher#MqttTopicMatcher(String)} with topic is
   * {@code #}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); given MqttTopicMatcher(String) with topic is '#'")
  void testCreateMqttPublishMsg_givenMqttTopicMatcherWithTopicIsNumberSign() throws UnsupportedEncodingException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
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
   * Test
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}.
   * <ul>
   *   <li>Then return variableHeader topicName is {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); then return variableHeader topicName is 'Topic'")
  void testCreateMqttPublishMsg_thenReturnVariableHeaderTopicNameIsTopic() throws UnsupportedEncodingException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

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
}
