package org.thingsboard.server.queue.sqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.common.util.ThingsBoardForkJoinWorkerThreadFactory;

@ContextConfiguration(classes = {TbAwsSqsSettings.class, TbAwsSqsAdmin.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbAwsSqsAdminDiffblueTest {
  @MockBean
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
  @Tag("MaintainedByDiffblue")
  void testNewTbAwsSqsAdmin() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.sqs.TbAwsSqsSettings
    //   when running class:
    //   package org.thingsboard.server.queue.sqs;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.sqs.TbAwsSqsSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.sqs.TbAwsSqsAdmin tbAwsSqsAdmin;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.sqs.TbAwsSqsSettings tbAwsSqsSettings;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new TbAwsSqsAdmin(tbAwsSqsSettings, new HashMap<>());

  }

  /**
   * Test {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}.
   * <p>
   * Method under test: {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}
   */
  @Test
  @DisplayName("Test new TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)")
  @Disabled("TODO: Complete this test")
  @Tag("MaintainedByDiffblue")
  void testNewTbAwsSqsAdmin2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@41e58a06 testClass = org.thingsboard.server.queue.sqs.DiffblueFakeClass18, locations = [], classes = [org.thingsboard.server.queue.sqs.TbAwsSqsAdmin, org.thingsboard.server.queue.sqs.TbAwsSqsSettings], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@2f4601f, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@2b9bcf06, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@d3af129, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:212)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1709)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:556)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:546)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:702)
    //   To avoid this error, consider adding a custom base class to setup static
    //   mocking for org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.
    //   For details on how to set up a custom base class, please follow this link:
    //   https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange
    HashMap<String, String> attributes = new HashMap<>();

    // Act
    new TbAwsSqsAdmin(tbAwsSqsSettings, attributes, new AmazonSQSAsyncClient());

  }

  /**
   * Test {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}.
   * <ul>
   *   <li>Then ProducerExecutor return {@link ForkJoinPool}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}
   */
  @Test
  @DisplayName("Test new TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS); then ProducerExecutor return ForkJoinPool")
  @Tag("MaintainedByDiffblue")
  void testNewTbAwsSqsAdmin_thenProducerExecutorReturnForkJoinPool() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
      //   Run dcover create --keep-partial-tests to gain insights into why
      //   a non-Spring test was created.

      // Arrange
      mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any())).thenReturn(new InetAddress[]{null});
      TbAwsSqsSettings sqsSettings = mock(TbAwsSqsSettings.class);
      when(sqsSettings.getThreadPoolSize()).thenReturn(3);
      HashMap<String, String> attributes = new HashMap<>();
      AmazonSQSAsyncClient sqsClient = mock(AmazonSQSAsyncClient.class);
      when(sqsClient.listQueues()).thenReturn(new ListQueuesResult());

      // Act
      TbAwsSqsAdmin actualTbAwsSqsAdmin = new TbAwsSqsAdmin(sqsSettings, attributes, sqsClient);

      // Assert
      verify(sqsClient).listQueues();
      verify(sqsSettings).getThreadPoolSize();
      ExecutorService producerExecutor = actualTbAwsSqsAdmin.getProducerExecutor();
      assertTrue(producerExecutor instanceof ForkJoinPool);
      assertTrue(((ForkJoinPool) producerExecutor).getFactory() instanceof ThingsBoardForkJoinWorkerThreadFactory);
      assertNull(((ForkJoinPool) producerExecutor).getUncaughtExceptionHandler());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getActiveThreadCount());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getPoolSize());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getQueuedSubmissionCount());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getRunningThreadCount());
      assertEquals(0L, ((ForkJoinPool) producerExecutor).getQueuedTaskCount());
      assertEquals(0L, ((ForkJoinPool) producerExecutor).getStealCount());
      assertEquals(3, ((ForkJoinPool) producerExecutor).getParallelism());
      assertFalse(((ForkJoinPool) producerExecutor).hasQueuedSubmissions());
      assertFalse(((ForkJoinPool) producerExecutor).isTerminating());
      assertTrue(((ForkJoinPool) producerExecutor).getAsyncMode());
      assertTrue(((ForkJoinPool) producerExecutor).isQuiescent());
    }
  }

  /**
   * Test {@link TbAwsSqsAdmin#deleteTopic(String)}.
   * <p>
   * Method under test: {@link TbAwsSqsAdmin#deleteTopic(String)}
   */
  @Test
  @DisplayName("Test deleteTopic(String)")
  @Disabled("TODO: Complete this test")
  @Tag("MaintainedByDiffblue")
  void testDeleteTopic() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@62ed4db8 testClass = org.thingsboard.server.queue.sqs.DiffblueFakeClass79, locations = [], classes = [org.thingsboard.server.queue.sqs.TbAwsSqsAdmin], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@2f4601f, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@2b9bcf06, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@d3af129, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:212)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1709)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:556)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:546)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:702)
    //   To avoid this error, consider adding a custom base class to setup static
    //   mocking for org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.
    //   For details on how to set up a custom base class, please follow this link:
    //   https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
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
  @Tag("MaintainedByDiffblue")
  void testDestroy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@37178d08 testClass = org.thingsboard.server.queue.sqs.DiffblueFakeClass80, locations = [], classes = [org.thingsboard.server.queue.sqs.TbAwsSqsAdmin], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@2f4601f, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@2b9bcf06, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@d3af129, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:212)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1709)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:556)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:546)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:702)
    //   To avoid this error, consider adding a custom base class to setup static
    //   mocking for org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.
    //   For details on how to set up a custom base class, please follow this link:
    //   https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange and Act
    tbAwsSqsAdmin.destroy();
  }
}
