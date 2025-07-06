package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbActorDiffblueTest {
  /**
   * Test {@link TbActor#init(TbActorCtx)}.
   *
   * <p>Method under test: {@link TbActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbActor.init(TbActorCtx)"})
  void testInit() throws TbActorException {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor slowInitActor =
        new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId2 = mock(TbActorId.class);
    CountDownLatch latch2 = new CountDownLatch(1);
    AtomicInteger invocationCount2 = new AtomicInteger(1);
    SlowInitActor actor =
        new SlowInitActor(
            actorId2, new ActorTestCtx(latch2, invocationCount2, 3, new AtomicLong(1L)));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InitFailureStrategy TbActor.onInitFailure(int, Throwable)"})
  void testOnInitFailure() {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor slowInitActor =
        new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    // Act
    InitFailureStrategy actualOnInitFailureResult = slowInitActor.onInitFailure(1, new Throwable());

    // Assert
    assertEquals(5000L, actualOnInitFailureResult.getRetryDelay());
    assertFalse(actualOnInitFailureResult.isStop());
  }
}
