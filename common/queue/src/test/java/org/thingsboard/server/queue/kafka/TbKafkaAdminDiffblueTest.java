package org.thingsboard.server.queue.kafka;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbKafkaAdmin.class, TbKafkaSettings.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbKafkaAdminDiffblueTest {
  @Autowired
  private Map<String, String> map;

  @MockBean
  private String string;

  @Autowired
  private TbKafkaAdmin tbKafkaAdmin;

  @Autowired
  private TbKafkaSettings tbKafkaSettings;

  /**
   * Test {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}.
   * <p>
   * Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbKafkaAdmin(TbKafkaSettings, Map)")
  @Disabled("TODO: Complete this test")
  void testNewTbKafkaAdmin() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@468e583b testClass = org.thingsboard.server.queue.kafka.DiffblueFakeClass6903, locations = [], classes = [org.thingsboard.server.queue.kafka.TbKafkaAdmin, org.thingsboard.server.queue.kafka.TbKafkaSettings], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@72294b52, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@45387cbe, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@6aad4170, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f7851b45], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    new TbKafkaAdmin(tbKafkaSettings, new HashMap<>());

  }

  /**
   * Test {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()}
   * {@link TbKafkaTopicConfigs#NUM_PARTITIONS_SETTING} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbKafkaAdmin(TbKafkaSettings, Map); given '42'; when HashMap() NUM_PARTITIONS_SETTING is '42'")
  void testNewTbKafkaAdmin_given42_whenHashMapNum_partitions_settingIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();

    HashMap<String, String> topicConfigs = new HashMap<>();
    topicConfigs.put(TbKafkaTopicConfigs.NUM_PARTITIONS_SETTING, "42");

    // Act
    new TbKafkaAdmin(settings, topicConfigs);

    // Assert
    assertTrue(topicConfigs.isEmpty());
  }

  /**
   * Test {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbKafkaAdmin(TbKafkaSettings, Map); given BiFunction")
  void testNewTbKafkaAdmin_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();

    HashMap<String, String> topicConfigs = new HashMap<>();
    topicConfigs.computeIfPresent(TbKafkaTopicConfigs.NUM_PARTITIONS_SETTING, mock(BiFunction.class));

    // Act
    new TbKafkaAdmin(settings, topicConfigs);

    // Assert
    assertTrue(topicConfigs.isEmpty());
  }

  /**
   * Test {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbKafkaAdmin(TbKafkaSettings, Map); when HashMap(); then HashMap() Empty")
  void testNewTbKafkaAdmin_whenHashMap_thenHashMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();
    HashMap<String, String> topicConfigs = new HashMap<>();

    // Act
    new TbKafkaAdmin(settings, topicConfigs);

    // Assert
    assertTrue(topicConfigs.isEmpty());
  }

  /**
   * Test {@link TbKafkaAdmin#createTopicIfNotExists(String, String)} with
   * {@code topic}, {@code properties}.
   * <p>
   * Method under test:
   * {@link TbKafkaAdmin#createTopicIfNotExists(String, String)}
   */
  @Test
  @DisplayName("Test createTopicIfNotExists(String, String) with 'topic', 'properties'")
  @Disabled("TODO: Complete this test")
  void testCreateTopicIfNotExistsWithTopicProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@27006ff5 testClass = org.thingsboard.server.queue.kafka.DiffblueFakeClass6905, locations = [], classes = [org.thingsboard.server.queue.kafka.TbKafkaAdmin, org.thingsboard.server.queue.kafka.TbKafkaSettings], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@72294b52, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@45387cbe, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@6aad4170, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f7851b45], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    tbKafkaAdmin.createTopicIfNotExists("Topic", "Properties");
  }

  /**
   * Test {@link TbKafkaAdmin#deleteTopic(String)}.
   * <p>
   * Method under test: {@link TbKafkaAdmin#deleteTopic(String)}
   */
  @Test
  @DisplayName("Test deleteTopic(String)")
  @Disabled("TODO: Complete this test")
  void testDeleteTopic() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@754a580f testClass = org.thingsboard.server.queue.kafka.DiffblueFakeClass6906, locations = [], classes = [org.thingsboard.server.queue.kafka.TbKafkaAdmin, org.thingsboard.server.queue.kafka.TbKafkaSettings], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@72294b52, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@45387cbe, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@6aad4170, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f7851b45], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    tbKafkaAdmin.deleteTopic("Topic");
  }

  /**
   * Test {@link TbKafkaAdmin#createTopic(NewTopic)}.
   * <p>
   * Method under test: {@link TbKafkaAdmin#createTopic(NewTopic)}
   */
  @Test
  @DisplayName("Test createTopic(NewTopic)")
  @Disabled("TODO: Complete this test")
  void testCreateTopic() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@55e37d5e testClass = org.thingsboard.server.queue.kafka.DiffblueFakeClass6904, locations = [], classes = [org.thingsboard.server.queue.kafka.TbKafkaAdmin, org.thingsboard.server.queue.kafka.TbKafkaSettings], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@72294b52, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@45387cbe, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@6aad4170, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f7851b45], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    tbKafkaAdmin.createTopic(new NewTopic("Name", 10, (short) 1));
  }

  /**
   * Test {@link TbKafkaAdmin#destroy()}.
   * <p>
   * Method under test: {@link TbKafkaAdmin#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  void testDestroy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     TbKafkaAdmin.numPartitions
    //     TbKafkaAdmin.replicationFactor
    //     TbKafkaAdmin.settings
    //     TbKafkaAdmin.topicConfigs
    //     TbKafkaAdmin.topics

    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();

    // Act
    (new TbKafkaAdmin(settings, new HashMap<>())).destroy();
  }

  /**
   * Test {@link TbKafkaAdmin#syncOffsets(String, String, Integer)}.
   * <p>
   * Method under test: {@link TbKafkaAdmin#syncOffsets(String, String, Integer)}
   */
  @Test
  @DisplayName("Test syncOffsets(String, String, Integer)")
  @Disabled("TODO: Complete this test")
  void testSyncOffsets() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@329774af testClass = org.thingsboard.server.queue.kafka.DiffblueFakeClass6907, locations = [], classes = [org.thingsboard.server.queue.kafka.TbKafkaAdmin, org.thingsboard.server.queue.kafka.TbKafkaSettings], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@72294b52, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@45387cbe, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@6aad4170, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f7851b45], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    tbKafkaAdmin.syncOffsets("42", "42", 1);
  }

  /**
   * Test {@link TbKafkaAdmin#syncOffsetsUnsafe(String, String, Integer)}.
   * <p>
   * Method under test:
   * {@link TbKafkaAdmin#syncOffsetsUnsafe(String, String, Integer)}
   */
  @Test
  @DisplayName("Test syncOffsetsUnsafe(String, String, Integer)")
  @Disabled("TODO: Complete this test")
  void testSyncOffsetsUnsafe() throws InterruptedException, ExecutionException, TimeoutException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@67aae682 testClass = org.thingsboard.server.queue.kafka.DiffblueFakeClass6908, locations = [], classes = [org.thingsboard.server.queue.kafka.TbKafkaAdmin, org.thingsboard.server.queue.kafka.TbKafkaSettings], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@72294b52, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@45387cbe, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@6aad4170, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f7851b45], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
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
    tbKafkaAdmin.syncOffsetsUnsafe("42", "42", 1);
  }
}
