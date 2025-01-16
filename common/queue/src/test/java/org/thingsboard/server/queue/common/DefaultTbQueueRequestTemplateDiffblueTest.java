package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
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
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusConsumerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusProducerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;
import org.thingsboard.server.queue.common.DefaultTbQueueRequestTemplate.ResponseMetaData;
import org.thingsboard.server.queue.kafka.KafkaTbQueueMsg;

@ContextConfiguration(classes = {DefaultTbQueueRequestTemplate.class, ExecutorService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultTbQueueRequestTemplateDiffblueTest {
  @Autowired
  private DefaultTbQueueRequestTemplate<TbQueueMsg, TbQueueMsg> defaultTbQueueRequestTemplate;

  @MockBean
  private TbQueueAdmin tbQueueAdmin;

  @MockBean
  private TbQueueConsumer<TbQueueMsg> tbQueueConsumer;

  @MockBean
  private TbQueueProducer<TbQueueMsg> tbQueueProducer;

  /**
   * Test
   * {@link DefaultTbQueueRequestTemplate#DefaultTbQueueRequestTemplate(TbQueueAdmin, TbQueueProducer, TbQueueConsumer, long, long, long, ExecutorService)}.
   * <p>
   * Method under test:
   * {@link DefaultTbQueueRequestTemplate#DefaultTbQueueRequestTemplate(TbQueueAdmin, TbQueueProducer, TbQueueConsumer, long, long, long, ExecutorService)}
   */
  @Test
  @DisplayName("Test new DefaultTbQueueRequestTemplate(TbQueueAdmin, TbQueueProducer, TbQueueConsumer, long, long, long, ExecutorService)")
  @Disabled("TODO: Complete this test")
  void testNewDefaultTbQueueRequestTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@6846f439 testClass = org.thingsboard.server.queue.common.DiffblueFakeClass27, locations = [], classes = [org.thingsboard.server.queue.common.DefaultTbQueueRequestTemplate, java.util.concurrent.ExecutorService], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@72294b52, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@45387cbe, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@6aad4170, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@581b834], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:180)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    //   org.mockito.exceptions.base.MockitoException: 
    //   Cannot mock/spy long
    //   Mockito cannot mock/spy because :
    //    - primitive type
    //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:158)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:185)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:167)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:141)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:129)
    //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:363)
    //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:197)
    //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:788)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:606)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:221)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:110)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:212)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:225)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:152)
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
    new DefaultTbQueueRequestTemplate<>(tbQueueAdmin, tbQueueProducer, tbQueueConsumer, 1L, 1L, 42L,
        new DefaultEventLoop());

  }

  /**
   * Test ResponseMetaData getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbQueueRequestTemplate.ResponseMetaData#toString()}
   *   <li>{@link DefaultTbQueueRequestTemplate.ResponseMetaData#getExpTime()}
   *   <li>{@link DefaultTbQueueRequestTemplate.ResponseMetaData#getFuture()}
   *   <li>{@link DefaultTbQueueRequestTemplate.ResponseMetaData#getSubmitTime()}
   *   <li>{@link DefaultTbQueueRequestTemplate.ResponseMetaData#getTimeout()}
   * </ul>
   */
  @Test
  @DisplayName("Test ResponseMetaData getters and setters")
  void testResponseMetaDataGettersAndSetters() {
    // Arrange
    SettableFuture<Object> future = SettableFuture.create();
    DefaultTbQueueRequestTemplate.ResponseMetaData<Object> responseMetaData = new DefaultTbQueueRequestTemplate.ResponseMetaData<>(
        1L, future, 1L, 10L);

    // Act
    responseMetaData.toString();
    long actualExpTime = responseMetaData.getExpTime();
    SettableFuture<Object> actualFuture = responseMetaData.getFuture();
    long actualSubmitTime = responseMetaData.getSubmitTime();

    // Assert
    assertEquals(10L, responseMetaData.getTimeout());
    assertEquals(1L, actualExpTime);
    assertEquals(1L, actualSubmitTime);
    assertSame(future, actualFuture);
  }

  /**
   * Test ResponseMetaData
   * {@link ResponseMetaData#ResponseMetaData(long, SettableFuture, long, long)}.
   * <p>
   * Method under test:
   * {@link DefaultTbQueueRequestTemplate.ResponseMetaData#ResponseMetaData(long, SettableFuture, long, long)}
   */
  @Test
  @DisplayName("Test ResponseMetaData new ResponseMetaData(long, SettableFuture, long, long)")
  void testResponseMetaDataNewResponseMetaData() {
    // Arrange
    SettableFuture<Object> future = SettableFuture.create();

    // Act
    DefaultTbQueueRequestTemplate.ResponseMetaData<Object> actualResponseMetaData = new DefaultTbQueueRequestTemplate.ResponseMetaData<>(
        1L, future, 1L, 10L);

    // Assert
    assertEquals(10L, actualResponseMetaData.getTimeout());
    assertEquals(1L, actualResponseMetaData.getExpTime());
    assertEquals(1L, actualResponseMetaData.getSubmitTime());
    assertSame(future, actualResponseMetaData.getFuture());
  }

  /**
   * Test
   * {@link DefaultTbQueueRequestTemplate#setTimeoutException(UUID, ResponseMetaData, long)}.
   * <p>
   * Method under test:
   * {@link DefaultTbQueueRequestTemplate#setTimeoutException(UUID, DefaultTbQueueRequestTemplate.ResponseMetaData, long)}
   */
  @Test
  @DisplayName("Test setTimeoutException(UUID, ResponseMetaData, long)")
  @Disabled("TODO: Complete this test")
  void testSetTimeoutException() {
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
    TbServiceBusAdmin queueAdmin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbServiceBusSettings serviceBusSettings2 = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings2, new HashMap<>());

    TbServiceBusProducerTemplate<TbQueueMsg> requestTemplate = new TbServiceBusProducerTemplate<>(admin,
        new TbServiceBusSettings(), "Default Topic");

    TbServiceBusSettings serviceBusSettings3 = new TbServiceBusSettings();
    TbServiceBusAdmin admin2 = new TbServiceBusAdmin(serviceBusSettings3, new HashMap<>());

    TbServiceBusConsumerTemplate<TbQueueMsg> responseTemplate = new TbServiceBusConsumerTemplate<>(admin2,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    DefaultTbQueueRequestTemplate<TbQueueMsg, TbQueueMsg> defaultTbQueueRequestTemplate = new DefaultTbQueueRequestTemplate<>(
        queueAdmin, requestTemplate, responseTemplate, 1L, 1L, 42L, new DefaultEventLoop());
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    SettableFuture<TbQueueMsg> future = SettableFuture.create();

    // Act
    defaultTbQueueRequestTemplate.setTimeoutException(key,
        new DefaultTbQueueRequestTemplate.ResponseMetaData<>(1L, future, 1L, 10L), 1L);
  }

  /**
   * Test {@link DefaultTbQueueRequestTemplate#processResponse(TbQueueMsg)}.
   * <p>
   * Method under test:
   * {@link DefaultTbQueueRequestTemplate#processResponse(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test processResponse(TbQueueMsg)")
  @Disabled("TODO: Complete this test")
  void testProcessResponse() throws UnsupportedEncodingException {
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
    TbServiceBusAdmin queueAdmin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbServiceBusSettings serviceBusSettings2 = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings2, new HashMap<>());

    TbServiceBusProducerTemplate<TbQueueMsg> requestTemplate = new TbServiceBusProducerTemplate<>(admin,
        new TbServiceBusSettings(), "Default Topic");

    TbServiceBusSettings serviceBusSettings3 = new TbServiceBusSettings();
    TbServiceBusAdmin admin2 = new TbServiceBusAdmin(serviceBusSettings3, new HashMap<>());

    TbServiceBusConsumerTemplate<TbQueueMsg> responseTemplate = new TbServiceBusConsumerTemplate<>(admin2,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    DefaultTbQueueRequestTemplate<TbQueueMsg, TbQueueMsg> defaultTbQueueRequestTemplate = new DefaultTbQueueRequestTemplate<>(
        queueAdmin, requestTemplate, responseTemplate, 1L, 1L, 42L, new DefaultEventLoop());

    // Act
    defaultTbQueueRequestTemplate.processResponse(new DefaultTbQueueMsg(
        new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link DefaultTbQueueRequestTemplate#send(TbQueueMsg)} with
   * {@code request}.
   * <p>
   * Method under test: {@link DefaultTbQueueRequestTemplate#send(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test send(TbQueueMsg) with 'request'")
  @Disabled("TODO: Complete this test")
  void testSendWithRequest() throws UnsupportedEncodingException {
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
    TbServiceBusAdmin queueAdmin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbServiceBusSettings serviceBusSettings2 = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings2, new HashMap<>());

    TbServiceBusProducerTemplate<TbQueueMsg> requestTemplate = new TbServiceBusProducerTemplate<>(admin,
        new TbServiceBusSettings(), "Default Topic");

    TbServiceBusSettings serviceBusSettings3 = new TbServiceBusSettings();
    TbServiceBusAdmin admin2 = new TbServiceBusAdmin(serviceBusSettings3, new HashMap<>());

    TbServiceBusConsumerTemplate<TbQueueMsg> responseTemplate = new TbServiceBusConsumerTemplate<>(admin2,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    DefaultTbQueueRequestTemplate<TbQueueMsg, TbQueueMsg> defaultTbQueueRequestTemplate = new DefaultTbQueueRequestTemplate<>(
        queueAdmin, requestTemplate, responseTemplate, 1L, 1L, 42L, new DefaultEventLoop());

    // Act
    defaultTbQueueRequestTemplate.send(new DefaultTbQueueMsg(
        new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link DefaultTbQueueRequestTemplate#send(TbQueueMsg, long)} with
   * {@code request}, {@code requestTimeoutNs}.
   * <p>
   * Method under test:
   * {@link DefaultTbQueueRequestTemplate#send(TbQueueMsg, long)}
   */
  @Test
  @DisplayName("Test send(TbQueueMsg, long) with 'request', 'requestTimeoutNs'")
  @Disabled("TODO: Complete this test")
  void testSendWithRequestRequestTimeoutNs() throws UnsupportedEncodingException {
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
    TbServiceBusAdmin queueAdmin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbServiceBusSettings serviceBusSettings2 = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings2, new HashMap<>());

    TbServiceBusProducerTemplate<TbQueueMsg> requestTemplate = new TbServiceBusProducerTemplate<>(admin,
        new TbServiceBusSettings(), "Default Topic");

    TbServiceBusSettings serviceBusSettings3 = new TbServiceBusSettings();
    TbServiceBusAdmin admin2 = new TbServiceBusAdmin(serviceBusSettings3, new HashMap<>());

    TbServiceBusConsumerTemplate<TbQueueMsg> responseTemplate = new TbServiceBusConsumerTemplate<>(admin2,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    DefaultTbQueueRequestTemplate<TbQueueMsg, TbQueueMsg> defaultTbQueueRequestTemplate = new DefaultTbQueueRequestTemplate<>(
        queueAdmin, requestTemplate, responseTemplate, 1L, 1L, 42L, new DefaultEventLoop());

    // Act
    defaultTbQueueRequestTemplate.send(new DefaultTbQueueMsg(
        new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8")))), 1L);
  }

  /**
   * Test
   * {@link DefaultTbQueueRequestTemplate#sendToRequestTemplate(TbQueueMsg, UUID, SettableFuture, ResponseMetaData)}.
   * <p>
   * Method under test:
   * {@link DefaultTbQueueRequestTemplate#sendToRequestTemplate(TbQueueMsg, UUID, SettableFuture, DefaultTbQueueRequestTemplate.ResponseMetaData)}
   */
  @Test
  @DisplayName("Test sendToRequestTemplate(TbQueueMsg, UUID, SettableFuture, ResponseMetaData)")
  @Disabled("TODO: Complete this test")
  void testSendToRequestTemplate() throws UnsupportedEncodingException {
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
    TbServiceBusAdmin queueAdmin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbServiceBusSettings serviceBusSettings2 = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings2, new HashMap<>());

    TbServiceBusProducerTemplate<TbQueueMsg> requestTemplate = new TbServiceBusProducerTemplate<>(admin,
        new TbServiceBusSettings(), "Default Topic");

    TbServiceBusSettings serviceBusSettings3 = new TbServiceBusSettings();
    TbServiceBusAdmin admin2 = new TbServiceBusAdmin(serviceBusSettings3, new HashMap<>());

    TbServiceBusConsumerTemplate<TbQueueMsg> responseTemplate = new TbServiceBusConsumerTemplate<>(admin2,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    DefaultTbQueueRequestTemplate<TbQueueMsg, TbQueueMsg> defaultTbQueueRequestTemplate = new DefaultTbQueueRequestTemplate<>(
        queueAdmin, requestTemplate, responseTemplate, 1L, 1L, 42L, new DefaultEventLoop());
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(
        new KafkaTbQueueMsg(new ConsumerRecord<>("Topic", 1, 1L, "Key", "AXAXAXAX".getBytes("UTF-8"))));
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    SettableFuture<TbQueueMsg> future = SettableFuture.create();
    SettableFuture<TbQueueMsg> future2 = SettableFuture.create();

    // Act
    defaultTbQueueRequestTemplate.sendToRequestTemplate(defaultTbQueueMsg, requestId, future,
        new DefaultTbQueueRequestTemplate.ResponseMetaData<>(1L, future2, 1L, 10L));
  }
}
