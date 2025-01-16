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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.common.msg.TbActorStopReason;

class TbActorMailboxDiffblueTest {
  /**
   * Test {@link TbActorMailbox#tell(TbActorMsg)} with {@code actorMsg}.
   * <p>
   * Method under test: {@link TbActorMailbox#tell(TbActorMsg)}
   */
  @Test
  @DisplayName("Test tell(TbActorMsg) with 'actorMsg'")
  void testTellWithActorMsg() {
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
   * Test {@link TbActorMailbox#tell(TbActorId, TbActorMsg)} with {@code target},
   * {@code actorMsg}.
   * <ul>
   *   <li>Given {@link TbActorSystem}
   * {@link TbActorSystem#tell(TbActorId, TbActorMsg)} does nothing.</li>
   *   <li>Then calls {@link TbActorSystem#tell(TbActorId, TbActorMsg)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbActorMailbox#tell(TbActorId, TbActorMsg)}
   */
  @Test
  @DisplayName("Test tell(TbActorId, TbActorMsg) with 'target', 'actorMsg'; given TbActorSystem tell(TbActorId, TbActorMsg) does nothing; then calls tell(TbActorId, TbActorMsg)")
  void testTellWithTargetActorMsg_givenTbActorSystemTellDoesNothing_thenCallsTell() {
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
   * Test {@link TbActorMailbox#tellWithHighPriority(TbActorMsg)}.
   * <p>
   * Method under test: {@link TbActorMailbox#tellWithHighPriority(TbActorMsg)}
   */
  @Test
  @DisplayName("Test tellWithHighPriority(TbActorMsg)")
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
   * Test {@link TbActorMailbox#filterChildren(Predicate)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbActorMailbox#filterChildren(Predicate)}
   */
  @Test
  @DisplayName("Test filterChildren(Predicate); then return Empty")
  void testFilterChildren_thenReturnEmpty() {
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
   * Test
   * {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Supplier} {@link Supplier#get()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier); given 'false'; when Supplier get() return 'false'; then return 'null'")
  void testGetOrCreateChildActor_givenFalse_whenSupplierGetReturnFalse_thenReturnNull() {
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
   * Test
   * {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}.
   * <ul>
   *   <li>Then throw {@link TbRuleNodeUpdateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}
   */
  @Test
  @DisplayName("Test getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier); then throw TbRuleNodeUpdateException")
  void testGetOrCreateChildActor_thenThrowTbRuleNodeUpdateException() {
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
   * Test {@link TbActorMailbox#destroy(Throwable)}.
   * <p>
   * Method under test: {@link TbActorMailbox#destroy(Throwable)}
   */
  @Test
  @DisplayName("Test destroy(Throwable)")
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
   * Test {@link TbActorMailbox#destroy(Throwable)}.
   * <p>
   * Method under test: {@link TbActorMailbox#destroy(Throwable)}
   */
  @Test
  @DisplayName("Test destroy(Throwable)")
  void testDestroy2() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L));

    SlowCreateActor actor = new SlowCreateActor(actorId, testCtx, new CountDownLatch(1));

    TbActorMailbox tbActorMailbox = new TbActorMailbox(system, settings, selfId, parentRef, actor,
        new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    tbActorMailbox.destroy(new Throwable());

    // Assert
    assertEquals(TbActorStopReason.STOPPED, tbActorMailbox.getStopReason());
    assertTrue(tbActorMailbox.getDestroyInProgress().get());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test
   * {@link TbActorMailbox#TbActorMailbox(TbActorSystem, TbActorSystemSettings, TbActorId, TbActorRef, TbActor, Dispatcher)}.
   * <p>
   * Method under test:
   * {@link TbActorMailbox#TbActorMailbox(TbActorSystem, TbActorSystemSettings, TbActorId, TbActorRef, TbActor, Dispatcher)}
   */
  @Test
  @DisplayName("Test new TbActorMailbox(TbActorSystem, TbActorSystemSettings, TbActorId, TbActorRef, TbActor, Dispatcher)")
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
