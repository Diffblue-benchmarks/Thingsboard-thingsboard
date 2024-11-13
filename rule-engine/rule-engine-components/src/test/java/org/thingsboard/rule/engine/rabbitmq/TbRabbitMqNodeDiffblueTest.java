package org.thingsboard.rule.engine.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.rabbitmq.client.AMQP;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;

class TbRabbitMqNodeDiffblueTest {
  /**
   * Test {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then calls {@link TestDbCallbackExecutor#executeAsync(Callable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls executeAsync(Callable)")
  void testOnMsg_thenCallsExecuteAsync() {
    // Arrange
    TbRabbitMqNode tbRabbitMqNode = new TbRabbitMqNode();
    TestDbCallbackExecutor testDbCallbackExecutor = mock(TestDbCallbackExecutor.class);
    SettableFuture<Object> delegate = SettableFuture.create();
    when(testDbCallbackExecutor.executeAsync(Mockito.<Callable<Object>>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenReturn(testDbCallbackExecutor);

    // Act
    tbRabbitMqNode.onMsg(ctx, null);

    // Assert
    verify(testDbCallbackExecutor).executeAsync(isA(Callable.class));
    verify(ctx).getExternalCallExecutor();
  }

  /**
   * Test {@link TbRabbitMqNode#destroy()}.
   * <ul>
   *   <li>Then calls {@link TbContext#isExternalNodeForceAck()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); then calls isExternalNodeForceAck()")
  void testDestroy_thenCallsIsExternalNodeForceAck() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbRabbitMqNode tbRabbitMqNode = new TbRabbitMqNode();
    tbRabbitMqNode.init(ctx);

    // Act
    tbRabbitMqNode.destroy();

    // Assert that nothing has changed
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbRabbitMqNode#convert(String)}.
   * <ul>
   *   <li>When {@code BASIC}.</li>
   *   <li>Then return ContentType is {@code application/octet-stream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName("Test convert(String); when 'BASIC'; then return ContentType is 'application/octet-stream'")
  void testConvert_whenBasic_thenReturnContentTypeIsApplicationOctetStream() throws TbNodeException {
    // Arrange and Act
    AMQP.BasicProperties actualConvertResult = TbRabbitMqNode.convert("BASIC");

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
   * <ul>
   *   <li>When {@code MINIMAL_BASIC}.</li>
   *   <li>Then return DeliveryMode is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName("Test convert(String); when 'MINIMAL_BASIC'; then return DeliveryMode is 'null'")
  void testConvert_whenMinimalBasic_thenReturnDeliveryModeIsNull() throws TbNodeException {
    // Arrange and Act
    AMQP.BasicProperties actualConvertResult = TbRabbitMqNode.convert("MINIMAL_BASIC");

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
   * <ul>
   *   <li>When {@code MINIMAL_PERSISTENT_BASIC}.</li>
   *   <li>Then return Priority is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName("Test convert(String); when 'MINIMAL_PERSISTENT_BASIC'; then return Priority is 'null'")
  void testConvert_whenMinimalPersistentBasic_thenReturnPriorityIsNull() throws TbNodeException {
    // Arrange and Act
    AMQP.BasicProperties actualConvertResult = TbRabbitMqNode.convert("MINIMAL_PERSISTENT_BASIC");

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
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName("Test convert(String); when 'Name'; then throw TbNodeException")
  void testConvert_whenName_thenThrowTbNodeException() throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(TbNodeException.class, () -> TbRabbitMqNode.convert("Name"));
  }

  /**
   * Test {@link TbRabbitMqNode#convert(String)}.
   * <ul>
   *   <li>When {@code PERSISTENT_BASIC}.</li>
   *   <li>Then return ContentType is {@code application/octet-stream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName("Test convert(String); when 'PERSISTENT_BASIC'; then return ContentType is 'application/octet-stream'")
  void testConvert_whenPersistentBasic_thenReturnContentTypeIsApplicationOctetStream() throws TbNodeException {
    // Arrange and Act
    AMQP.BasicProperties actualConvertResult = TbRabbitMqNode.convert("PERSISTENT_BASIC");

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
   * <ul>
   *   <li>When {@code PERSISTENT_TEXT_PLAIN}.</li>
   *   <li>Then return ContentType is {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName("Test convert(String); when 'PERSISTENT_TEXT_PLAIN'; then return ContentType is 'text/plain'")
  void testConvert_whenPersistentTextPlain_thenReturnContentTypeIsTextPlain() throws TbNodeException {
    // Arrange and Act
    AMQP.BasicProperties actualConvertResult = TbRabbitMqNode.convert("PERSISTENT_TEXT_PLAIN");

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
   * <ul>
   *   <li>When {@code TEXT_PLAIN}.</li>
   *   <li>Then return ContentType is {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqNode#convert(String)}
   */
  @Test
  @DisplayName("Test convert(String); when 'TEXT_PLAIN'; then return ContentType is 'text/plain'")
  void testConvert_whenTextPlain_thenReturnContentTypeIsTextPlain() throws TbNodeException {
    // Arrange and Act
    AMQP.BasicProperties actualConvertResult = TbRabbitMqNode.convert("TEXT_PLAIN");

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
