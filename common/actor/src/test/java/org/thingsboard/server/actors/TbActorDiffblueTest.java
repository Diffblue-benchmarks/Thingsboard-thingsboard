package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.TbActorMsg;

class TbActorDiffblueTest {
  /**
   * Test {@link TbActor#init(TbActorCtx)}.
   *
   * <p>Method under test: {@link TbActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbActor.init(TbActorCtx)"})
  void testInit() throws TbActorException {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor slowInitActor = new SlowInitActor(actorId, testCtx);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId2 = mock(TbActorId.class);
    CountDownLatch latch2 = new CountDownLatch(3);
    AtomicInteger invocationCount2 = new AtomicInteger();

    ActorTestCtx testCtx2 = new ActorTestCtx(latch2, invocationCount2, 3, new AtomicLong());

    SlowInitActor actor = new SlowInitActor(actorId2, testCtx2);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system,
            settings,
            selfId,
            parentRef,
            actor,
            new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    slowInitActor.init(ctx);

    // Assert
    assertSame(ctx, slowInitActor.getActorRef());
    assertSame(ctx, slowInitActor.getCtx());
  }

  /**
   * Test {@link TbActor#onInitFailure(int, Throwable)}.
   *
   * <p>Method under test: {@link TbActor#onInitFailure(int, Throwable)}
   */
  @Test
  @DisplayName("Test onInitFailure(int, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InitFailureStrategy TbActor.onInitFailure(int, Throwable)"})
  void testOnInitFailure() {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor slowInitActor = new SlowInitActor(actorId, testCtx);

    // Act
    InitFailureStrategy actualOnInitFailureResult = slowInitActor.onInitFailure(1, new Throwable());

    // Assert
    assertEquals(5000L, actualOnInitFailureResult.getRetryDelay());
    assertFalse(actualOnInitFailureResult.isStop());
  }

  /**
   * Test {@link TbActor#onProcessFailure(TbActorMsg, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Error#Error()}.
   *   <li>Then return Stop.
   * </ul>
   *
   * <p>Method under test: {@link TbActor#onProcessFailure(TbActorMsg, Throwable)}
   */
  @Test
  @DisplayName("Test onProcessFailure(TbActorMsg, Throwable); when Error(); then return Stop")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.actors.ProcessFailureStrategy TbActor.onProcessFailure(TbActorMsg, Throwable)"
  })
  void testOnProcessFailure_whenError_thenReturnStop() {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor slowInitActor = new SlowInitActor(actorId, testCtx);
    TbActorMsg msg = mock(TbActorMsg.class);

    // Act and Assert
    assertTrue(slowInitActor.onProcessFailure(msg, new Error()).isStop());
  }

  /**
   * Test {@link TbActor#onProcessFailure(TbActorMsg, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return not Stop.
   * </ul>
   *
   * <p>Method under test: {@link TbActor#onProcessFailure(TbActorMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test onProcessFailure(TbActorMsg, Throwable); when Throwable(); then return not Stop")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.actors.ProcessFailureStrategy TbActor.onProcessFailure(TbActorMsg, Throwable)"
  })
  void testOnProcessFailure_whenThrowable_thenReturnNotStop() {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(3);
    AtomicInteger invocationCount = new AtomicInteger();

    ActorTestCtx testCtx = new ActorTestCtx(latch, invocationCount, 3, new AtomicLong());

    SlowInitActor slowInitActor = new SlowInitActor(actorId, testCtx);
    TbActorMsg msg = mock(TbActorMsg.class);

    // Act and Assert
    assertFalse(slowInitActor.onProcessFailure(msg, new Throwable()).isStop());
  }
}
