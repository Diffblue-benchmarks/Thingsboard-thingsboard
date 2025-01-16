package org.thingsboard.server.queue.pubsub;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.gax.core.CredentialsProvider;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.pubsub.v1.PubsubMessage;
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

@ContextConfiguration(classes = {TbPubSubConsumerTemplate.class, TbPubSubSettings.class, String.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbPubSubConsumerTemplateDiffblueTest {
  @Autowired
  private TbPubSubConsumerTemplate<TbQueueMsg> tbPubSubConsumerTemplate;

  @Autowired
  private TbPubSubSettings tbPubSubSettings;

  @MockBean
  private TbQueueAdmin tbQueueAdmin;

  @MockBean
  private TbQueueMsgDecoder<TbQueueMsg> tbQueueMsgDecoder;

  /**
   * Test
   * {@link TbPubSubConsumerTemplate#TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder)}.
   * <p>
   * Method under test:
   * {@link TbPubSubConsumerTemplate#TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder)")
  @Disabled("TODO: Complete this test")
  void testNewTbPubSubConsumerTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@177d5a27 testClass = org.thingsboard.server.queue.pubsub.DiffblueFakeClass3377, locations = [], classes = [org.thingsboard.server.queue.pubsub.TbPubSubConsumerTemplate, org.thingsboard.server.queue.pubsub.TbPubSubSettings, java.lang.String], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@60dafba8, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71045a3c, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@20b72605, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@8197616], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    new TbPubSubConsumerTemplate<>(tbQueueAdmin, tbPubSubSettings, "Topic", mock(TbQueueMsgDecoder.class));

  }

  /**
   * Test
   * {@link TbPubSubConsumerTemplate#TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbPubSubConsumerTemplate#TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder); then throw RuntimeException")
  void testNewTbPubSubConsumerTemplate_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbPubSubSettings pubSubSettings = mock(TbPubSubSettings.class);
    when(pubSubSettings.getMaxMsgSize()).thenThrow(new RuntimeException("foo"));
    when(pubSubSettings.getCredentialsProvider()).thenReturn(mock(CredentialsProvider.class));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> new TbPubSubConsumerTemplate<>(null, pubSubSettings, "Topic", mock(TbQueueMsgDecoder.class)));

    verify(pubSubSettings).getCredentialsProvider();
    verify(pubSubSettings).getMaxMsgSize();
  }

  /**
   * Test {@link TbPubSubConsumerTemplate#doPoll(long)}.
   * <p>
   * Method under test: {@link TbPubSubConsumerTemplate#doPoll(long)}
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

    TbPubSubConsumerTemplate<TbQueueMsg> tbPubSubConsumerTemplate = new TbPubSubConsumerTemplate<>(admin,
        new TbPubSubSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbPubSubConsumerTemplate.doPoll(1L);
  }

  /**
   * Test {@link TbPubSubConsumerTemplate#doCommit()}.
   * <p>
   * Method under test: {@link TbPubSubConsumerTemplate#doCommit()}
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

    TbPubSubConsumerTemplate<TbQueueMsg> tbPubSubConsumerTemplate = new TbPubSubConsumerTemplate<>(admin,
        new TbPubSubSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbPubSubConsumerTemplate.doCommit();
  }

  /**
   * Test {@link TbPubSubConsumerTemplate#doUnsubscribe()}.
   * <p>
   * Method under test: {@link TbPubSubConsumerTemplate#doUnsubscribe()}
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

    TbPubSubConsumerTemplate<TbQueueMsg> tbPubSubConsumerTemplate = new TbPubSubConsumerTemplate<>(admin,
        new TbPubSubSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbPubSubConsumerTemplate.doUnsubscribe();
  }

  /**
   * Test {@link TbPubSubConsumerTemplate#decode(PubsubMessage)} with
   * {@code PubsubMessage}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbPubSubConsumerTemplate#decode(PubsubMessage)}
   */
  @Test
  @DisplayName("Test decode(PubsubMessage) with 'PubsubMessage'; when DefaultInstance")
  @Disabled("TODO: Complete this test")
  void testDecodeWithPubsubMessage_whenDefaultInstance() throws InvalidProtocolBufferException {
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

    TbPubSubConsumerTemplate<TbQueueMsg> tbPubSubConsumerTemplate = new TbPubSubConsumerTemplate<>(admin,
        new TbPubSubSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbPubSubConsumerTemplate.decode(PubsubMessage.getDefaultInstance());
  }
}
