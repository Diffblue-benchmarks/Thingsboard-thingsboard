package org.thingsboard.rule.engine.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbRabbitMqNodeDiffblueTest {
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
