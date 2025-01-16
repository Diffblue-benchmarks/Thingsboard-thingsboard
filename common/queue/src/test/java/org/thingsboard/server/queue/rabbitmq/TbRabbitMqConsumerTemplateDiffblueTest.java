package org.thingsboard.server.queue.rabbitmq;

import static org.mockito.Mockito.mock;
import com.google.protobuf.InvalidProtocolBufferException;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;

@ContextConfiguration(classes = {TbRabbitMqConsumerTemplate.class, TbRabbitMqSettings.class, String.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbRabbitMqConsumerTemplateDiffblueTest {
  @MockBean
  private TbQueueAdmin tbQueueAdmin;

  @MockBean
  private TbQueueMsgDecoder<TbQueueMsg> tbQueueMsgDecoder;

  @Autowired
  private TbRabbitMqConsumerTemplate<TbQueueMsg> tbRabbitMqConsumerTemplate;

  @Autowired
  private TbRabbitMqSettings tbRabbitMqSettings;

  /**
   * Test
   * {@link TbRabbitMqConsumerTemplate#TbRabbitMqConsumerTemplate(TbQueueAdmin, TbRabbitMqSettings, String, TbQueueMsgDecoder)}.
   * <p>
   * Method under test:
   * {@link TbRabbitMqConsumerTemplate#TbRabbitMqConsumerTemplate(TbQueueAdmin, TbRabbitMqSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbRabbitMqConsumerTemplate(TbQueueAdmin, TbRabbitMqSettings, String, TbQueueMsgDecoder)")
  @Disabled("TODO: Complete this test")
  void testNewTbRabbitMqConsumerTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@28c114e5 testClass = org.thingsboard.server.queue.rabbitmq.DiffblueFakeClass1, locations = [], classes = [org.thingsboard.server.queue.rabbitmq.TbRabbitMqConsumerTemplate, org.thingsboard.server.queue.rabbitmq.TbRabbitMqSettings, java.lang.String], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@7f06ca38, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71b9f6a4, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@9c855ab, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@6c40da4], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange and Act
    new TbRabbitMqConsumerTemplate<>(tbQueueAdmin, tbRabbitMqSettings, "Topic", mock(TbQueueMsgDecoder.class));

  }

  /**
   * Test {@link TbRabbitMqConsumerTemplate#doPoll(long)}.
   * <p>
   * Method under test: {@link TbRabbitMqConsumerTemplate#doPoll(long)}
   */
  @Test
  @DisplayName("Test doPoll(long)")
  @Disabled("TODO: Complete this test")
  void testDoPoll() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: sasKeyName cannot be empty
    //       at com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider.<init>(SharedAccessSignatureTokenProvider.java:40)
    //       at com.microsoft.azure.servicebus.primitives.Util.getClientSettingsFromConnectionStringBuilder(Util.java:382)
    //       at com.microsoft.azure.servicebus.management.ManagementClient.<init>(ManagementClient.java:31)
    //       at org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin.<init>(TbServiceBusAdmin.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbRabbitMqConsumerTemplate<TbQueueMsg> tbRabbitMqConsumerTemplate = new TbRabbitMqConsumerTemplate<>(admin,
        new TbRabbitMqSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbRabbitMqConsumerTemplate.doPoll(1L);
  }

  /**
   * Test {@link TbRabbitMqConsumerTemplate#doQueuePoll(String)}.
   * <p>
   * Method under test: {@link TbRabbitMqConsumerTemplate#doQueuePoll(String)}
   */
  @Test
  @DisplayName("Test doQueuePoll(String)")
  @Disabled("TODO: Complete this test")
  void testDoQueuePoll() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: sasKeyName cannot be empty
    //       at com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider.<init>(SharedAccessSignatureTokenProvider.java:40)
    //       at com.microsoft.azure.servicebus.primitives.Util.getClientSettingsFromConnectionStringBuilder(Util.java:382)
    //       at com.microsoft.azure.servicebus.management.ManagementClient.<init>(ManagementClient.java:31)
    //       at org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin.<init>(TbServiceBusAdmin.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbRabbitMqConsumerTemplate<TbQueueMsg> tbRabbitMqConsumerTemplate = new TbRabbitMqConsumerTemplate<>(admin,
        new TbRabbitMqSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbRabbitMqConsumerTemplate.doQueuePoll("Queue");
  }

  /**
   * Test {@link TbRabbitMqConsumerTemplate#doCommit()}.
   * <p>
   * Method under test: {@link TbRabbitMqConsumerTemplate#doCommit()}
   */
  @Test
  @DisplayName("Test doCommit()")
  @Disabled("TODO: Complete this test")
  void testDoCommit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: sasKeyName cannot be empty
    //       at com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider.<init>(SharedAccessSignatureTokenProvider.java:40)
    //       at com.microsoft.azure.servicebus.primitives.Util.getClientSettingsFromConnectionStringBuilder(Util.java:382)
    //       at com.microsoft.azure.servicebus.management.ManagementClient.<init>(ManagementClient.java:31)
    //       at org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin.<init>(TbServiceBusAdmin.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbRabbitMqConsumerTemplate<TbQueueMsg> tbRabbitMqConsumerTemplate = new TbRabbitMqConsumerTemplate<>(admin,
        new TbRabbitMqSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbRabbitMqConsumerTemplate.doCommit();
  }

  /**
   * Test {@link TbRabbitMqConsumerTemplate#doUnsubscribe()}.
   * <p>
   * Method under test: {@link TbRabbitMqConsumerTemplate#doUnsubscribe()}
   */
  @Test
  @DisplayName("Test doUnsubscribe()")
  @Disabled("TODO: Complete this test")
  void testDoUnsubscribe() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: sasKeyName cannot be empty
    //       at com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider.<init>(SharedAccessSignatureTokenProvider.java:40)
    //       at com.microsoft.azure.servicebus.primitives.Util.getClientSettingsFromConnectionStringBuilder(Util.java:382)
    //       at com.microsoft.azure.servicebus.management.ManagementClient.<init>(ManagementClient.java:31)
    //       at org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin.<init>(TbServiceBusAdmin.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbRabbitMqConsumerTemplate<TbQueueMsg> tbRabbitMqConsumerTemplate = new TbRabbitMqConsumerTemplate<>(admin,
        new TbRabbitMqSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbRabbitMqConsumerTemplate.doUnsubscribe();
  }

  /**
   * Test {@link TbRabbitMqConsumerTemplate#decode(GetResponse)} with
   * {@code GetResponse}.
   * <p>
   * Method under test: {@link TbRabbitMqConsumerTemplate#decode(GetResponse)}
   */
  @Test
  @DisplayName("Test decode(GetResponse) with 'GetResponse'")
  @Disabled("TODO: Complete this test")
  void testDecodeWithGetResponse() throws InvalidProtocolBufferException, UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: sasKeyName cannot be empty
    //       at com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider.<init>(SharedAccessSignatureTokenProvider.java:40)
    //       at com.microsoft.azure.servicebus.primitives.Util.getClientSettingsFromConnectionStringBuilder(Util.java:382)
    //       at com.microsoft.azure.servicebus.management.ManagementClient.<init>(ManagementClient.java:31)
    //       at org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin.<init>(TbServiceBusAdmin.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbRabbitMqConsumerTemplate<TbQueueMsg> tbRabbitMqConsumerTemplate = new TbRabbitMqConsumerTemplate<>(admin,
        new TbRabbitMqSettings(), "Topic", mock(TbQueueMsgDecoder.class));
    Envelope envelope = new Envelope(1L, true, "Exchange", "Routing Key");

    AMQP.BasicProperties.Builder expirationResult = (new AMQP.BasicProperties.Builder()).appId("42")
        .clusterId("42")
        .contentEncoding("UTF-8")
        .contentType("text/plain")
        .correlationId("42")
        .deliveryMode(1)
        .expiration("Expiration");
    AMQP.BasicProperties.Builder replyToResult = expirationResult.headers(new HashMap<>())
        .messageId("42")
        .priority(1)
        .replyTo("alice.liddell@example.org");
    AMQP.BasicProperties props = replyToResult
        .timestamp(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
        .type("Type")
        .userId("42")
        .build();

    // Act
    tbRabbitMqConsumerTemplate.decode(new GetResponse(envelope, props, "AXAXAXAX".getBytes("UTF-8"), 3));
  }
}
