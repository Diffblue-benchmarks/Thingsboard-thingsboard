package org.thingsboard.server.queue.sqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.services.sqs.model.Message;
import com.google.protobuf.InvalidProtocolBufferException;
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

@ContextConfiguration(classes = {TbAwsSqsConsumerTemplate.class, TbAwsSqsSettings.class, String.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbAwsSqsConsumerTemplateDiffblueTest {
  @Autowired
  private TbAwsSqsConsumerTemplate<TbQueueMsg> tbAwsSqsConsumerTemplate;

  @Autowired
  private TbAwsSqsSettings tbAwsSqsSettings;

  @MockBean
  private TbQueueAdmin tbQueueAdmin;

  @MockBean
  private TbQueueMsgDecoder<TbQueueMsg> tbQueueMsgDecoder;

  /**
   * Test
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}.
   * <p>
   * Method under test:
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)")
  void testNewTbAwsSqsConsumerTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbAwsSqsSettings sqsSettings = mock(TbAwsSqsSettings.class);
    when(sqsSettings.getRegion()).thenReturn("us-east-2");
    when(sqsSettings.getUseDefaultCredentialProviderChain()).thenReturn(true);

    // Act
    TbAwsSqsConsumerTemplate<TbQueueMsg> actualTbAwsSqsConsumerTemplate = new TbAwsSqsConsumerTemplate<>(null,
        sqsSettings, "Topic", mock(TbQueueMsgDecoder.class));

    // Assert
    verify(sqsSettings).getRegion();
    verify(sqsSettings).getUseDefaultCredentialProviderChain();
    assertEquals("Topic", actualTbAwsSqsConsumerTemplate.getTopic());
    assertFalse(actualTbAwsSqsConsumerTemplate.isStopped());
    assertTrue(actualTbAwsSqsConsumerTemplate.getFullTopicNames().isEmpty());
  }

  /**
   * Test
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}.
   * <p>
   * Method under test:
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)")
  @Disabled("TODO: Complete this test")
  void testNewTbAwsSqsConsumerTemplate2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@48cd3477 testClass = org.thingsboard.server.queue.sqs.DiffblueFakeClass1268, locations = [], classes = [org.thingsboard.server.queue.sqs.TbAwsSqsConsumerTemplate, org.thingsboard.server.queue.sqs.TbAwsSqsSettings, java.lang.String], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@7f06ca38, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71b9f6a4, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@9c855ab, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@6c40da4], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    new TbAwsSqsConsumerTemplate<>(tbQueueAdmin, tbAwsSqsSettings, "Topic", mock(TbQueueMsgDecoder.class));

  }

  /**
   * Test
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link TbAwsSqsSettings#getAccessKeyId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder); given 'false'; then calls getAccessKeyId()")
  void testNewTbAwsSqsConsumerTemplate_givenFalse_thenCallsGetAccessKeyId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbAwsSqsSettings sqsSettings = mock(TbAwsSqsSettings.class);
    when(sqsSettings.getRegion()).thenReturn("us-east-2");
    when(sqsSettings.getUseDefaultCredentialProviderChain()).thenReturn(false);
    when(sqsSettings.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(sqsSettings.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    TbAwsSqsConsumerTemplate<TbQueueMsg> actualTbAwsSqsConsumerTemplate = new TbAwsSqsConsumerTemplate<>(null,
        sqsSettings, "Topic", mock(TbQueueMsgDecoder.class));

    // Assert
    verify(sqsSettings).getAccessKeyId();
    verify(sqsSettings).getRegion();
    verify(sqsSettings).getSecretAccessKey();
    verify(sqsSettings).getUseDefaultCredentialProviderChain();
    assertEquals("Topic", actualTbAwsSqsConsumerTemplate.getTopic());
    assertFalse(actualTbAwsSqsConsumerTemplate.isStopped());
    assertTrue(actualTbAwsSqsConsumerTemplate.getFullTopicNames().isEmpty());
  }

  /**
   * Test {@link TbAwsSqsConsumerTemplate#doPoll(long)}.
   * <p>
   * Method under test: {@link TbAwsSqsConsumerTemplate#doPoll(long)}
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

    TbAwsSqsConsumerTemplate<TbQueueMsg> tbAwsSqsConsumerTemplate = new TbAwsSqsConsumerTemplate<>(admin,
        new TbAwsSqsSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbAwsSqsConsumerTemplate.doPoll(1L);
  }

  /**
   * Test {@link TbAwsSqsConsumerTemplate#decode(Message)} with {@code Message}.
   * <ul>
   *   <li>When {@link Message} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsSqsConsumerTemplate#decode(Message)}
   */
  @Test
  @DisplayName("Test decode(Message) with 'Message'; when Message (default constructor)")
  @Disabled("TODO: Complete this test")
  void testDecodeWithMessage_whenMessage() throws InvalidProtocolBufferException {
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

    TbAwsSqsConsumerTemplate<TbQueueMsg> tbAwsSqsConsumerTemplate = new TbAwsSqsConsumerTemplate<>(admin,
        new TbAwsSqsSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbAwsSqsConsumerTemplate.decode(new Message());
  }

  /**
   * Test {@link TbAwsSqsConsumerTemplate#doCommit()}.
   * <p>
   * Method under test: {@link TbAwsSqsConsumerTemplate#doCommit()}
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

    TbAwsSqsConsumerTemplate<TbQueueMsg> tbAwsSqsConsumerTemplate = new TbAwsSqsConsumerTemplate<>(admin,
        new TbAwsSqsSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbAwsSqsConsumerTemplate.doCommit();
  }

  /**
   * Test {@link TbAwsSqsConsumerTemplate#doUnsubscribe()}.
   * <p>
   * Method under test: {@link TbAwsSqsConsumerTemplate#doUnsubscribe()}
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

    TbAwsSqsConsumerTemplate<TbQueueMsg> tbAwsSqsConsumerTemplate = new TbAwsSqsConsumerTemplate<>(admin,
        new TbAwsSqsSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbAwsSqsConsumerTemplate.doUnsubscribe();
  }
}
