/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import org.junit.jupiter.api.Test;
import org.thingsboard.common.util.ThingsBoardThreadFactory;
import org.thingsboard.server.common.msg.TbActorMsg;

class DefaultTbActorSystemDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultTbActorSystem#createDispatcher(String, ExecutorService)}
   */
  @Test
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
   * Method under test: {@link DefaultTbActorSystem#destroyDispatcher(String)}
   */
  @Test
  void testDestroyDispatcher() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3))).destroyDispatcher("42"));
  }

  /**
   * Method under test: {@link DefaultTbActorSystem#getActor(TbActorId)}
   */
  @Test
  void testGetActor() {
    // Arrange, Act and Assert
    assertNull((new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3))).getActor(mock(TbActorId.class)));
  }

  /**
   * Method under test:
   * {@link DefaultTbActorSystem#createRootActor(String, TbActorCreator)}
   */
  @Test
  void testCreateRootActor() {
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
   * Method under test:
   * {@link DefaultTbActorSystem#createChildActor(String, TbActorCreator, TbActorId)}
   */
  @Test
  void testCreateChildActor() {
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
   * Method under test:
   * {@link DefaultTbActorSystem#tellWithHighPriority(TbActorId, TbActorMsg)}
   */
  @Test
  void testTellWithHighPriority() {
    // Arrange, Act and Assert
    assertThrows(TbActorNotRegisteredException.class,
        () -> (new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3))).tellWithHighPriority(mock(TbActorId.class),
            mock(TbActorMsg.class)));
  }

  /**
   * Method under test: {@link DefaultTbActorSystem#tell(TbActorId, TbActorMsg)}
   */
  @Test
  void testTell() {
    // Arrange, Act and Assert
    assertThrows(TbActorNotRegisteredException.class,
        () -> (new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3))).tell(mock(TbActorId.class),
            mock(TbActorMsg.class)));
  }

  /**
   * Method under test:
   * {@link DefaultTbActorSystem#filterChildren(TbActorId, Predicate)}
   */
  @Test
  void testFilterChildren() {
    // Arrange, Act and Assert
    assertTrue((new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)))
        .filterChildren(mock(TbActorId.class), mock(Predicate.class))
        .isEmpty());
  }

  /**
   * Method under test: {@link DefaultTbActorSystem#stop()}
   */
  @Test
  void testStop() {
    // Arrange
    TbActorSystemSettings settings = mock(TbActorSystemSettings.class);
    when(settings.getSchedulerPoolSize()).thenReturn(3);

    // Act
    (new DefaultTbActorSystem(settings)).stop();

    // Assert
    verify(settings).getSchedulerPoolSize();
  }

  /**
   * Method under test: {@link DefaultTbActorSystem#stop(TbActorRef)}
   */
  @Test
  void testStop2() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbActorSystem#equals(Object)}
   *   <li>{@link DefaultTbActorSystem#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));

    // Act and Assert
    assertEquals(defaultTbActorSystem, defaultTbActorSystem);
    int expectedHashCodeResult = defaultTbActorSystem.hashCode();
    assertEquals(expectedHashCodeResult, defaultTbActorSystem.hashCode());
  }

  /**
   * Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));

    // Act and Assert
    assertNotEquals(defaultTbActorSystem, new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)));
  }

  /**
   * Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(3, 3, 3));

    // Act and Assert
    assertNotEquals(defaultTbActorSystem, new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)));
  }

  /**
   * Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbActorSystemSettings settings = mock(TbActorSystemSettings.class);
    when(settings.getSchedulerPoolSize()).thenReturn(3);
    DefaultTbActorSystem defaultTbActorSystem = new DefaultTbActorSystem(settings);

    // Act and Assert
    assertNotEquals(defaultTbActorSystem, new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)));
  }

  /**
   * Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)), null);
  }

  /**
   * Method under test: {@link DefaultTbActorSystem#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)),
        "Different type to DefaultTbActorSystem");
  }

  /**
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

  /**
   * Method under test:
   * {@link DefaultTbActorSystem#DefaultTbActorSystem(TbActorSystemSettings)}
   */
  @Test
  void testNewDefaultTbActorSystem() {
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
}
