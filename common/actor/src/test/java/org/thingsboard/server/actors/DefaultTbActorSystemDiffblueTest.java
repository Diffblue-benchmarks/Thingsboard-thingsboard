package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.actors.SlowInitActor.SlowInitActorCreator;

class DefaultTbActorSystemDiffblueTest {
  /**
   * Test {@link DefaultTbActorSystem#DefaultTbActorSystem(TbActorSystemSettings)}.
   *
   * <ul>
   *   <li>Then Scheduler return {@link ScheduledThreadPoolExecutor}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#DefaultTbActorSystem(TbActorSystemSettings)}
   */
  @Test
  @DisplayName(
      "Test new DefaultTbActorSystem(TbActorSystemSettings); then Scheduler return ScheduledThreadPoolExecutor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbActorSystem.<init>(TbActorSystemSettings)"})
  void testNewDefaultTbActorSystem_thenSchedulerReturnScheduledThreadPoolExecutor() {
    // Arrange
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    // Act
    DefaultTbActorSystem actualDefaultTbActorSystem = new DefaultTbActorSystem(settings);

    // Assert
    assertTrue(actualDefaultTbActorSystem.getScheduler() instanceof ScheduledThreadPoolExecutor);
    assertTrue(actualDefaultTbActorSystem.getActorCreationLocks().isEmpty());
    assertTrue(actualDefaultTbActorSystem.getActors().isEmpty());
    assertTrue(actualDefaultTbActorSystem.getDispatchers().isEmpty());
    assertTrue(actualDefaultTbActorSystem.getParentChildMap().isEmpty());
    assertSame(settings, actualDefaultTbActorSystem.getSettings());
  }

  /**
   * Test {@link DefaultTbActorSystem#createDispatcher(String, ExecutorService)}.
   *
   * <p>Method under test: {@link DefaultTbActorSystem#createDispatcher(String, ExecutorService)}
   */
  @Test
  @DisplayName("Test createDispatcher(String, ExecutorService)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbActorSystem.createDispatcher(String, ExecutorService)"})
  void testCreateDispatcher() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem =
        new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
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
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#destroyDispatcher(String)}
   */
  @Test
  @DisplayName("Test destroyDispatcher(String); when '42'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbActorSystem.destroyDispatcher(String)"})
  void testDestroyDispatcher_when42_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)).destroyDispatcher("42"));
  }

  /**
   * Test {@link DefaultTbActorSystem#getActor(TbActorId)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#getActor(TbActorId)}
   */
  @Test
  @DisplayName("Test getActor(TbActorId); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbActorRef DefaultTbActorSystem.getActor(TbActorId)"})
  void testGetActor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3))
            .getActor(mock(TbActorId.class)));
  }

  /**
   * Test {@link DefaultTbActorSystem#createRootActor(String, TbActorCreator)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#createRootActor(String, TbActorCreator)}
   */
  @Test
  @DisplayName(
      "Test createRootActor(String, TbActorCreator); when '42'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbActorRef DefaultTbActorSystem.createRootActor(String, TbActorCreator)"})
  void testCreateRootActor_when42_thenThrowRuntimeException() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem =
        new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbActorSystem.createRootActor(
                "42",
                new SlowInitActorCreator(
                    actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)))));
  }

  /**
   * Test {@link DefaultTbActorSystem#createChildActor(String, TbActorCreator, TbActorId)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#createChildActor(String, TbActorCreator,
   * TbActorId)}
   */
  @Test
  @DisplayName(
      "Test createChildActor(String, TbActorCreator, TbActorId); when '42'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbActorRef DefaultTbActorSystem.createChildActor(String, TbActorCreator, TbActorId)"
  })
  void testCreateChildActor_when42_thenThrowRuntimeException() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem =
        new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbActorSystem.createChildActor(
                "42",
                new SlowInitActorCreator(
                    actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L))),
                mock(TbActorId.class)));
  }

  /**
   * Test {@link DefaultTbActorSystem#filterChildren(TbActorId, Predicate)}.
   *
   * <ul>
   *   <li>When {@link TbActorId}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#filterChildren(TbActorId, Predicate)}
   */
  @Test
  @DisplayName("Test filterChildren(TbActorId, Predicate); when TbActorId; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List DefaultTbActorSystem.filterChildren(TbActorId, Predicate)"})
  void testFilterChildren_whenTbActorId_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3))
            .filterChildren(mock(TbActorId.class), mock(Predicate.class))
            .isEmpty());
  }

  /**
   * Test {@link DefaultTbActorSystem#stop(TbActorRef)} with {@code actorRef}.
   *
   * <ul>
   *   <li>Given {@link TbActorId}.
   *   <li>Then calls {@link TbActorRef#getActorId()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#stop(TbActorRef)}
   */
  @Test
  @DisplayName("Test stop(TbActorRef) with 'actorRef'; given TbActorId; then calls getActorId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbActorSystem.stop(TbActorRef)"})
  void testStopWithActorRef_givenTbActorId_thenCallsGetActorId() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem =
        new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorRef actorRef = mock(TbActorRef.class);
    when(actorRef.getActorId()).thenReturn(mock(TbActorId.class));

    // Act
    defaultTbActorSystem.stop(actorRef);

    // Assert
    verify(actorRef).getActorId();
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}, and {@link DefaultTbActorSystem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultTbActorSystem#equals(Object)}
   *   <li>{@link DefaultTbActorSystem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultTbActorSystem.equals(Object)",
    "int DefaultTbActorSystem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem =
        new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));

    // Act and Assert
    assertEquals(defaultTbActorSystem, defaultTbActorSystem);
    int expectedHashCodeResult = defaultTbActorSystem.hashCode();
    assertEquals(expectedHashCodeResult, defaultTbActorSystem.hashCode());
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultTbActorSystem.equals(Object)",
    "int DefaultTbActorSystem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem =
        new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));

    // Act and Assert
    assertNotEquals(
        defaultTbActorSystem, new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)));
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultTbActorSystem.equals(Object)",
    "int DefaultTbActorSystem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem =
        new DefaultTbActorSystem(new TbActorSystemSettings(3, 3, 3));

    // Act and Assert
    assertNotEquals(
        defaultTbActorSystem, new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)));
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultTbActorSystem.equals(Object)",
    "int DefaultTbActorSystem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)), null);
  }

  /**
   * Test {@link DefaultTbActorSystem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultTbActorSystem.equals(Object)",
    "int DefaultTbActorSystem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)),
        "Different type to DefaultTbActorSystem");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ConcurrentMap DefaultTbActorSystem.getActorCreationLocks()",
    "ConcurrentMap DefaultTbActorSystem.getActors()",
    "ConcurrentMap DefaultTbActorSystem.getDispatchers()",
    "ConcurrentMap DefaultTbActorSystem.getParentChildMap()",
    "ScheduledExecutorService DefaultTbActorSystem.getScheduler()",
    "TbActorSystemSettings DefaultTbActorSystem.getSettings()",
    "String DefaultTbActorSystem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(settings);

    // Act
    defaultTbActorSystem.toString();
    ConcurrentMap<TbActorId, ReentrantLock> actualActorCreationLocks =
        defaultTbActorSystem.getActorCreationLocks();
    ConcurrentMap<TbActorId, TbActorMailbox> actualActors = defaultTbActorSystem.getActors();
    ConcurrentMap<String, Dispatcher> actualDispatchers = defaultTbActorSystem.getDispatchers();
    ConcurrentMap<TbActorId, Set<TbActorId>> actualParentChildMap =
        defaultTbActorSystem.getParentChildMap();
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
