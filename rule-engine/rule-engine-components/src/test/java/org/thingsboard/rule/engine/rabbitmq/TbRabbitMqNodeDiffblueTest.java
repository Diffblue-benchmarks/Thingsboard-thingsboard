package org.thingsboard.rule.engine.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultSaslConfig;
import com.rabbitmq.client.impl.DefaultExceptionHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbRabbitMqNodeDiffblueTest {
  @Mock private Channel channel;

  @Mock private Connection connection;

  @InjectMocks private TbRabbitMqNode tbRabbitMqNode;

  @Mock private TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration;

  /**
   * Test {@link TbRabbitMqNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbRabbitMqNode tbRabbitMqNode = new TbRabbitMqNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbRabbitMqNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).asToken();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbRabbitMqNodeConfiguration} {@link
   *       TbRabbitMqNodeConfiguration#getExchangeNamePattern()} return {@code $[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbRabbitMqNodeConfiguration getExchangeNamePattern() return '$[UU]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbRabbitMqNodeConfigurationGetExchangeNamePatternReturnUu()
      throws IOException {
    // Arrange
    doNothing()
        .when(channel)
        .basicPublish(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<BasicProperties>any(),
            Mockito.<byte[]>any());
    when(tbRabbitMqNodeConfiguration.getExchangeNamePattern()).thenReturn("$[UU]");
    when(tbRabbitMqNodeConfiguration.getMessageProperties()).thenReturn("");
    when(tbRabbitMqNodeConfiguration.getRoutingKeyPattern()).thenReturn("Routing Key Pattern");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRabbitMqNode.onMsg(ctx, msg);

    // Assert
    verify(channel)
        .basicPublish(eq("$[UU]"), eq("Routing Key Pattern"), isNull(), isA(byte[].class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbRabbitMqNodeConfiguration, atLeast(1)).getExchangeNamePattern();
    verify(tbRabbitMqNodeConfiguration).getMessageProperties();
    verify(tbRabbitMqNodeConfiguration, atLeast(1)).getRoutingKeyPattern();
  }

  /**
   * Test {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbRabbitMqNodeConfiguration} {@link
   *       TbRabbitMqNodeConfiguration#getRoutingKeyPattern()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbRabbitMqNodeConfiguration getRoutingKeyPattern() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbRabbitMqNodeConfigurationGetRoutingKeyPatternReturnEmptyString()
      throws IOException {
    // Arrange
    doNothing()
        .when(channel)
        .basicPublish(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<BasicProperties>any(),
            Mockito.<byte[]>any());
    when(tbRabbitMqNodeConfiguration.getExchangeNamePattern()).thenReturn("Exchange Name Pattern");
    when(tbRabbitMqNodeConfiguration.getMessageProperties()).thenReturn("");
    when(tbRabbitMqNodeConfiguration.getRoutingKeyPattern()).thenReturn("");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRabbitMqNode.onMsg(ctx, msg);

    // Assert
    verify(channel).basicPublish(eq("Exchange Name Pattern"), eq(""), isNull(), isA(byte[].class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbRabbitMqNodeConfiguration, atLeast(1)).getExchangeNamePattern();
    verify(tbRabbitMqNodeConfiguration).getMessageProperties();
    verify(tbRabbitMqNodeConfiguration).getRoutingKeyPattern();
  }

  /**
   * Test {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link Channel#basicPublish(String, String, BasicProperties, byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); then calls basicPublish(String, String, BasicProperties, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsBasicPublish() throws IOException {
    // Arrange
    doNothing()
        .when(channel)
        .basicPublish(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<BasicProperties>any(),
            Mockito.<byte[]>any());
    when(tbRabbitMqNodeConfiguration.getExchangeNamePattern()).thenReturn("Exchange Name Pattern");
    when(tbRabbitMqNodeConfiguration.getMessageProperties()).thenReturn("");
    when(tbRabbitMqNodeConfiguration.getRoutingKeyPattern()).thenReturn("Routing Key Pattern");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRabbitMqNode.onMsg(ctx, msg);

    // Assert
    verify(channel)
        .basicPublish(
            eq("Exchange Name Pattern"), eq("Routing Key Pattern"), isNull(), isA(byte[].class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbRabbitMqNodeConfiguration, atLeast(1)).getExchangeNamePattern();
    verify(tbRabbitMqNodeConfiguration).getMessageProperties();
    verify(tbRabbitMqNodeConfiguration, atLeast(1)).getRoutingKeyPattern();
  }

  /**
   * Test {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link Channel#basicPublish(String, String, BasicProperties, byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); then calls basicPublish(String, String, BasicProperties, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsBasicPublish2() throws IOException {
    // Arrange
    doNothing()
        .when(channel)
        .basicPublish(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<BasicProperties>any(),
            Mockito.<byte[]>any());
    when(tbRabbitMqNodeConfiguration.getExchangeNamePattern()).thenReturn("");
    when(tbRabbitMqNodeConfiguration.getMessageProperties()).thenReturn("");
    when(tbRabbitMqNodeConfiguration.getRoutingKeyPattern()).thenReturn("Routing Key Pattern");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRabbitMqNode.onMsg(ctx, msg);

    // Assert
    verify(channel).basicPublish(eq(""), eq("Routing Key Pattern"), isNull(), isA(byte[].class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbRabbitMqNodeConfiguration).getExchangeNamePattern();
    verify(tbRabbitMqNodeConfiguration).getMessageProperties();
    verify(tbRabbitMqNodeConfiguration, atLeast(1)).getRoutingKeyPattern();
  }

  /**
   * Test {@link TbRabbitMqNode#getConnectionFactory()}.
   *
   * <ul>
   *   <li>Then return ClientProperties size is eight.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#getConnectionFactory()}
   */
  @Test
  @DisplayName("Test getConnectionFactory(); then return ClientProperties size is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConnectionFactory TbRabbitMqNode.getConnectionFactory()"})
  void testGetConnectionFactory_thenReturnClientPropertiesSizeIsEight() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("42", "Value");
    stringStringMap.put("Key", "42");
    when(tbRabbitMqNodeConfiguration.isAutomaticRecoveryEnabled()).thenReturn(true);
    when(tbRabbitMqNodeConfiguration.getConnectionTimeout()).thenReturn(10);
    when(tbRabbitMqNodeConfiguration.getHandshakeTimeout()).thenReturn(10);
    when(tbRabbitMqNodeConfiguration.getPort()).thenReturn(8080);
    when(tbRabbitMqNodeConfiguration.getHost()).thenReturn("localhost");
    when(tbRabbitMqNodeConfiguration.getPassword()).thenReturn("iloveyou");
    when(tbRabbitMqNodeConfiguration.getUsername()).thenReturn("janedoe");
    when(tbRabbitMqNodeConfiguration.getVirtualHost()).thenReturn("localhost");
    when(tbRabbitMqNodeConfiguration.getClientProperties()).thenReturn(stringStringMap);

    // Act
    ConnectionFactory actualConnectionFactory = tbRabbitMqNode.getConnectionFactory();

    // Assert
    verify(tbRabbitMqNodeConfiguration).getClientProperties();
    verify(tbRabbitMqNodeConfiguration).getConnectionTimeout();
    verify(tbRabbitMqNodeConfiguration).getHandshakeTimeout();
    verify(tbRabbitMqNodeConfiguration).getHost();
    verify(tbRabbitMqNodeConfiguration).getPassword();
    verify(tbRabbitMqNodeConfiguration).getPort();
    verify(tbRabbitMqNodeConfiguration).getUsername();
    verify(tbRabbitMqNodeConfiguration).getVirtualHost();
    verify(tbRabbitMqNodeConfiguration).isAutomaticRecoveryEnabled();
    assertTrue(actualConnectionFactory.getSaslConfig() instanceof DefaultSaslConfig);
    assertTrue(actualConnectionFactory.getExceptionHandler() instanceof DefaultExceptionHandler);
    assertEquals("iloveyou", actualConnectionFactory.getPassword());
    assertEquals("janedoe", actualConnectionFactory.getUsername());
    assertEquals("localhost", actualConnectionFactory.getHost());
    assertEquals("localhost", actualConnectionFactory.getVirtualHost());
    assertNull(actualConnectionFactory.getMetricsCollector());
    assertNull(actualConnectionFactory.getRecoveryDelayHandler());
    assertNull(actualConnectionFactory.getTopologyRecoveryExecutor());
    assertNull(actualConnectionFactory.getSocketFactory());
    assertEquals(-1, actualConnectionFactory.getWorkPoolTimeout());
    assertEquals(0, actualConnectionFactory.getRequestedFrameMax());
    assertEquals(10, actualConnectionFactory.getConnectionTimeout());
    assertEquals(10, actualConnectionFactory.getHandshakeTimeout());
    assertEquals(10000, actualConnectionFactory.getShutdownTimeout());
    assertEquals(2047, actualConnectionFactory.getRequestedChannelMax());
    assertEquals(5000L, actualConnectionFactory.getNetworkRecoveryInterval());
    assertEquals(60, actualConnectionFactory.getRequestedHeartbeat());
    assertEquals(600000, actualConnectionFactory.getChannelRpcTimeout());
    Map<String, Object> clientProperties = actualConnectionFactory.getClientProperties();
    assertEquals(8, clientProperties.size());
    assertEquals(8080, actualConnectionFactory.getPort());
    assertFalse(actualConnectionFactory.isChannelShouldCheckRpcResponseType());
    assertFalse(actualConnectionFactory.isSSL());
    assertTrue(actualConnectionFactory.isAutomaticRecoveryEnabled());
    assertTrue(actualConnectionFactory.isTopologyRecoveryEnabled());
    assertTrue(clientProperties.containsKey("capabilities"));
    assertTrue(clientProperties.containsKey("copyright"));
    assertTrue(clientProperties.containsKey("information"));
    assertTrue(clientProperties.containsKey("platform"));
    assertTrue(clientProperties.containsKey("product"));
    assertTrue(clientProperties.containsKey("version"));
  }

  /**
   * Test {@link TbRabbitMqNode#getConnectionFactory()}.
   *
   * <ul>
   *   <li>Then return ClientProperties size is seven.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#getConnectionFactory()}
   */
  @Test
  @DisplayName("Test getConnectionFactory(); then return ClientProperties size is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConnectionFactory TbRabbitMqNode.getConnectionFactory()"})
  void testGetConnectionFactory_thenReturnClientPropertiesSizeIsSeven() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("Key", "42");
    when(tbRabbitMqNodeConfiguration.isAutomaticRecoveryEnabled()).thenReturn(true);
    when(tbRabbitMqNodeConfiguration.getConnectionTimeout()).thenReturn(10);
    when(tbRabbitMqNodeConfiguration.getHandshakeTimeout()).thenReturn(10);
    when(tbRabbitMqNodeConfiguration.getPort()).thenReturn(8080);
    when(tbRabbitMqNodeConfiguration.getHost()).thenReturn("localhost");
    when(tbRabbitMqNodeConfiguration.getPassword()).thenReturn("iloveyou");
    when(tbRabbitMqNodeConfiguration.getUsername()).thenReturn("janedoe");
    when(tbRabbitMqNodeConfiguration.getVirtualHost()).thenReturn("localhost");
    when(tbRabbitMqNodeConfiguration.getClientProperties()).thenReturn(stringStringMap);

    // Act
    ConnectionFactory actualConnectionFactory = tbRabbitMqNode.getConnectionFactory();

    // Assert
    verify(tbRabbitMqNodeConfiguration).getClientProperties();
    verify(tbRabbitMqNodeConfiguration).getConnectionTimeout();
    verify(tbRabbitMqNodeConfiguration).getHandshakeTimeout();
    verify(tbRabbitMqNodeConfiguration).getHost();
    verify(tbRabbitMqNodeConfiguration).getPassword();
    verify(tbRabbitMqNodeConfiguration).getPort();
    verify(tbRabbitMqNodeConfiguration).getUsername();
    verify(tbRabbitMqNodeConfiguration).getVirtualHost();
    verify(tbRabbitMqNodeConfiguration).isAutomaticRecoveryEnabled();
    assertTrue(actualConnectionFactory.getSaslConfig() instanceof DefaultSaslConfig);
    assertTrue(actualConnectionFactory.getExceptionHandler() instanceof DefaultExceptionHandler);
    assertEquals("iloveyou", actualConnectionFactory.getPassword());
    assertEquals("janedoe", actualConnectionFactory.getUsername());
    assertEquals("localhost", actualConnectionFactory.getHost());
    assertEquals("localhost", actualConnectionFactory.getVirtualHost());
    assertNull(actualConnectionFactory.getMetricsCollector());
    assertNull(actualConnectionFactory.getRecoveryDelayHandler());
    assertNull(actualConnectionFactory.getTopologyRecoveryExecutor());
    assertNull(actualConnectionFactory.getSocketFactory());
    assertEquals(-1, actualConnectionFactory.getWorkPoolTimeout());
    assertEquals(0, actualConnectionFactory.getRequestedFrameMax());
    assertEquals(10, actualConnectionFactory.getConnectionTimeout());
    assertEquals(10, actualConnectionFactory.getHandshakeTimeout());
    assertEquals(10000, actualConnectionFactory.getShutdownTimeout());
    assertEquals(2047, actualConnectionFactory.getRequestedChannelMax());
    assertEquals(5000L, actualConnectionFactory.getNetworkRecoveryInterval());
    assertEquals(60, actualConnectionFactory.getRequestedHeartbeat());
    assertEquals(600000, actualConnectionFactory.getChannelRpcTimeout());
    Map<String, Object> clientProperties = actualConnectionFactory.getClientProperties();
    assertEquals(7, clientProperties.size());
    assertEquals(8080, actualConnectionFactory.getPort());
    assertFalse(actualConnectionFactory.isChannelShouldCheckRpcResponseType());
    assertFalse(actualConnectionFactory.isSSL());
    assertTrue(actualConnectionFactory.isAutomaticRecoveryEnabled());
    assertTrue(actualConnectionFactory.isTopologyRecoveryEnabled());
    assertTrue(clientProperties.containsKey("capabilities"));
    assertTrue(clientProperties.containsKey("copyright"));
    assertTrue(clientProperties.containsKey("information"));
    assertTrue(clientProperties.containsKey("platform"));
    assertTrue(clientProperties.containsKey("product"));
    assertTrue(clientProperties.containsKey("version"));
  }

  /**
   * Test {@link TbRabbitMqNode#getConnectionFactory()}.
   *
   * <ul>
   *   <li>Then return ClientProperties size is six.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#getConnectionFactory()}
   */
  @Test
  @DisplayName("Test getConnectionFactory(); then return ClientProperties size is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConnectionFactory TbRabbitMqNode.getConnectionFactory()"})
  void testGetConnectionFactory_thenReturnClientPropertiesSizeIsSix() {
    // Arrange
    when(tbRabbitMqNodeConfiguration.isAutomaticRecoveryEnabled()).thenReturn(true);
    when(tbRabbitMqNodeConfiguration.getConnectionTimeout()).thenReturn(10);
    when(tbRabbitMqNodeConfiguration.getHandshakeTimeout()).thenReturn(10);
    when(tbRabbitMqNodeConfiguration.getPort()).thenReturn(8080);
    when(tbRabbitMqNodeConfiguration.getHost()).thenReturn("localhost");
    when(tbRabbitMqNodeConfiguration.getPassword()).thenReturn("iloveyou");
    when(tbRabbitMqNodeConfiguration.getUsername()).thenReturn("janedoe");
    when(tbRabbitMqNodeConfiguration.getVirtualHost()).thenReturn("localhost");
    when(tbRabbitMqNodeConfiguration.getClientProperties()).thenReturn(new HashMap<>());

    // Act
    ConnectionFactory actualConnectionFactory = tbRabbitMqNode.getConnectionFactory();

    // Assert
    verify(tbRabbitMqNodeConfiguration).getClientProperties();
    verify(tbRabbitMqNodeConfiguration).getConnectionTimeout();
    verify(tbRabbitMqNodeConfiguration).getHandshakeTimeout();
    verify(tbRabbitMqNodeConfiguration).getHost();
    verify(tbRabbitMqNodeConfiguration).getPassword();
    verify(tbRabbitMqNodeConfiguration).getPort();
    verify(tbRabbitMqNodeConfiguration).getUsername();
    verify(tbRabbitMqNodeConfiguration).getVirtualHost();
    verify(tbRabbitMqNodeConfiguration).isAutomaticRecoveryEnabled();
    assertTrue(actualConnectionFactory.getSaslConfig() instanceof DefaultSaslConfig);
    assertTrue(actualConnectionFactory.getExceptionHandler() instanceof DefaultExceptionHandler);
    assertEquals("iloveyou", actualConnectionFactory.getPassword());
    assertEquals("janedoe", actualConnectionFactory.getUsername());
    assertEquals("localhost", actualConnectionFactory.getHost());
    assertEquals("localhost", actualConnectionFactory.getVirtualHost());
    assertNull(actualConnectionFactory.getMetricsCollector());
    assertNull(actualConnectionFactory.getRecoveryDelayHandler());
    assertNull(actualConnectionFactory.getTopologyRecoveryExecutor());
    assertNull(actualConnectionFactory.getSocketFactory());
    assertEquals(-1, actualConnectionFactory.getWorkPoolTimeout());
    assertEquals(0, actualConnectionFactory.getRequestedFrameMax());
    assertEquals(10, actualConnectionFactory.getConnectionTimeout());
    assertEquals(10, actualConnectionFactory.getHandshakeTimeout());
    assertEquals(10000, actualConnectionFactory.getShutdownTimeout());
    assertEquals(2047, actualConnectionFactory.getRequestedChannelMax());
    assertEquals(5000L, actualConnectionFactory.getNetworkRecoveryInterval());
    Map<String, Object> clientProperties = actualConnectionFactory.getClientProperties();
    assertEquals(6, clientProperties.size());
    assertEquals(60, actualConnectionFactory.getRequestedHeartbeat());
    assertEquals(600000, actualConnectionFactory.getChannelRpcTimeout());
    assertEquals(8080, actualConnectionFactory.getPort());
    assertFalse(actualConnectionFactory.isChannelShouldCheckRpcResponseType());
    assertFalse(actualConnectionFactory.isSSL());
    assertTrue(actualConnectionFactory.isAutomaticRecoveryEnabled());
    assertTrue(actualConnectionFactory.isTopologyRecoveryEnabled());
    assertTrue(clientProperties.containsKey("capabilities"));
    assertTrue(clientProperties.containsKey("copyright"));
    assertTrue(clientProperties.containsKey("information"));
    assertTrue(clientProperties.containsKey("platform"));
    assertTrue(clientProperties.containsKey("product"));
    assertTrue(clientProperties.containsKey("version"));
  }

  /**
   * Test {@link TbRabbitMqNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#close()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given Connection close() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.destroy()"})
  void testDestroy_givenConnectionCloseDoesNothing() throws IOException {
    // Arrange
    doNothing().when(connection).close();

    // Act
    tbRabbitMqNode.destroy();

    // Assert
    verify(connection).close();
  }

  /**
   * Test {@link TbRabbitMqNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#close()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given Connection close() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.destroy()"})
  void testDestroy_givenConnectionCloseThrowRuntimeException() throws IOException {
    // Arrange
    doThrow(new RuntimeException()).when(connection).close();

    // Act
    tbRabbitMqNode.destroy();

    // Assert
    verify(connection).close();
  }

  /**
   * Test {@link TbRabbitMqNode#convert(String)}.
   *
   * <ul>
   *   <li>When {@code BASIC}.
   *   <li>Then return ContentType is {@code application/octet-stream}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName(
      "Test convert(String); when 'BASIC'; then return ContentType is 'application/octet-stream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicProperties TbRabbitMqNode.convert(String)"})
  void testConvert_whenBasic_thenReturnContentTypeIsApplicationOctetStream()
      throws TbNodeException {
    // Arrange and Act
    BasicProperties actualConvertResult = TbRabbitMqNode.convert("BASIC");

    // Assert
    assertEquals("application/octet-stream", actualConvertResult.getContentType());
    assertEquals("basic", actualConvertResult.getClassName());
    assertNull(actualConvertResult.getAppId());
    assertNull(actualConvertResult.getClusterId());
    assertNull(actualConvertResult.getContentEncoding());
    assertNull(actualConvertResult.getCorrelationId());
    assertNull(actualConvertResult.getExpiration());
    assertNull(actualConvertResult.getMessageId());
    assertNull(actualConvertResult.getReplyTo());
    assertNull(actualConvertResult.getType());
    assertNull(actualConvertResult.getUserId());
    assertNull(actualConvertResult.getTimestamp());
    assertNull(actualConvertResult.getHeaders());
    assertEquals(0, actualConvertResult.getPriority().intValue());
    assertEquals(0L, actualConvertResult.getBodySize());
    assertEquals(1, actualConvertResult.getDeliveryMode().intValue());
    assertEquals(60, actualConvertResult.getClassId());
  }

  /**
   * Test {@link TbRabbitMqNode#convert(String)}.
   *
   * <ul>
   *   <li>When {@code MINIMAL_BASIC}.
   *   <li>Then return DeliveryMode is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName("Test convert(String); when 'MINIMAL_BASIC'; then return DeliveryMode is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicProperties TbRabbitMqNode.convert(String)"})
  void testConvert_whenMinimalBasic_thenReturnDeliveryModeIsNull() throws TbNodeException {
    // Arrange and Act
    BasicProperties actualConvertResult = TbRabbitMqNode.convert("MINIMAL_BASIC");

    // Assert
    assertEquals("basic", actualConvertResult.getClassName());
    assertNull(actualConvertResult.getDeliveryMode());
    assertNull(actualConvertResult.getPriority());
    assertNull(actualConvertResult.getAppId());
    assertNull(actualConvertResult.getClusterId());
    assertNull(actualConvertResult.getContentEncoding());
    assertNull(actualConvertResult.getContentType());
    assertNull(actualConvertResult.getCorrelationId());
    assertNull(actualConvertResult.getExpiration());
    assertNull(actualConvertResult.getMessageId());
    assertNull(actualConvertResult.getReplyTo());
    assertNull(actualConvertResult.getType());
    assertNull(actualConvertResult.getUserId());
    assertNull(actualConvertResult.getTimestamp());
    assertNull(actualConvertResult.getHeaders());
    assertEquals(0L, actualConvertResult.getBodySize());
    assertEquals(60, actualConvertResult.getClassId());
  }

  /**
   * Test {@link TbRabbitMqNode#convert(String)}.
   *
   * <ul>
   *   <li>When {@code MINIMAL_PERSISTENT_BASIC}.
   *   <li>Then return Priority is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName(
      "Test convert(String); when 'MINIMAL_PERSISTENT_BASIC'; then return Priority is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicProperties TbRabbitMqNode.convert(String)"})
  void testConvert_whenMinimalPersistentBasic_thenReturnPriorityIsNull() throws TbNodeException {
    // Arrange and Act
    BasicProperties actualConvertResult = TbRabbitMqNode.convert("MINIMAL_PERSISTENT_BASIC");

    // Assert
    assertEquals("basic", actualConvertResult.getClassName());
    assertNull(actualConvertResult.getPriority());
    assertNull(actualConvertResult.getAppId());
    assertNull(actualConvertResult.getClusterId());
    assertNull(actualConvertResult.getContentEncoding());
    assertNull(actualConvertResult.getContentType());
    assertNull(actualConvertResult.getCorrelationId());
    assertNull(actualConvertResult.getExpiration());
    assertNull(actualConvertResult.getMessageId());
    assertNull(actualConvertResult.getReplyTo());
    assertNull(actualConvertResult.getType());
    assertNull(actualConvertResult.getUserId());
    assertNull(actualConvertResult.getTimestamp());
    assertNull(actualConvertResult.getHeaders());
    assertEquals(0L, actualConvertResult.getBodySize());
    assertEquals(2, actualConvertResult.getDeliveryMode().intValue());
    assertEquals(60, actualConvertResult.getClassId());
  }

  /**
   * Test {@link TbRabbitMqNode#convert(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName("Test convert(String); when 'Name'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicProperties TbRabbitMqNode.convert(String)"})
  void testConvert_whenName_thenThrowTbNodeException() throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(TbNodeException.class, () -> TbRabbitMqNode.convert("Name"));
  }

  /**
   * Test {@link TbRabbitMqNode#convert(String)}.
   *
   * <ul>
   *   <li>When {@code PERSISTENT_BASIC}.
   *   <li>Then return ContentType is {@code application/octet-stream}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName(
      "Test convert(String); when 'PERSISTENT_BASIC'; then return ContentType is 'application/octet-stream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicProperties TbRabbitMqNode.convert(String)"})
  void testConvert_whenPersistentBasic_thenReturnContentTypeIsApplicationOctetStream()
      throws TbNodeException {
    // Arrange and Act
    BasicProperties actualConvertResult = TbRabbitMqNode.convert("PERSISTENT_BASIC");

    // Assert
    assertEquals("application/octet-stream", actualConvertResult.getContentType());
    assertEquals("basic", actualConvertResult.getClassName());
    assertNull(actualConvertResult.getAppId());
    assertNull(actualConvertResult.getClusterId());
    assertNull(actualConvertResult.getContentEncoding());
    assertNull(actualConvertResult.getCorrelationId());
    assertNull(actualConvertResult.getExpiration());
    assertNull(actualConvertResult.getMessageId());
    assertNull(actualConvertResult.getReplyTo());
    assertNull(actualConvertResult.getType());
    assertNull(actualConvertResult.getUserId());
    assertNull(actualConvertResult.getTimestamp());
    assertNull(actualConvertResult.getHeaders());
    assertEquals(0, actualConvertResult.getPriority().intValue());
    assertEquals(0L, actualConvertResult.getBodySize());
    assertEquals(2, actualConvertResult.getDeliveryMode().intValue());
    assertEquals(60, actualConvertResult.getClassId());
  }

  /**
   * Test {@link TbRabbitMqNode#convert(String)}.
   *
   * <ul>
   *   <li>When {@code PERSISTENT_TEXT_PLAIN}.
   *   <li>Then return ContentType is {@code text/plain}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName(
      "Test convert(String); when 'PERSISTENT_TEXT_PLAIN'; then return ContentType is 'text/plain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicProperties TbRabbitMqNode.convert(String)"})
  void testConvert_whenPersistentTextPlain_thenReturnContentTypeIsTextPlain()
      throws TbNodeException {
    // Arrange and Act
    BasicProperties actualConvertResult = TbRabbitMqNode.convert("PERSISTENT_TEXT_PLAIN");

    // Assert
    assertEquals("basic", actualConvertResult.getClassName());
    assertEquals("text/plain", actualConvertResult.getContentType());
    assertNull(actualConvertResult.getAppId());
    assertNull(actualConvertResult.getClusterId());
    assertNull(actualConvertResult.getContentEncoding());
    assertNull(actualConvertResult.getCorrelationId());
    assertNull(actualConvertResult.getExpiration());
    assertNull(actualConvertResult.getMessageId());
    assertNull(actualConvertResult.getReplyTo());
    assertNull(actualConvertResult.getType());
    assertNull(actualConvertResult.getUserId());
    assertNull(actualConvertResult.getTimestamp());
    assertNull(actualConvertResult.getHeaders());
    assertEquals(0, actualConvertResult.getPriority().intValue());
    assertEquals(0L, actualConvertResult.getBodySize());
    assertEquals(2, actualConvertResult.getDeliveryMode().intValue());
    assertEquals(60, actualConvertResult.getClassId());
  }

  /**
   * Test {@link TbRabbitMqNode#convert(String)}.
   *
   * <ul>
   *   <li>When {@code TEXT_PLAIN}.
   *   <li>Then return ContentType is {@code text/plain}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName("Test convert(String); when 'TEXT_PLAIN'; then return ContentType is 'text/plain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BasicProperties TbRabbitMqNode.convert(String)"})
  void testConvert_whenTextPlain_thenReturnContentTypeIsTextPlain() throws TbNodeException {
    // Arrange and Act
    BasicProperties actualConvertResult = TbRabbitMqNode.convert("TEXT_PLAIN");

    // Assert
    assertEquals("basic", actualConvertResult.getClassName());
    assertEquals("text/plain", actualConvertResult.getContentType());
    assertNull(actualConvertResult.getAppId());
    assertNull(actualConvertResult.getClusterId());
    assertNull(actualConvertResult.getContentEncoding());
    assertNull(actualConvertResult.getCorrelationId());
    assertNull(actualConvertResult.getExpiration());
    assertNull(actualConvertResult.getMessageId());
    assertNull(actualConvertResult.getReplyTo());
    assertNull(actualConvertResult.getType());
    assertNull(actualConvertResult.getUserId());
    assertNull(actualConvertResult.getTimestamp());
    assertNull(actualConvertResult.getHeaders());
    assertEquals(0, actualConvertResult.getPriority().intValue());
    assertEquals(0L, actualConvertResult.getBodySize());
    assertEquals(1, actualConvertResult.getDeliveryMode().intValue());
    assertEquals(60, actualConvertResult.getClassId());
  }
}
