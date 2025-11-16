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
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.common.msg.TbActorStopReason;

@ExtendWith(MockitoExtension.class)
class TbActorMailboxDiffblueTest {
  @Mock private Dispatcher dispatcher;

  @InjectMocks private TbActorMailbox tbActorMailbox;

  @Mock private TbActorSystem tbActorSystem;

  @Mock private TbActorSystemSettings tbActorSystemSettings;

  /**
   * Test {@link TbActorMailbox#initActor()}.
   *
   * <ul>
   *   <li>Then calls {@link TbActorSystemSettings#getSchedulerPoolSize()}.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#initActor()}
   */
  @Test
  @DisplayName("Test initActor(); then calls getSchedulerPoolSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbActorMailbox.initActor()"})
  void testInitActor_thenCallsGetSchedulerPoolSize() {
    // Arrange
    TbActorSystemSettings settings = mock(TbActorSystemSettings.class);
    when(settings.getSchedulerPoolSize()).thenReturn(3);
    DefaultTbActorSystem system = new DefaultTbActorSystem(settings);
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings2,
            selfId,
            null,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    tbActorMailbox.initActor();

    // Assert
    verify(settings).getSchedulerPoolSize();
  }

  /**
   * Test {@link TbActorMailbox#initActor()}.
   *
   * <ul>
   *   <li>Then throw {@link TbRuleNodeUpdateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#initActor()}
   */
  @Test
  @DisplayName("Test initActor(); then throw TbRuleNodeUpdateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbActorMailbox.initActor()"})
  void testInitActor_thenThrowTbRuleNodeUpdateException() {
    // Arrange
    TbRuleNodeUpdateException tbRuleNodeUpdateException =
        new TbRuleNodeUpdateException("An error occurred", new Throwable());
    when(dispatcher.getExecutor()).thenThrow(tbRuleNodeUpdateException);

    // Act and Assert
    assertThrows(TbRuleNodeUpdateException.class, () -> tbActorMailbox.initActor());
    verify(dispatcher).getExecutor();
  }

  /**
   * Test {@link TbActorMailbox#tell(TbActorMsg)} with {@code actorMsg}.
   *
   * <p>Method under test: {@link TbActorMailbox#tell(TbActorMsg)}
   */
  @Test
  @DisplayName("Test tell(TbActorMsg) with 'actorMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbActorMailbox.tell(TbActorMsg)"})
  void testTellWithActorMsg() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    tbActorMailbox.tell(mock(TbActorMsg.class));

    // Assert
    assertEquals(1, tbActorMailbox.getNormalPriorityMsgs().size());
  }

  /**
   * Test {@link TbActorMailbox#tell(TbActorId, TbActorMsg)} with {@code target}, {@code actorMsg}.
   *
   * <ul>
   *   <li>Given {@link TbActorSystem} {@link TbActorSystem#tell(TbActorId, TbActorMsg)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#tell(TbActorId, TbActorMsg)}
   */
  @Test
  @DisplayName(
      "Test tell(TbActorId, TbActorMsg) with 'target', 'actorMsg'; given TbActorSystem tell(TbActorId, TbActorMsg) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbActorMailbox.tell(TbActorId, TbActorMsg)"})
  void testTellWithTargetActorMsg_givenTbActorSystemTellDoesNothing() {
    // Arrange
    doNothing().when(tbActorSystem).tell(Mockito.<TbActorId>any(), Mockito.<TbActorMsg>any());

    // Act
    tbActorMailbox.tell(mock(TbActorId.class), mock(TbActorMsg.class));

    // Assert
    verify(tbActorSystem).tell(isA(TbActorId.class), isA(TbActorMsg.class));
  }

  /**
   * Test {@link TbActorMailbox#tell(TbActorId, TbActorMsg)} with {@code target}, {@code actorMsg}.
   *
   * <ul>
   *   <li>Then throw {@link TbRuleNodeUpdateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#tell(TbActorId, TbActorMsg)}
   */
  @Test
  @DisplayName(
      "Test tell(TbActorId, TbActorMsg) with 'target', 'actorMsg'; then throw TbRuleNodeUpdateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbActorMailbox.tell(TbActorId, TbActorMsg)"})
  void testTellWithTargetActorMsg_thenThrowTbRuleNodeUpdateException() {
    // Arrange
    TbRuleNodeUpdateException tbRuleNodeUpdateException =
        new TbRuleNodeUpdateException("An error occurred", new Throwable());
    doThrow(tbRuleNodeUpdateException)
        .when(tbActorSystem)
        .tell(Mockito.<TbActorId>any(), Mockito.<TbActorMsg>any());

    // Act and Assert
    assertThrows(
        TbRuleNodeUpdateException.class,
        () -> tbActorMailbox.tell(mock(TbActorId.class), mock(TbActorMsg.class)));
    verify(tbActorSystem).tell(isA(TbActorId.class), isA(TbActorMsg.class));
  }

  /**
   * Test {@link TbActorMailbox#tellWithHighPriority(TbActorMsg)}.
   *
   * <p>Method under test: {@link TbActorMailbox#tellWithHighPriority(TbActorMsg)}
   */
  @Test
  @DisplayName("Test tellWithHighPriority(TbActorMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbActorMailbox.tellWithHighPriority(TbActorMsg)"})
  void testTellWithHighPriority() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    tbActorMailbox.tellWithHighPriority(mock(TbActorMsg.class));

    // Assert
    assertEquals(1, tbActorMailbox.getHighPriorityMsgs().size());
  }

  /**
   * Test {@link TbActorMailbox#filterChildren(Predicate)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#filterChildren(Predicate)}
   */
  @Test
  @DisplayName("Test filterChildren(Predicate); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbActorMailbox.filterChildren(Predicate)"})
  void testFilterChildren_thenReturnEmpty() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    List<TbActorId> actualFilterChildrenResult =
        tbActorMailbox.filterChildren(mock(Predicate.class));

    // Assert
    assertTrue(actualFilterChildrenResult.isEmpty());
  }

  /**
   * Test {@link TbActorMailbox#stop(TbActorId)}.
   *
   * <ul>
   *   <li>Given {@link TbActorSystem} {@link TbActorSystem#stop(TbActorId)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#stop(TbActorId)}
   */
  @Test
  @DisplayName("Test stop(TbActorId); given TbActorSystem stop(TbActorId) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbActorMailbox.stop(TbActorId)"})
  void testStop_givenTbActorSystemStopDoesNothing() {
    // Arrange
    doNothing().when(tbActorSystem).stop(Mockito.<TbActorId>any());

    // Act
    tbActorMailbox.stop(mock(TbActorId.class));

    // Assert
    verify(tbActorSystem).stop(isA(TbActorId.class));
  }

  /**
   * Test {@link TbActorMailbox#stop(TbActorId)}.
   *
   * <ul>
   *   <li>Then throw {@link TbRuleNodeUpdateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#stop(TbActorId)}
   */
  @Test
  @DisplayName("Test stop(TbActorId); then throw TbRuleNodeUpdateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbActorMailbox.stop(TbActorId)"})
  void testStop_thenThrowTbRuleNodeUpdateException() {
    // Arrange
    TbRuleNodeUpdateException tbRuleNodeUpdateException =
        new TbRuleNodeUpdateException("An error occurred", new Throwable());
    doThrow(tbRuleNodeUpdateException).when(tbActorSystem).stop(Mockito.<TbActorId>any());

    // Act and Assert
    assertThrows(TbRuleNodeUpdateException.class, () -> tbActorMailbox.stop(mock(TbActorId.class)));
    verify(tbActorSystem).stop(isA(TbActorId.class));
  }

  /**
   * Test {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}.
   *
   * <p>Method under test: {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier,
   * Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbActorRef TbActorMailbox.getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)"
  })
  void testGetOrCreateChildActor() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));
    TbActorId actorId2 = mock(TbActorId.class);
    Supplier<String> dispatcher = system::toString;
    Supplier<TbActorCreator> creator = mock(Supplier.class);

    Supplier<Boolean> createCondition = mock(Supplier.class);
    TbRuleNodeUpdateException tbRuleNodeUpdateException =
        new TbRuleNodeUpdateException("An error occurred", new Throwable());
    when(createCondition.get()).thenThrow(tbRuleNodeUpdateException);

    // Act and Assert
    assertThrows(
        TbRuleNodeUpdateException.class,
        () -> tbActorMailbox.getOrCreateChildActor(actorId2, dispatcher, creator, createCondition));
    verify(createCondition).get();
  }

  /**
   * Test {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}.
   *
   * <p>Method under test: {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier,
   * Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbActorRef TbActorMailbox.getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)"
  })
  void testGetOrCreateChildActor2() {
    // Arrange
    TbRuleNodeUpdateException tbRuleNodeUpdateException =
        new TbRuleNodeUpdateException("An error occurred", new Throwable());
    when(tbActorSystem.getActor(Mockito.<TbActorId>any())).thenThrow(tbRuleNodeUpdateException);
    when(tbActorSystemSettings.getSchedulerPoolSize()).thenReturn(3);
    TbActorId actorId = mock(TbActorId.class);

    // Act and Assert
    assertThrows(
        TbRuleNodeUpdateException.class,
        () ->
            tbActorMailbox.getOrCreateChildActor(
                actorId,
                new DefaultTbActorSystem(tbActorSystemSettings)::toString,
                mock(Supplier.class),
                mock(Supplier.class)));
    verify(tbActorSystem).getActor(isA(TbActorId.class));
    verify(tbActorSystemSettings).getSchedulerPoolSize();
  }

  /**
   * Test {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Supplier} {@link Supplier#get()} return {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier,
   * Supplier, Supplier)}
   */
  @Test
  @DisplayName(
      "Test getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier); given 'false'; when Supplier get() return 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbActorRef TbActorMailbox.getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)"
  })
  void testGetOrCreateChildActor_givenFalse_whenSupplierGetReturnFalse_thenReturnNull() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));
    TbActorId actorId2 = mock(TbActorId.class);
    Supplier<String> dispatcher = system::toString;
    Supplier<TbActorCreator> creator = mock(Supplier.class);

    Supplier<Boolean> createCondition = mock(Supplier.class);
    when(createCondition.get()).thenReturn(false);

    // Act
    TbActorRef actualOrCreateChildActor =
        tbActorMailbox.getOrCreateChildActor(actorId2, dispatcher, creator, createCondition);

    // Assert
    verify(createCondition).get();
    assertNull(actualOrCreateChildActor);
  }

  /**
   * Test {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Supplier} {@link Supplier#get()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier,
   * Supplier, Supplier)}
   */
  @Test
  @DisplayName(
      "Test getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier); given 'true'; when Supplier get() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbActorRef TbActorMailbox.getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)"
  })
  void testGetOrCreateChildActor_givenTrue_whenSupplierGetReturnTrue() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));
    TbActorId actorId2 = mock(TbActorId.class);
    Supplier<String> dispatcher = system::toString;

    Supplier<TbActorCreator> creator = mock(Supplier.class);
    TbRuleNodeUpdateException tbRuleNodeUpdateException =
        new TbRuleNodeUpdateException("An error occurred", new Throwable());
    when(creator.get()).thenThrow(tbRuleNodeUpdateException);

    Supplier<Boolean> createCondition = mock(Supplier.class);
    when(createCondition.get()).thenReturn(true);

    // Act and Assert
    assertThrows(
        TbRuleNodeUpdateException.class,
        () -> tbActorMailbox.getOrCreateChildActor(actorId2, dispatcher, creator, createCondition));
    verify(createCondition).get();
    verify(creator).get();
  }

  /**
   * Test {@link TbActorMailbox#destroy(Throwable)}.
   *
   * <p>Method under test: {@link TbActorMailbox#destroy(Throwable)}
   */
  @Test
  @DisplayName("Test destroy(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbActorMailbox.destroy(Throwable)"})
  void testDestroy() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    tbActorMailbox.destroy(new Throwable());

    // Assert
    assertEquals(TbActorStopReason.STOPPED, tbActorMailbox.getStopReason());
    AtomicBoolean destroyInProgress = tbActorMailbox.getDestroyInProgress();
    assertTrue(destroyInProgress.get());
    assertTrue(destroyInProgress.getAcquire());
    assertTrue(destroyInProgress.getOpaque());
    assertTrue(destroyInProgress.getPlain());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbActor TbActorMailbox.getActor()",
    "TbActorId TbActorMailbox.getActorId()",
    "AtomicBoolean TbActorMailbox.getBusy()",
    "AtomicBoolean TbActorMailbox.getDestroyInProgress()",
    "Dispatcher TbActorMailbox.getDispatcher()",
    "ConcurrentLinkedQueue TbActorMailbox.getHighPriorityMsgs()",
    "ConcurrentLinkedQueue TbActorMailbox.getNormalPriorityMsgs()",
    "TbActorRef TbActorMailbox.getParentRef()",
    "AtomicBoolean TbActorMailbox.getReady()",
    "TbActorId TbActorMailbox.getSelf()",
    "TbActorId TbActorMailbox.getSelfId()",
    "TbActorSystemSettings TbActorMailbox.getSettings()",
    "TbActorStopReason TbActorMailbox.getStopReason()",
    "TbActorSystem TbActorMailbox.getSystem()"
  })
  void testGettersAndSetters() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);
    Dispatcher dispatcher = new Dispatcher("42", ForkJoinPool.commonPool());

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(system, settings, selfId, null, actor, dispatcher);

    // Act
    TbActor actualActor = tbActorMailbox.getActor();
    TbActorId actualActorId = tbActorMailbox.getActorId();
    AtomicBoolean actualBusy = tbActorMailbox.getBusy();
    AtomicBoolean actualDestroyInProgress = tbActorMailbox.getDestroyInProgress();
    Dispatcher actualDispatcher = tbActorMailbox.getDispatcher();
    ConcurrentLinkedQueue<TbActorMsg> actualHighPriorityMsgs = tbActorMailbox.getHighPriorityMsgs();
    ConcurrentLinkedQueue<TbActorMsg> actualNormalPriorityMsgs =
        tbActorMailbox.getNormalPriorityMsgs();
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
    assertFalse(actualBusy.getAcquire());
    assertFalse(actualDestroyInProgress.getAcquire());
    assertFalse(actualReady.getAcquire());
    assertFalse(actualBusy.getOpaque());
    assertFalse(actualDestroyInProgress.getOpaque());
    assertFalse(actualReady.getOpaque());
    assertFalse(actualBusy.getPlain());
    assertFalse(actualDestroyInProgress.getPlain());
    assertFalse(actualReady.getPlain());
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
   * Test {@link TbActorMailbox#TbActorMailbox(TbActorSystem, TbActorSystemSettings, TbActorId,
   * TbActorRef, TbActor, Dispatcher)}.
   *
   * <p>Method under test: {@link TbActorMailbox#TbActorMailbox(TbActorSystem,
   * TbActorSystemSettings, TbActorId, TbActorRef, TbActor, Dispatcher)}
   */
  @Test
  @DisplayName(
      "Test new TbActorMailbox(TbActorSystem, TbActorSystemSettings, TbActorId, TbActorRef, TbActor, Dispatcher)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbActorMailbox.<init>(TbActorSystem, TbActorSystemSettings, TbActorId, TbActorRef, TbActor, Dispatcher)"
  })
  void testNewTbActorMailbox() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId, testCtx);
    Dispatcher dispatcher = new Dispatcher("42", ForkJoinPool.commonPool());

    // Act
    TbActorMailbox actualTbActorMailbox =
        new TbActorMailbox(system, settings, selfId, parentRef, actor, dispatcher);

    // Assert
    TbActorSystem system2 = actualTbActorMailbox.getSystem();
    assertTrue(system2 instanceof DefaultTbActorSystem);
    TbActor actor2 = actualTbActorMailbox.getActor();
    assertTrue(actor2 instanceof SlowInitActor);
    assertNull(actualTbActorMailbox.getStopReason());
    assertTrue(actualTbActorMailbox.getHighPriorityMsgs().isEmpty());
    assertTrue(actualTbActorMailbox.getNormalPriorityMsgs().isEmpty());
    assertSame(system, system2);
    assertSame(dispatcher, actualTbActorMailbox.getDispatcher());
    assertSame(actor, actor2);
    assertSame(settings, actualTbActorMailbox.getSettings());
    assertSame(selfId, actualTbActorMailbox.getActorId());
    assertSame(selfId, actualTbActorMailbox.getSelf());
    assertSame(selfId, actualTbActorMailbox.getSelfId());
    assertSame(parentRef, actualTbActorMailbox.getParentRef());
  }
}
