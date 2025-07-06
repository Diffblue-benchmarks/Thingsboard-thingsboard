package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbActorMailboxDiffblueTest {
  /**
   * Test {@link TbActorMailbox#initActor()}.
   *
   * <p>Method under test: {@link TbActorMailbox#initActor()}
   */
  @Test
  @DisplayName("Test initActor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbActorMailbox.initActor()"})
  void testInitActor() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor actor =
        new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    tbActorMailbox.initActor();

    // Assert that nothing has changed
    assertTrue(tbActorMailbox.getActor() instanceof SlowInitActor);
    assertFalse(tbActorMailbox.getReady().get());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List TbActorMailbox.filterChildren(Predicate)"})
  void testFilterChildren_thenReturnEmpty() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor actor =
        new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    // Act and Assert
    assertTrue(
        new TbActorMailbox(
                system,
                settings,
                selfId,
                parentRef,
                actor,
                new Dispatcher("42", ForkJoinPool.commonPool()))
            .filterChildren(mock(Predicate.class))
            .isEmpty());
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
  @Tag("MaintainedByDiffblue")
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
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L));

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
    Supplier<String> dispatcher = testCtx::toString;
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
   *   <li>Then throw {@link TbRuleNodeUpdateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier,
   * Supplier, Supplier)}
   */
  @Test
  @DisplayName(
      "Test getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier); then throw TbRuleNodeUpdateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbActorRef TbActorMailbox.getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)"
  })
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

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));
    TbActorId actorId2 = mock(TbActorId.class);
    Supplier<String> dispatcher = testCtx::toString;
    Supplier<TbActorCreator> creator = mock(Supplier.class);
    Supplier<Boolean> createCondition = mock(Supplier.class);
    when(createCondition.get())
        .thenThrow(new TbRuleNodeUpdateException("An error occurred", new Throwable()));

    // Act and Assert
    assertThrows(
        TbRuleNodeUpdateException.class,
        () -> tbActorMailbox.getOrCreateChildActor(actorId2, dispatcher, creator, createCondition));
    verify(createCondition).get();
  }

  /**
   * Test {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)}.
   *
   * <ul>
   *   <li>Then throw {@link TbRuleNodeUpdateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbActorMailbox#getOrCreateChildActor(TbActorId, Supplier,
   * Supplier, Supplier)}
   */
  @Test
  @DisplayName(
      "Test getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier); then throw TbRuleNodeUpdateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbActorRef TbActorMailbox.getOrCreateChildActor(TbActorId, Supplier, Supplier, Supplier)"
  })
  void testGetOrCreateChildActor_thenThrowTbRuleNodeUpdateException2() {
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

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));
    TbActorId actorId2 = mock(TbActorId.class);
    Supplier<String> dispatcher = testCtx::toString;
    Supplier<TbActorCreator> creator = mock(Supplier.class);
    when(creator.get())
        .thenThrow(new TbRuleNodeUpdateException("An error occurred", new Throwable()));
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
   * Test {@link TbActorMailbox#TbActorMailbox(TbActorSystem, TbActorSystemSettings, TbActorId,
   * TbActorRef, TbActor, Dispatcher)}.
   *
   * <p>Method under test: {@link TbActorMailbox#TbActorMailbox(TbActorSystem,
   * TbActorSystemSettings, TbActorId, TbActorRef, TbActor, Dispatcher)}
   */
  @Test
  @DisplayName(
      "Test new TbActorMailbox(TbActorSystem, TbActorSystemSettings, TbActorId, TbActorRef, TbActor, Dispatcher)")
  @Tag("MaintainedByDiffblue")
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
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor actor =
        new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

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
