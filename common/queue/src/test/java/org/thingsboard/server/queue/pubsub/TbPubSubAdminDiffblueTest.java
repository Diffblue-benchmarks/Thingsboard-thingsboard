package org.thingsboard.server.queue.pubsub;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbPubSubAdmin.class, TbPubSubSettings.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbPubSubAdminDiffblueTest {
  @Autowired
  private Map<String, String> map;

  @MockBean
  private String string;

  @Autowired
  private TbPubSubAdmin tbPubSubAdmin;

  @Autowired
  private TbPubSubSettings tbPubSubSettings;

  /**
   * Test {@link TbPubSubAdmin#TbPubSubAdmin(TbPubSubSettings, Map)}.
   * <p>
   * Method under test: {@link TbPubSubAdmin#TbPubSubAdmin(TbPubSubSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbPubSubAdmin(TbPubSubSettings, Map)")
  @Disabled("TODO: Complete this test")
  void testNewTbPubSubAdmin() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@4ae0cf64 testClass = org.thingsboard.server.queue.pubsub.DiffblueFakeClass3372, locations = [], classes = [org.thingsboard.server.queue.pubsub.TbPubSubAdmin, org.thingsboard.server.queue.pubsub.TbPubSubSettings], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@60dafba8, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71045a3c, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@20b72605, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@627e0f1b], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    //   Cannot mock/spy class java.lang.String
    //   Mockito cannot mock/spy because :
    //    - Cannot mock wrapper types, String.class or Class.class
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
    new TbPubSubAdmin(tbPubSubSettings, new HashMap<>());

  }

  /**
   * Test {@link TbPubSubAdmin#createTopicIfNotExists(String, String)} with
   * {@code partition}, {@code properties}.
   * <p>
   * Method under test:
   * {@link TbPubSubAdmin#createTopicIfNotExists(String, String)}
   */
  @Test
  @DisplayName("Test createTopicIfNotExists(String, String) with 'partition', 'properties'")
  @Disabled("TODO: Complete this test")
  void testCreateTopicIfNotExistsWithPartitionProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@594f43d9 testClass = org.thingsboard.server.queue.pubsub.DiffblueFakeClass3373, locations = [], classes = [org.thingsboard.server.queue.pubsub.TbPubSubAdmin], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@60dafba8, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71045a3c, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@20b72605, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@7a5b0cf6], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    //   Cannot mock/spy class java.lang.String
    //   Mockito cannot mock/spy because :
    //    - Cannot mock wrapper types, String.class or Class.class
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
    tbPubSubAdmin.createTopicIfNotExists("Partition", "Properties");
  }

  /**
   * Test {@link TbPubSubAdmin#deleteTopic(String)}.
   * <p>
   * Method under test: {@link TbPubSubAdmin#deleteTopic(String)}
   */
  @Test
  @DisplayName("Test deleteTopic(String)")
  @Disabled("TODO: Complete this test")
  void testDeleteTopic() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@bb3ffbb testClass = org.thingsboard.server.queue.pubsub.DiffblueFakeClass3374, locations = [], classes = [org.thingsboard.server.queue.pubsub.TbPubSubAdmin], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@60dafba8, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71045a3c, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@20b72605, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@7a5b0cf6], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    tbPubSubAdmin.deleteTopic("Topic");
  }

  /**
   * Test {@link TbPubSubAdmin#destroy()}.
   * <p>
   * Method under test: {@link TbPubSubAdmin#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Disabled("TODO: Complete this test")
  void testDestroy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@60bca2b7 testClass = org.thingsboard.server.queue.pubsub.DiffblueFakeClass3375, locations = [], classes = [org.thingsboard.server.queue.pubsub.TbPubSubAdmin], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@60dafba8, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71045a3c, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@20b72605, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@7a5b0cf6], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    tbPubSubAdmin.destroy();
  }
}
