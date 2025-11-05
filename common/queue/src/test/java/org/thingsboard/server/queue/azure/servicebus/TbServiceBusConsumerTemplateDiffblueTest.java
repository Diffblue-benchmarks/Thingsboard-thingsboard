package org.thingsboard.server.queue.azure.servicebus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.InvalidProtocolBufferException;
import com.microsoft.azure.servicebus.primitives.MessageWithDeliveryTag;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.apache.qpid.proton.amqp.Binary;
import org.apache.qpid.proton.amqp.messaging.ApplicationProperties;
import org.apache.qpid.proton.amqp.messaging.Data;
import org.apache.qpid.proton.amqp.messaging.DeliveryAnnotations;
import org.apache.qpid.proton.amqp.messaging.Footer;
import org.apache.qpid.proton.amqp.messaging.Header;
import org.apache.qpid.proton.amqp.messaging.MessageAnnotations;
import org.apache.qpid.proton.amqp.messaging.Properties;
import org.apache.qpid.proton.message.impl.MessageImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;

class TbServiceBusConsumerTemplateDiffblueTest {
  /**
   * Test {@link TbServiceBusConsumerTemplate#TbServiceBusConsumerTemplate(TbQueueAdmin,
   * TbServiceBusSettings, String, TbQueueMsgDecoder)}.
   *
   * <p>Method under test: {@link
   * TbServiceBusConsumerTemplate#TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings,
   * String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName(
      "Test new TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbServiceBusConsumerTemplate.<init>(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)"
  })
  void testNewTbServiceBusConsumerTemplate() {
    // Arrange and Act
    TbServiceBusConsumerTemplate<TbQueueMsg> actualTbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(
            null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Assert
    assertEquals("Topic", actualTbServiceBusConsumerTemplate.getTopic());
    assertFalse(actualTbServiceBusConsumerTemplate.isStopped());
    assertTrue(actualTbServiceBusConsumerTemplate.getFullTopicNames().isEmpty());
  }

  /**
   * Test {@link TbServiceBusConsumerTemplate#decode(MessageWithDeliveryTag)} with {@code
   * MessageWithDeliveryTag}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusConsumerTemplate#decode(MessageWithDeliveryTag)}
   */
  @Test
  @DisplayName(
      "Test decode(MessageWithDeliveryTag) with 'MessageWithDeliveryTag'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueMsg TbServiceBusConsumerTemplate.decode(MessageWithDeliveryTag)"})
  void testDecodeWithMessageWithDeliveryTag_thenReturnNull()
      throws InvalidProtocolBufferException, UnsupportedEncodingException {
    // Arrange
    TbQueueMsgDecoder<TbQueueMsg> decoder = mock(TbQueueMsgDecoder.class);
    when(decoder.decode(Mockito.<TbQueueMsg>any())).thenReturn(null);
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", decoder);
    Header header = new Header();
    DeliveryAnnotations deliveryAnnotations = new DeliveryAnnotations(new HashMap<>());
    MessageAnnotations messageAnnotations = new MessageAnnotations(new HashMap<>());
    Properties properties = new Properties();
    ApplicationProperties applicationProperties = new ApplicationProperties(new HashMap<>());
    Binary value = new Binary(new byte[] {});
    Data body = new Data(value);

    MessageImpl message =
        new MessageImpl(
            header,
            deliveryAnnotations,
            messageAnnotations,
            properties,
            applicationProperties,
            body,
            new Footer(new HashMap<>()));
    MessageWithDeliveryTag data = new MessageWithDeliveryTag(message, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    TbQueueMsg actualDecodeResult = tbServiceBusConsumerTemplate.decode(data);

    // Assert
    verify(decoder).decode(isNull());
    assertNull(actualDecodeResult);
  }

  /**
   * Test {@link TbServiceBusConsumerTemplate#decode(MessageWithDeliveryTag)} with {@code
   * MessageWithDeliveryTag}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbServiceBusConsumerTemplate#decode(MessageWithDeliveryTag)}
   */
  @Test
  @DisplayName(
      "Test decode(MessageWithDeliveryTag) with 'MessageWithDeliveryTag'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueMsg TbServiceBusConsumerTemplate.decode(MessageWithDeliveryTag)"})
  void testDecodeWithMessageWithDeliveryTag_thenThrowRuntimeException()
      throws InvalidProtocolBufferException, UnsupportedEncodingException {
    // Arrange
    TbQueueMsgDecoder<TbQueueMsg> decoder = mock(TbQueueMsgDecoder.class);
    when(decoder.decode(Mockito.<TbQueueMsg>any())).thenThrow(new RuntimeException());
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", decoder);
    Header header = new Header();
    DeliveryAnnotations deliveryAnnotations = new DeliveryAnnotations(new HashMap<>());
    MessageAnnotations messageAnnotations = new MessageAnnotations(new HashMap<>());
    Properties properties = new Properties();
    ApplicationProperties applicationProperties = new ApplicationProperties(new HashMap<>());
    Binary value = new Binary(new byte[] {});
    Data body = new Data(value);

    MessageImpl message =
        new MessageImpl(
            header,
            deliveryAnnotations,
            messageAnnotations,
            properties,
            applicationProperties,
            body,
            new Footer(new HashMap<>()));
    MessageWithDeliveryTag data = new MessageWithDeliveryTag(message, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbServiceBusConsumerTemplate.decode(data));
    verify(decoder).decode(isNull());
  }
}
