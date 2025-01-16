package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.common.util.ThingsBoardThreadFactory;
import org.thingsboard.server.common.msg.TbActorMsg;

class DefaultTbActorSystemDiffblueTest {
  /**
   * Test
   * {@link DefaultTbActorSystem#DefaultTbActorSystem(TbActorSystemSettings)}.
   * <ul>
   *   <li>Then Scheduler return {@link ScheduledThreadPoolExecutor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbActorSystem#DefaultTbActorSystem(TbActorSystemSettings)}
   */
  @Test
  @DisplayName("Test new DefaultTbActorSystem(TbActorSystemSettings); then Scheduler return ScheduledThreadPoolExecutor")
  void testNewDefaultTbActorSystem_thenSchedulerReturnScheduledThreadPoolExecutor() {
    // Arrange
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    // Act
    DefaultTbActorSystem actualDefaultTbActorSystem = new DefaultTbActorSystem(settings);

    // Assert
    ScheduledExecutorService scheduler = actualDefaultTbActorSystem.getScheduler();
    assertTrue(scheduler instanceof ScheduledThreadPoolExecutor);
    assertTrue(((ScheduledThreadPoolExecutor) scheduler).getThreadFactory() instanceof ThingsBoardThreadFactory);
    assertEquals(0, ((ScheduledThreadPoolExecutor) scheduler).getActiveCount());
    assertEquals(0, ((ScheduledThreadPoolExecutor) scheduler).getLargestPoolSize());
    assertEquals(0, ((ScheduledThreadPoolExecutor) scheduler).getPoolSize());
    assertEquals(0L, ((ScheduledThreadPoolExecutor) scheduler).getCompletedTaskCount());
    assertEquals(0L, ((ScheduledThreadPoolExecutor) scheduler).getTaskCount());
    assertEquals(3, ((ScheduledThreadPoolExecutor) scheduler).getCorePoolSize());
    assertFalse(((ScheduledThreadPoolExecutor) scheduler).getContinueExistingPeriodicTasksAfterShutdownPolicy());
    assertFalse(((ScheduledThreadPoolExecutor) scheduler).getRemoveOnCancelPolicy());
    assertTrue(((ScheduledThreadPoolExecutor) scheduler).getQueue().isEmpty());
    assertTrue(actualDefaultTbActorSystem.getActorCreationLocks().isEmpty());
    assertTrue(actualDefaultTbActorSystem.getActors().isEmpty());
    assertTrue(actualDefaultTbActorSystem.getDispatchers().isEmpty());
    assertTrue(actualDefaultTbActorSystem.getParentChildMap().isEmpty());
    assertTrue(((ScheduledThreadPoolExecutor) scheduler).getExecuteExistingDelayedTasksAfterShutdownPolicy());
    assertEquals(Integer.MAX_VALUE, ((ScheduledThreadPoolExecutor) scheduler).getMaximumPoolSize());
    assertSame(settings, actualDefaultTbActorSystem.getSettings());
  }

  /**
   * Test {@link DefaultTbActorSystem#createDispatcher(String, ExecutorService)}.
   * <p>
   * Method under test:
   * {@link DefaultTbActorSystem#createDispatcher(String, ExecutorService)}
   */
  @Test
  @DisplayName("Test createDispatcher(String, ExecutorService)")
  void testCreateDispatcher() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    ForkJoinPool executor = ForkJoinPool.commonPool();

    // Act
    defaultTbActorSystem.createDispatcher("42", executor);

    // Assert
    ConcurrentMap<String, Dispatcher> dispatchers = defaultTbActorSystem.getDispatchers();
    assertEquals(1, dispatchers.size());
    Dispatcher getResult = dispatchers.get("42");
    assertEquals("42", getResult.getDispatcherId());
    assertSame(executor, getResult.getExecutor());
  }

  /**
   * Test {@link DefaultTbActorSystem#destroyDispatcher(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbActorSystem#destroyDispatcher(String)}
   */
  @Test
  @DisplayName("Test destroyDispatcher(String); when '42'; then throw RuntimeException")
  void testDestroyDispatcher_when42_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3))).destroyDispatcher("42"));
  }

  /**
   * Test {@link DefaultTbActorSystem#getActor(TbActorId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbActorSystem#getActor(TbActorId)}
   */
  @Test
  @DisplayName("Test getActor(TbActorId); then return 'null'")
  void testGetActor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3))).getActor(mock(TbActorId.class)));
  }

  /**
   * Test {@link DefaultTbActorSystem#createRootActor(String, TbActorCreator)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbActorSystem#createRootActor(String, TbActorCreator)}
   */
  @Test
  @DisplayName("Test createRootActor(String, TbActorCreator); when '42'; then throw RuntimeException")
  void testCreateRootActor_when42_thenThrowRuntimeException() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbActorSystem.createRootActor("42", new SlowInitActor.SlowInitActorCreator(actorId,
            new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)))));
  }

  /**
   * Test
   * {@link DefaultTbActorSystem#createChildActor(String, TbActorCreator, TbActorId)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbActorSystem#createChildActor(String, TbActorCreator, TbActorId)}
   */
  @Test
  @DisplayName("Test createChildActor(String, TbActorCreator, TbActorId); when '42'; then throw RuntimeException")
  void testCreateChildActor_when42_thenThrowRuntimeException() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbActorSystem.createChildActor("42", new SlowInitActor.SlowInitActorCreator(actorId,
            new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L))), mock(TbActorId.class)));
  }

  /**
   * Test
   * {@link DefaultTbActorSystem#tellWithHighPriority(TbActorId, TbActorMsg)}.
   * <ul>
   *   <li>When {@link TbActorId}.</li>
   *   <li>Then throw {@link TbActorNotRegisteredException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbActorSystem#tellWithHighPriority(TbActorId, TbActorMsg)}
   */
  @Test
  @DisplayName("Test tellWithHighPriority(TbActorId, TbActorMsg); when TbActorId; then throw TbActorNotRegisteredException")
  void testTellWithHighPriority_whenTbActorId_thenThrowTbActorNotRegisteredException() {
    // Arrange, Act and Assert
    assertThrows(TbActorNotRegisteredException.class,
        () -> (new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3))).tellWithHighPriority(mock(TbActorId.class),
            mock(TbActorMsg.class)));
  }

  /**
   * Test {@link DefaultTbActorSystem#tell(TbActorId, TbActorMsg)} with
   * {@code target}, {@code actorMsg}.
   * <ul>
   *   <li>When {@link TbActorId}.</li>
   *   <li>Then throw {@link TbActorNotRegisteredException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbActorSystem#tell(TbActorId, TbActorMsg)}
   */
  @Test
  @DisplayName("Test tell(TbActorId, TbActorMsg) with 'target', 'actorMsg'; when TbActorId; then throw TbActorNotRegisteredException")
  void testTellWithTargetActorMsg_whenTbActorId_thenThrowTbActorNotRegisteredException() {
    // Arrange, Act and Assert
    assertThrows(TbActorNotRegisteredException.class,
        () -> (new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3))).tell(mock(TbActorId.class),
            mock(TbActorMsg.class)));
  }

  /**
   * Test {@link DefaultTbActorSystem#filterChildren(TbActorId, Predicate)}.
   * <ul>
   *   <li>When {@link TbActorId}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbActorSystem#filterChildren(TbActorId, Predicate)}
   */
  @Test
  @DisplayName("Test filterChildren(TbActorId, Predicate); when TbActorId; then return Empty")
  void testFilterChildren_whenTbActorId_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)))
        .filterChildren(mock(TbActorId.class), mock(Predicate.class))
        .isEmpty());
  }

  /**
   * Test {@link DefaultTbActorSystem#stop(TbActorRef)} with {@code actorRef}.
   * <ul>
   *   <li>Given {@link TbActorId}.</li>
   *   <li>Then calls {@link TbActorRef#getActorId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbActorSystem#stop(TbActorRef)}
   */
  @Test
  @DisplayName("Test stop(TbActorRef) with 'actorRef'; given TbActorId; then calls getActorId()")
  void testStopWithActorRef_givenTbActorId_thenCallsGetActorId() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorRef actorRef = mock(TbActorRef.class);
    when(actorRef.getActorId()).thenReturn(mock(TbActorId.class));

    // Act
    defaultTbActorSystem.stop(actorRef);

    // Assert
    verify(actorRef).getActorId();
  }

  /**
   * Test {@link DefaultTbActorSystem#stop()}.
   * <ul>
   *   <li>Then calls {@link TbActorSystemSettings#getSchedulerPoolSize()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbActorSystem#stop()}
   */
  @Test
  @DisplayName("Test stop(); then calls getSchedulerPoolSize()")
  void testStop_thenCallsGetSchedulerPoolSize() {
    // Arrange
    TbActorSystemSettings settings = mock(TbActorSystemSettings.class);
    when(settings.getSchedulerPoolSize()).thenReturn(3);

    // Act
    (new DefaultTbActorSystem(settings)).stop();

    // Assert
    verify(settings).getSchedulerPoolSize();
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}, and
   * {@link DefaultTbActorSystem#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbActorSystem#equals(Object)}
   *   <li>{@link DefaultTbActorSystem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));

    // Act and Assert
    assertEquals(defaultTbActorSystem, defaultTbActorSystem);
    int expectedHashCodeResult = defaultTbActorSystem.hashCode();
    assertEquals(expectedHashCodeResult, defaultTbActorSystem.hashCode());
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));

    // Act and Assert
    assertNotEquals(defaultTbActorSystem, new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)));
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(3, 3, 3));

    // Act and Assert
    assertNotEquals(defaultTbActorSystem, new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)));
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbActorSystemSettings settings = mock(TbActorSystemSettings.class);
    when(settings.getSchedulerPoolSize()).thenReturn(3);
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(settings);

    // Act and Assert
    assertNotEquals(defaultTbActorSystem, new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)));
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)), null);
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)),
        "Different type to DefaultTbActorSystem");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbActorSystem#toString()}
   *   <li>{@link DefaultTbActorSystem#getActorCreationLocks()}
   *   <li>{@link DefaultTbActorSystem#getActors()}
   *   <li>{@link DefaultTbActorSystem#getDispatchers()}
   *   <li>{@link DefaultTbActorSystem#getParentChildMap()}
   *   <li>{@link DefaultTbActorSystem#getScheduler()}
   *   <li>{@link DefaultTbActorSystem#getSettings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(settings);

    // Act
    defaultTbActorSystem.toString();
    ConcurrentMap<TbActorId, ReentrantLock> actualActorCreationLocks = defaultTbActorSystem.getActorCreationLocks();
    ConcurrentMap<TbActorId, TbActorMailbox> actualActors = defaultTbActorSystem.getActors();
    ConcurrentMap<String, Dispatcher> actualDispatchers = defaultTbActorSystem.getDispatchers();
    ConcurrentMap<TbActorId, Set<TbActorId>> actualParentChildMap = defaultTbActorSystem.getParentChildMap();
    ScheduledExecutorService actualScheduler = defaultTbActorSystem.getScheduler();
    TbActorSystemSettings actualSettings = defaultTbActorSystem.getSettings();

    // Assert
    assertTrue(actualScheduler instanceof ScheduledThreadPoolExecutor);
    assertTrue(actualActorCreationLocks.isEmpty());
    assertTrue(actualActors.isEmpty());
    assertTrue(actualDispatchers.isEmpty());
    assertTrue(actualParentChildMap.isEmpty());
    assertSame(settings, actualSettings);
  }
}
