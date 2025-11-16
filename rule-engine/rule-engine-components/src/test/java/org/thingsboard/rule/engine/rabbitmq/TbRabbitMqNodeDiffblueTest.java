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
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

@ExtendWith(MockitoExtension.class)
class TbRabbitMqNodeDiffblueTest {
  @Mock private Channel channel;

  @Mock private Connection connection;

  @InjectMocks private TbRabbitMqNode tbRabbitMqNode;

  @Mock private TbRabbitMqNodeConfiguration tbRabbitMqNodeConfiguration;

  /**
   * Test {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() throws IOException {
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

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbRabbitMqNode.onMsg(ctx, msg);

    // Assert
    verify(channel).basicPublish(eq(""), eq("Routing Key Pattern"), isNull(), isA(byte[].class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbRabbitMqNodeConfiguration).getExchangeNamePattern();
    verify(tbRabbitMqNodeConfiguration).getMessageProperties();
    verify(tbRabbitMqNodeConfiguration, atLeast(1)).getRoutingKeyPattern();
    verify(msg, atLeast(1)).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link Channel} {@link Channel#basicPublish(String, String, BasicProperties,
   *       byte[])} does nothing.
   *   <li>Then calls {@link Channel#basicPublish(String, String, BasicProperties, byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given Channel basicPublish(String, String, BasicProperties, byte[]) does nothing; then calls basicPublish(String, String, BasicProperties, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenChannelBasicPublishDoesNothing_thenCallsBasicPublish() throws IOException {
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

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

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
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
  }

  /**
   * Test {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code 42} is empty string.
   *   <li>Then calls {@link Channel#basicPublish(String, String, BasicProperties, byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData() Value '42' is empty string; then calls basicPublish(String, String, BasicProperties, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataValue42IsEmptyString_thenCallsBasicPublish() throws IOException {
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

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("42", "");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

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
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
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

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbRabbitMqNode.onMsg(ctx, msg);

    // Assert
    verify(channel).basicPublish(eq("Exchange Name Pattern"), eq(""), isNull(), isA(byte[].class));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(tbRabbitMqNodeConfiguration, atLeast(1)).getExchangeNamePattern();
    verify(tbRabbitMqNodeConfiguration).getMessageProperties();
    verify(tbRabbitMqNodeConfiguration).getRoutingKeyPattern();
    verify(msg, atLeast(1)).getData();
    verify(msg).getMetaData();
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
