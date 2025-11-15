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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.TbActorMsg;

class TbActorDiffblueTest {
  /**
   * Method under test: {@link TbActor#init(TbActorCtx)}
   */
  @Test
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
   * Method under test: {@link TbActor#onInitFailure(int, Throwable)}
   */
  @Test
  void testOnInitFailure() {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor slowInitActor = new SlowInitActor(actorId,
        new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));

    // Act
    InitFailureStrategy actualOnInitFailureResult = slowInitActor.onInitFailure(1, new Throwable());

    // Assert
    assertEquals(5000L, actualOnInitFailureResult.getRetryDelay());
    assertFalse(actualOnInitFailureResult.isStop());
  }

  /**
   * Method under test: {@link TbActor#onProcessFailure(TbActorMsg, Throwable)}
   */
  @Test
  void testOnProcessFailure() {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor slowInitActor = new SlowInitActor(actorId,
        new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));
    TbActorMsg msg = mock(TbActorMsg.class);

    // Act and Assert
    assertFalse(slowInitActor.onProcessFailure(msg, new Throwable()).isStop());
  }

  /**
   * Method under test: {@link TbActor#onProcessFailure(TbActorMsg, Throwable)}
   */
  @Test
  void testOnProcessFailure2() {
    // Arrange
    TbActorId actorId = mock(TbActorId.class);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicInteger invocationCount = new AtomicInteger(1);
    SlowInitActor slowInitActor = new SlowInitActor(actorId,
        new ActorTestCtx(latch, invocationCount, 3, new AtomicLong(1L)));
    TbActorMsg msg = mock(TbActorMsg.class);

    // Act and Assert
    assertTrue(slowInitActor.onProcessFailure(msg, new Error("foo")).isStop());
  }
}
