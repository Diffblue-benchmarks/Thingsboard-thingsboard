package org.thingsboard.server.queue.sqs;

import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.UUID;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueCallback;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;
import org.thingsboard.server.queue.common.DefaultTbQueueMsg;
import org.thingsboard.server.queue.common.TbQueueTbMsgCallbackWrapper;
import org.thingsboard.server.queue.kafka.KafkaTbQueueMsg;

@ContextConfiguration(classes = {TbAwsSqsProducerTemplate.class, TbAwsSqsSettings.class, String.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbAwsSqsProducerTemplateDiffblueTest {
  @Autowired
  private TbAwsSqsProducerTemplate<TbQueueMsg> tbAwsSqsProducerTemplate;

  @Autowired
  private TbAwsSqsSettings tbAwsSqsSettings;

  @MockBean
  private TbQueueAdmin tbQueueAdmin;

  /**
   * Test
   * {@link TbAwsSqsProducerTemplate#TbAwsSqsProducerTemplate(TbQueueAdmin, TbAwsSqsSettings, String)}.
   * <p>
   * Method under test:
   * {@link TbAwsSqsProducerTemplate#TbAwsSqsProducerTemplate(TbQueueAdmin, TbAwsSqsSettings, String)}
   */
  @Test
  @DisplayName("Test new TbAwsSqsProducerTemplate(TbQueueAdmin, TbAwsSqsSettings, String)")
  @Disabled("TODO: Complete this test")
  void testNewTbAwsSqsProducerTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@580013c testClass = org.thingsboard.server.queue.sqs.DiffblueFakeClass1270, locations = [], classes = [org.thingsboard.server.queue.sqs.TbAwsSqsProducerTemplate, org.thingsboard.server.queue.sqs.TbAwsSqsSettings, java.lang.String], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@7f06ca38, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71b9f6a4, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@9c855ab, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@536a5792], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    new TbAwsSqsProducerTemplate<>(tbQueueAdmin, tbAwsSqsSettings, "Default Topic");

  }

  /**
   * Test
   * {@link TbAwsSqsProducerTemplate#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is fromString
   * {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAwsSqsProducerTemplate#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}
   */
  @Test
  @DisplayName("Test send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback); when TenantId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Disabled("TODO: Complete this test")
  void testSend_whenTenantIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() throws UnsupportedEncodingException {
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

    TbAwsSqsProducerTemplate<TbQueueMsg> tbAwsSqsProducerTemplate = new TbAwsSqsProducerTemplate<>(admin,
        new TbAwsSqsSettings(), "Default Topic");
    TopicPartitionInfo tpi = new TopicPartitionInfo("Topic",
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), 1, true);

    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(
        new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8"))));

    // Act
    tbAwsSqsProducerTemplate.send(tpi, defaultTbQueueMsg, new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class)));
  }

  /**
   * Test {@link TbAwsSqsProducerTemplate#stop()}.
   * <p>
   * Method under test: {@link TbAwsSqsProducerTemplate#stop()}
   */
  @Test
  @DisplayName("Test stop()")
  @Disabled("TODO: Complete this test")
  void testStop() {
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

    TbAwsSqsProducerTemplate<TbQueueMsg> tbAwsSqsProducerTemplate = new TbAwsSqsProducerTemplate<>(admin,
        new TbAwsSqsSettings(), "Default Topic");

    // Act
    tbAwsSqsProducerTemplate.stop();
  }
}
