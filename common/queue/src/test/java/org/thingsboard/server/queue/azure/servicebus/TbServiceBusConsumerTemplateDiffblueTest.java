package org.thingsboard.server.queue.azure.servicebus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.google.protobuf.InvalidProtocolBufferException;
import com.microsoft.azure.servicebus.primitives.MessageWithDeliveryTag;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.apache.qpid.proton.message.impl.MessageImpl;
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

@ContextConfiguration(classes = {TbServiceBusConsumerTemplate.class, TbServiceBusSettings.class, String.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbServiceBusConsumerTemplateDiffblueTest {
  @MockBean
  private TbQueueAdmin tbQueueAdmin;

  @MockBean
  private TbQueueMsgDecoder<TbQueueMsg> tbQueueMsgDecoder;

  @Autowired
  private TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate;

  @Autowired
  private TbServiceBusSettings tbServiceBusSettings;

  /**
   * Test
   * {@link TbServiceBusConsumerTemplate#TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)}.
   * <p>
   * Method under test:
   * {@link TbServiceBusConsumerTemplate#TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)")
  @Disabled("TODO: Complete this test")
  void testNewTbServiceBusConsumerTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@4f8a450e testClass = org.thingsboard.server.queue.azure.servicebus.DiffblueFakeClass23, locations = [], classes = [org.thingsboard.server.queue.azure.servicebus.TbServiceBusConsumerTemplate, org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings, java.lang.String], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@72294b52, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@45387cbe, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@6aad4170, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@575bd08a], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    new TbServiceBusConsumerTemplate<>(tbQueueAdmin, tbServiceBusSettings, "Topic", mock(TbQueueMsgDecoder.class));

  }

  /**
   * Test
   * {@link TbServiceBusConsumerTemplate#TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbServiceBusConsumerTemplate#TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder); when 'null'; then return 'Topic'")
  void testNewTbServiceBusConsumerTemplate_whenNull_thenReturnTopic() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TbServiceBusConsumerTemplate<TbQueueMsg> actualTbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(
        null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Assert
    assertEquals("Topic", actualTbServiceBusConsumerTemplate.getTopic());
    assertFalse(actualTbServiceBusConsumerTemplate.isStopped());
    assertTrue(actualTbServiceBusConsumerTemplate.getFullTopicNames().isEmpty());
  }

  /**
   * Test {@link TbServiceBusConsumerTemplate#doPoll(long)}.
   * <p>
   * Method under test: {@link TbServiceBusConsumerTemplate#doPoll(long)}
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

    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(admin,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbServiceBusConsumerTemplate.doPoll(1L);
  }

  /**
   * Test {@link TbServiceBusConsumerTemplate#doCommit()}.
   * <p>
   * Method under test: {@link TbServiceBusConsumerTemplate#doCommit()}
   */
  @Test
  @DisplayName("Test doCommit()")
  void testDoCommit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(null,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbServiceBusConsumerTemplate.doCommit();
  }

  /**
   * Test {@link TbServiceBusConsumerTemplate#doCommit()}.
   * <p>
   * Method under test: {@link TbServiceBusConsumerTemplate#doCommit()}
   */
  @Test
  @DisplayName("Test doCommit()")
  @Disabled("TODO: Complete this test")
  void testDoCommit2() {
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

    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(admin,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbServiceBusConsumerTemplate.doCommit();
  }

  /**
   * Test {@link TbServiceBusConsumerTemplate#doUnsubscribe()}.
   * <p>
   * Method under test: {@link TbServiceBusConsumerTemplate#doUnsubscribe()}
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

    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(admin,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbServiceBusConsumerTemplate.doUnsubscribe();
  }

  /**
   * Test {@link TbServiceBusConsumerTemplate#decode(MessageWithDeliveryTag)} with
   * {@code MessageWithDeliveryTag}.
   * <p>
   * Method under test:
   * {@link TbServiceBusConsumerTemplate#decode(MessageWithDeliveryTag)}
   */
  @Test
  @DisplayName("Test decode(MessageWithDeliveryTag) with 'MessageWithDeliveryTag'")
  @Disabled("TODO: Complete this test")
  void testDecodeWithMessageWithDeliveryTag() throws InvalidProtocolBufferException, UnsupportedEncodingException {
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

    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(admin,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));
    MessageImpl message = new MessageImpl();

    // Act
    tbServiceBusConsumerTemplate.decode(new MessageWithDeliveryTag(message, "AXAXAXAX".getBytes("UTF-8")));
  }
}
