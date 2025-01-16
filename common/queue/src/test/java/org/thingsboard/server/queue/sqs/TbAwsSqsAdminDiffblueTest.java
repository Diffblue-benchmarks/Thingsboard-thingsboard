package org.thingsboard.server.queue.sqs;

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

@ContextConfiguration(classes = {TbAwsSqsAdmin.class, TbAwsSqsSettings.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbAwsSqsAdminDiffblueTest {
  @Autowired
  private Map<String, String> map;

  @MockBean
  private String string;

  @Autowired
  private TbAwsSqsAdmin tbAwsSqsAdmin;

  @Autowired
  private TbAwsSqsSettings tbAwsSqsSettings;

  /**
   * Test {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map)}.
   * <p>
   * Method under test: {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbAwsSqsAdmin(TbAwsSqsSettings, Map)")
  @Disabled("TODO: Complete this test")
  void testNewTbAwsSqsAdmin() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@7c06d973 testClass = org.thingsboard.server.queue.sqs.DiffblueFakeClass1263, locations = [], classes = [org.thingsboard.server.queue.sqs.TbAwsSqsAdmin, org.thingsboard.server.queue.sqs.TbAwsSqsSettings], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@7f06ca38, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71b9f6a4, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@9c855ab, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@b533d9b2], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    new TbAwsSqsAdmin(tbAwsSqsSettings, new HashMap<>());

  }

  /**
   * Test {@link TbAwsSqsAdmin#createTopicIfNotExists(String, String)} with
   * {@code topic}, {@code properties}.
   * <p>
   * Method under test:
   * {@link TbAwsSqsAdmin#createTopicIfNotExists(String, String)}
   */
  @Test
  @DisplayName("Test createTopicIfNotExists(String, String) with 'topic', 'properties'")
  @Disabled("TODO: Complete this test")
  void testCreateTopicIfNotExistsWithTopicProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@368722a1 testClass = org.thingsboard.server.queue.sqs.DiffblueFakeClass1264, locations = [], classes = [org.thingsboard.server.queue.sqs.TbAwsSqsAdmin], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@7f06ca38, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71b9f6a4, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@9c855ab, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@2eb54e84], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    tbAwsSqsAdmin.createTopicIfNotExists("Topic", "Properties");
  }

  /**
   * Test {@link TbAwsSqsAdmin#deleteTopic(String)}.
   * <p>
   * Method under test: {@link TbAwsSqsAdmin#deleteTopic(String)}
   */
  @Test
  @DisplayName("Test deleteTopic(String)")
  @Disabled("TODO: Complete this test")
  void testDeleteTopic() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@297399ae testClass = org.thingsboard.server.queue.sqs.DiffblueFakeClass1265, locations = [], classes = [org.thingsboard.server.queue.sqs.TbAwsSqsAdmin], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@7f06ca38, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71b9f6a4, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@9c855ab, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@2eb54e84], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    tbAwsSqsAdmin.deleteTopic("Topic");
  }

  /**
   * Test {@link TbAwsSqsAdmin#destroy()}.
   * <p>
   * Method under test: {@link TbAwsSqsAdmin#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Disabled("TODO: Complete this test")
  void testDestroy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@7b853617 testClass = org.thingsboard.server.queue.sqs.DiffblueFakeClass1266, locations = [], classes = [org.thingsboard.server.queue.sqs.TbAwsSqsAdmin], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@7f06ca38, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71b9f6a4, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@9c855ab, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@2eb54e84], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    tbAwsSqsAdmin.destroy();
  }
}
