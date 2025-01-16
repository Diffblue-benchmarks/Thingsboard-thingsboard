package org.thingsboard.server.service.queue.consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.QueueConfig;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.discovery.QueueKey;
import org.thingsboard.server.service.queue.DefaultTbCoreConsumerService;
import org.thingsboard.server.service.queue.consumer.MainQueueConsumerManager.ConsumerPerPartitionWrapper;
import org.thingsboard.server.service.queue.consumer.MainQueueConsumerManager.SingleConsumerWrapper;
import org.thingsboard.server.service.queue.ruleengine.TbQueueConsumerManagerTask;

@ContextConfiguration(classes = {MainQueueConsumerManager.ConsumerPerPartitionWrapper.class,
    MainQueueConsumerManager.SingleConsumerWrapper.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class MainQueueConsumerManagerDiffblueTest {
  @Autowired
  private MainQueueConsumerManager<TbQueueMsg, QueueConfig>.SingleConsumerWrapper singleConsumerWrapper;

  @Autowired
  private MainQueueConsumerManager<TbQueueMsg, QueueConfig>.ConsumerPerPartitionWrapper consumerPerPartitionWrapper;

  @MockBean
  private MainQueueConsumerManager mainQueueConsumerManager;

  /**
   * Test ConsumerPerPartitionWrapper
   * {@link ConsumerPerPartitionWrapper#getConsumers()}.
   * <p>
   * Method under test:
   * {@link MainQueueConsumerManager.ConsumerPerPartitionWrapper#getConsumers()}
   */
  @Test
  @DisplayName("Test ConsumerPerPartitionWrapper getConsumers()")
  void testConsumerPerPartitionWrapperGetConsumers() {
    // Arrange, Act and Assert
    assertTrue(consumerPerPartitionWrapper.getConsumers().isEmpty());
  }

  /**
   * Test SingleConsumerWrapper {@link SingleConsumerWrapper#getConsumers()}.
   * <p>
   * Method under test:
   * {@link MainQueueConsumerManager.SingleConsumerWrapper#getConsumers()}
   */
  @Test
  @DisplayName("Test SingleConsumerWrapper getConsumers()")
  void testSingleConsumerWrapperGetConsumers() {
    // Arrange and Act
    Collection actualConsumers = singleConsumerWrapper.getConsumers();

    // Assert
    assertTrue(actualConsumers instanceof List);
    assertTrue(actualConsumers.isEmpty());
  }

  /**
   * Test {@link MainQueueConsumerManager#update(Set)} with {@code partitions}.
   * <p>
   * Method under test: {@link MainQueueConsumerManager#update(Set)}
   */
  @Test
  @DisplayName("Test update(Set) with 'partitions'")
  void testUpdateWithPartitions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new TenantId(UUID.randomUUID()));

    DefaultTbCoreConsumerService.CoreQueueConfig ofResult = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42);
    MainQueueConsumerManager.MsgPackProcessor<TbQueueMsg, QueueConfig> msgPackProcessor = mock(
        MainQueueConsumerManager.MsgPackProcessor.class);
    BiFunction<QueueConfig, Integer, TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(BiFunction.class);
    DefaultEventLoop consumerExecutor = new DefaultEventLoop();
    DefaultEventLoop scheduler = new DefaultEventLoop();
    MainQueueConsumerManager<TbQueueMsg, QueueConfig> mainQueueConsumerManager = new MainQueueConsumerManager<>(
        queueKey, ofResult, msgPackProcessor, consumerCreator, consumerExecutor, scheduler, new DefaultEventLoop());

    // Act
    mainQueueConsumerManager.update(new HashSet<>());

    // Assert
    ExecutorService executorService = mainQueueConsumerManager.taskExecutor;
    assertTrue(executorService instanceof DefaultEventLoop);
    assertFalse(executorService.isTerminated());
  }

  /**
   * Test {@link MainQueueConsumerManager#update(Set)} with {@code partitions}.
   * <ul>
   *   <li>Given {@link QueueKey#QueueKey(ServiceType)} with type is
   * {@code TB_CORE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MainQueueConsumerManager#update(Set)}
   */
  @Test
  @DisplayName("Test update(Set) with 'partitions'; given QueueKey(ServiceType) with type is 'TB_CORE'")
  void testUpdateWithPartitions_givenQueueKeyWithTypeIsTbCore() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    DefaultTbCoreConsumerService.CoreQueueConfig ofResult = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42);
    MainQueueConsumerManager.MsgPackProcessor<TbQueueMsg, QueueConfig> msgPackProcessor = mock(
        MainQueueConsumerManager.MsgPackProcessor.class);
    BiFunction<QueueConfig, Integer, TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(BiFunction.class);
    DefaultEventLoop consumerExecutor = new DefaultEventLoop();
    DefaultEventLoop scheduler = new DefaultEventLoop();
    MainQueueConsumerManager<TbQueueMsg, QueueConfig> mainQueueConsumerManager = new MainQueueConsumerManager<>(
        queueKey, ofResult, msgPackProcessor, consumerCreator, consumerExecutor, scheduler, new DefaultEventLoop());

    // Act
    mainQueueConsumerManager.update(new HashSet<>());

    // Assert
    ExecutorService executorService = mainQueueConsumerManager.taskExecutor;
    assertTrue(executorService instanceof DefaultEventLoop);
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        mainQueueConsumerManager.queueKey.getTenantId().getId().toString());
    assertFalse(executorService.isTerminated());
  }

  /**
   * Test {@link MainQueueConsumerManager#addTask(TbQueueConsumerManagerTask)}.
   * <p>
   * Method under test:
   * {@link MainQueueConsumerManager#addTask(TbQueueConsumerManagerTask)}
   */
  @Test
  @DisplayName("Test addTask(TbQueueConsumerManagerTask)")
  void testAddTask() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    DefaultTbCoreConsumerService.CoreQueueConfig ofResult = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42);
    MainQueueConsumerManager.MsgPackProcessor<TbQueueMsg, QueueConfig> msgPackProcessor = mock(
        MainQueueConsumerManager.MsgPackProcessor.class);
    BiFunction<QueueConfig, Integer, TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(BiFunction.class);
    DefaultEventLoop consumerExecutor = new DefaultEventLoop();
    DefaultEventLoop scheduler = new DefaultEventLoop();
    MainQueueConsumerManager<TbQueueMsg, QueueConfig> mainQueueConsumerManager = new MainQueueConsumerManager<>(
        queueKey, ofResult, msgPackProcessor, consumerCreator, consumerExecutor, scheduler, new DefaultEventLoop());

    // Act
    mainQueueConsumerManager.addTask(TbQueueConsumerManagerTask.delete(true));

    // Assert
    ExecutorService executorService = mainQueueConsumerManager.taskExecutor;
    assertTrue(executorService instanceof DefaultEventLoop);
    assertFalse(executorService.isTerminated());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MainQueueConsumerManager#processTask(TbQueueConsumerManagerTask)}
   *   <li>{@link MainQueueConsumerManager#getConfig()}
   *   <li>{@link MainQueueConsumerManager#getPartitions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    MainQueueConsumerManager.MainQueueConsumerManagerBuilder<TbQueueMsg, QueueConfig> builderResult = MainQueueConsumerManager
        .builder();
    DefaultTbCoreConsumerService.CoreQueueConfig ofResult = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42);
    MainQueueConsumerManager.MainQueueConsumerManagerBuilder<TbQueueMsg, QueueConfig> consumerCreatorResult = builderResult
        .config(ofResult)
        .consumerCreator(mock(BiFunction.class));
    MainQueueConsumerManager.MainQueueConsumerManagerBuilder<TbQueueMsg, QueueConfig> msgPackProcessorResult = consumerCreatorResult
        .consumerExecutor(new DefaultEventLoop())
        .msgPackProcessor(mock(MainQueueConsumerManager.MsgPackProcessor.class));
    MainQueueConsumerManager.MainQueueConsumerManagerBuilder<TbQueueMsg, QueueConfig> queueKeyResult = msgPackProcessorResult
        .queueKey(new QueueKey(ServiceType.TB_CORE));
    MainQueueConsumerManager.MainQueueConsumerManagerBuilder<TbQueueMsg, QueueConfig> schedulerResult = queueKeyResult
        .scheduler(new DefaultEventLoop());
    MainQueueConsumerManager<TbQueueMsg, QueueConfig> buildResult = schedulerResult.taskExecutor(new DefaultEventLoop())
        .build();

    // Act
    buildResult.processTask(TbQueueConsumerManagerTask.delete(true));
    QueueConfig actualConfig = buildResult.getConfig();
    buildResult.getPartitions();

    // Assert that nothing has changed
    assertSame(ofResult, actualConfig);
  }
}
