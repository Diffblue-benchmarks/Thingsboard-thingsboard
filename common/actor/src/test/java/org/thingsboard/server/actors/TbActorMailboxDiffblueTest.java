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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.common.msg.TbActorStopReason;

class TbActorMailboxDiffblueTest {
  /**
   * Method under test: {@link TbActorMailbox#tell(TbActorId, TbActorMsg)}
   */
  @Test
  void testTell() {
    // Arrange
    TbActorSystem system = mock(TbActorSystem.class);
    doNothing().when(system).tell(Mockito.<TbActorId>any(), Mockito.<TbActorMsg>any());
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor actor = new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    // Act
    (new TbActorMailbox(system, settings, selfId, null, actor, new Dispatcher("42", ForkJoinPool.commonPool())))
        .tell(mock(TbActorId.class), mock(TbActorMsg.class));

    // Assert
    verify(system).tell(isA(TbActorId.class), isA(TbActorMsg.class));
  }

  /**
   * Method under test: {@link TbActorMailbox#tell(TbActorMsg)}
   */
  @Test
  void testTell2() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor actor = new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    TbActorMailbox tbActorMailbox = new TbActorMailbox(system, settings, selfId, parentRef, actor,
        new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    tbActorMailbox.tell(mock(TbActorMsg.class));

    // Assert
    assertEquals(1, tbActorMailbox.getNormalPriorityMsgs().size());
  }

  /**
   * Method under test: {@link TbActorMailbox#tellWithHighPriority(TbActorMsg)}
   */
  @Test
  void testTellWithHighPriority() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor actor = new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    TbActorMailbox tbActorMailbox = new TbActorMailbox(system, settings, selfId, parentRef, actor,
        new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    tbActorMailbox.tellWithHighPriority(mock(TbActorMsg.class));

    // Assert
    assertEquals(1, tbActorMailbox.getHighPriorityMsgs().size());
  }

  /**
   * Method under test: {@link TbActorMailbox#filterChildren(Predicate)}
   */
  @Test
  void testFilterChildren() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor actor = new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    // Act and Assert
    assertTrue((new TbActorMailbox(system, settings, selfId, parentRef, actor,
        new Dispatcher("42", ForkJoinPool.commonPool()))).filterChildren(mock(Predicate.class)).isEmpty());
  }

  /**
   * Method under test:
   * {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}
   */
  @Test
  void testGetOrCreateChildActor() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L));

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);

    TbActorMailbox tbActorMailbox = new TbActorMailbox(system, settings, selfId, parentRef, actor,
        new Dispatcher("42", ForkJoinPool.commonPool()));
    TbActorId actorId2 = mock(TbActorId.class);
    Supplier<String> dispatcher = testCtx::toString;
    Supplier<TbActorCreator> creator = mock(Supplier.class);
    when(creator.get()).thenThrow(new TbRuleNodeUpdateException("An error occurred", new Throwable()));
    Supplier<Boolean> createCondition = mock(Supplier.class);
    when(createCondition.get()).thenReturn(true);

    // Act and Assert
    assertThrows(TbRuleNodeUpdateException.class,
        () -> tbActorMailbox.getOrCreateChildActor(actorId2, dispatcher, creator, createCondition));
    verify(createCondition).get();
    verify(creator).get();
  }

  /**
   * Method under test:
   * {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}
   */
  @Test
  void testGetOrCreateChildActor2() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L));

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);

    TbActorMailbox tbActorMailbox = new TbActorMailbox(system, settings, selfId, parentRef, actor,
        new Dispatcher("42", ForkJoinPool.commonPool()));
    TbActorId actorId2 = mock(TbActorId.class);
    Supplier<String> dispatcher = testCtx::toString;
    Supplier<TbActorCreator> creator = mock(Supplier.class);
    TbActorId actorId3 = mock(TbActorId.class);
    CountDownLatch latch2 = new CountDownLatch(1);
    AtomicInteger invocationCount2 = new AtomicInteger(1);
    when(creator.get()).thenReturn(new SlowInitActor.SlowInitActorCreator(actorId3,
        new ActorTestCtx(latch2, invocationCount2, 3, new AtomicLong(1L))));
    Supplier<Boolean> createCondition = mock(Supplier.class);
    when(createCondition.get()).thenReturn(false);

    // Act
    TbActorRef actualOrCreateChildActor = tbActorMailbox.getOrCreateChildActor(actorId2, dispatcher, creator,
        createCondition);

    // Assert
    verify(createCondition).get();
    assertNull(actualOrCreateChildActor);
  }

  /**
   * Method under test: {@link TbActorMailbox#destroy(Throwable)}
   */
  @Test
  void testDestroy() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor actor = new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    TbActorMailbox tbActorMailbox = new TbActorMailbox(system, settings, selfId, parentRef, actor,
        new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    tbActorMailbox.destroy(new Throwable());

    // Assert
    assertEquals(TbActorStopReason.STOPPED, tbActorMailbox.getStopReason());
    assertTrue(tbActorMailbox.getDestroyInProgress().get());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbActorMailbox#getActor()}
   *   <li>{@link TbActorMailbox#getActorId()}
   *   <li>{@link TbActorMailbox#getBusy()}
   *   <li>{@link TbActorMailbox#getDestroyInProgress()}
   *   <li>{@link TbActorMailbox#getDispatcher()}
   *   <li>{@link TbActorMailbox#getHighPriorityMsgs()}
   *   <li>{@link TbActorMailbox#getNormalPriorityMsgs()}
   *   <li>{@link TbActorMailbox#getParentRef()}
   *   <li>{@link TbActorMailbox#getReady()}
   *   <li>{@link TbActorMailbox#getSelf()}
   *   <li>{@link TbActorMailbox#getSelfId()}
   *   <li>{@link TbActorMailbox#getSettings()}
   *   <li>{@link TbActorMailbox#getStopReason()}
   *   <li>{@link TbActorMailbox#getSystem()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor actor = new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    Dispatcher dispatcher = new Dispatcher("42", ForkJoinPool.commonPool());

    TbActorMailbox tbActorMailbox = new TbActorMailbox(system, settings, selfId, null, actor, dispatcher);

    // Act
    TbActor actualActor = tbActorMailbox.getActor();
    TbActorId actualActorId = tbActorMailbox.getActorId();
    AtomicBoolean actualBusy = tbActorMailbox.getBusy();
    AtomicBoolean actualDestroyInProgress = tbActorMailbox.getDestroyInProgress();
    Dispatcher actualDispatcher = tbActorMailbox.getDispatcher();
    ConcurrentLinkedQueue<TbActorMsg> actualHighPriorityMsgs = tbActorMailbox.getHighPriorityMsgs();
    ConcurrentLinkedQueue<TbActorMsg> actualNormalPriorityMsgs = tbActorMailbox.getNormalPriorityMsgs();
    TbActorRef actualParentRef = tbActorMailbox.getParentRef();
    AtomicBoolean actualReady = tbActorMailbox.getReady();
    TbActorId actualSelf = tbActorMailbox.getSelf();
    TbActorId actualSelfId = tbActorMailbox.getSelfId();
    TbActorSystemSettings actualSettings = tbActorMailbox.getSettings();
    TbActorStopReason actualStopReason = tbActorMailbox.getStopReason();
    TbActorSystem actualSystem = tbActorMailbox.getSystem();

    // Assert
    assertNull(actualParentRef);
    assertNull(actualStopReason);
    assertFalse(actualBusy.get());
    assertFalse(actualDestroyInProgress.get());
    assertFalse(actualReady.get());
    assertTrue(actualHighPriorityMsgs.isEmpty());
    assertTrue(actualNormalPriorityMsgs.isEmpty());
    assertSame(system, actualSystem);
    assertSame(dispatcher, actualDispatcher);
    assertSame(actor, actualActor);
    assertSame(settings, actualSettings);
    assertSame(actualActorId, actualSelf);
    assertSame(actualActorId, actualSelfId);
  }

  /**
   * Method under test:
   * {@link TbActorMailbox#TbActorMailbox(TbActorSystem, TbActorSystemSettings, TbActorId, TbActorRef, TbActor, Dispatcher)}
   */
  @Test
  void testNewTbActorMailbox() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor actor = new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    Dispatcher dispatcher = new Dispatcher("42", ForkJoinPool.commonPool());

    // Act
    TbActorMailbox actualTbActorMailbox = new TbActorMailbox(system, settings, selfId, parentRef, actor, dispatcher);

    // Assert
    assertNull(actualTbActorMailbox.getStopReason());
    assertFalse(actualTbActorMailbox.getBusy().get());
    assertFalse(actualTbActorMailbox.getDestroyInProgress().get());
    assertFalse(actualTbActorMailbox.getReady().get());
    assertTrue(actualTbActorMailbox.getHighPriorityMsgs().isEmpty());
    assertTrue(actualTbActorMailbox.getNormalPriorityMsgs().isEmpty());
    assertSame(system, actualTbActorMailbox.getSystem());
    assertSame(dispatcher, actualTbActorMailbox.getDispatcher());
    assertSame(actor, actualTbActorMailbox.getActor());
    assertSame(settings, actualTbActorMailbox.getSettings());
    assertSame(selfId, actualTbActorMailbox.getActorId());
    assertSame(selfId, actualTbActorMailbox.getSelf());
    assertSame(selfId, actualTbActorMailbox.getSelfId());
    assertSame(parentRef, actualTbActorMailbox.getParentRef());
  }
}
