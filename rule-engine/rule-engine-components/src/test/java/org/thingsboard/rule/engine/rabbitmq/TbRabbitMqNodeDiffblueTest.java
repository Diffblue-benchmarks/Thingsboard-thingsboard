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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;

class TbRabbitMqNodeDiffblueTest {
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
    when(ctx.isExternalNodeForceAck()).thenThrow(new RuntimeException());
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbRabbitMqNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TestDbCallbackExecutor#executeAsync(Callable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls executeAsync(Callable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsExecuteAsync() {
    // Arrange
    TbRabbitMqNode tbRabbitMqNode = new TbRabbitMqNode();

    TestDbCallbackExecutor testDbCallbackExecutor = mock(TestDbCallbackExecutor.class);
    SettableFuture<Object> delegate = SettableFuture.create();
    ForwardingApiFuture<Object> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(testDbCallbackExecutor.executeAsync(Mockito.<Callable<Object>>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenReturn(testDbCallbackExecutor);

    // Act
    tbRabbitMqNode.onMsg(ctx, null);

    // Assert
    verify(testDbCallbackExecutor).executeAsync(isA(Callable.class));
    verify(ctx).getExternalCallExecutor();
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
