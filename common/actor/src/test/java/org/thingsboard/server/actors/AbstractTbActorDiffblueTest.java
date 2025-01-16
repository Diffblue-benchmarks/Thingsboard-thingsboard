package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractTbActorDiffblueTest {
  /**
   * Test {@link AbstractTbActor#getCtx()}.
   * <p>
   * Method under test: {@link AbstractTbActor#getCtx()}
   */
  @Test
  @DisplayName("Test getCtx()")
  void testGetCtx() {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);

    // Act and Assert
    assertNull((new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)))).getCtx());
  }

  /**
   * Test {@link AbstractTbActor#init(TbActorCtx)}.
   * <p>
   * Method under test: {@link AbstractTbActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName("Test init(TbActorCtx)")
  void testInit() throws TbActorException {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor slowInitActor = new SlowInitActor(actorId,
        new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorRef parentRef = mock(TbActorRef.class);
    TbActorId actorId2 = mock(TbActorId.class);
    CountDownLatch latch2 = new CountDownLatch(1);
    AtomicInteger invocationCount2 = new AtomicInteger(1);
    SlowInitActor actor = new SlowInitActor(actorId2,
        new ActorTestCtx(latch2, invocationCount2, 3, new AtomicLong(1L)));

    TbActorMailbox ctx = new TbActorMailbox(system, settings, selfId, parentRef, actor,
        new Dispatcher("42", ForkJoinPool.commonPool()));

    // Act
    slowInitActor.init(ctx);

    // Assert
    assertSame(ctx, slowInitActor.getActorRef());
    assertSame(ctx, slowInitActor.getCtx());
  }

  /**
   * Test {@link AbstractTbActor#getActorRef()}.
   * <p>
   * Method under test: {@link AbstractTbActor#getActorRef()}
   */
  @Test
  @DisplayName("Test getActorRef()")
  void testGetActorRef() {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);

    // Act and Assert
    assertNull(
        (new SlowInitActor(actorId, new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)))).getActorRef());
  }
}
