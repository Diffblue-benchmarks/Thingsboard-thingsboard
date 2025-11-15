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
package org.thingsboard.server.transport.snmp.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.jupiter.api.Test;

class ScheduledTaskDiffblueTest {
  /**
   * Method under test:
   * {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}
   */
  @Test
  void testInit() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    AsyncCallable<Void> task = mock(AsyncCallable.class);
    DefaultEventLoop scheduler = new DefaultEventLoop();

    // Act
    scheduledTask.init(task, 1L, scheduler);

    // Assert
    assertFalse(scheduler.isTerminated());
  }

  /**
   * Method under test:
   * {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}
   */
  @Test
  void testInit2() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    AsyncCallable<Void> task = mock(AsyncCallable.class);
    io.netty.channel.DefaultEventLoop scheduler = new io.netty.channel.DefaultEventLoop();

    // Act
    scheduledTask.init(task, 1L, scheduler);

    // Assert
    assertFalse(scheduler.isTerminated());
  }

  /**
   * Method under test:
   * {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}
   */
  @Test
  void testInit3() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    scheduledTask.setStopped(true);
    AsyncCallable<Void> task = mock(AsyncCallable.class);
    DefaultEventLoop scheduler = new DefaultEventLoop();

    // Act
    scheduledTask.init(task, 1L, scheduler);

    // Assert
    assertFalse(scheduler.isTerminated());
  }

  /**
   * Method under test: {@link ScheduledTask#cancel()}
   */
  @Test
  void testCancel() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();

    // Act
    scheduledTask.cancel();

    // Assert
    assertTrue(scheduledTask.isStopped());
  }

  /**
   * Method under test: {@link ScheduledTask#cancel()}
   */
  @Test
  void testCancel2() {
    // Arrange
    ListenableFutureTask<?> scheduledFuture = mock(ListenableFutureTask.class);
    when(scheduledFuture.cancel(anyBoolean())).thenReturn(true);

    ScheduledTask scheduledTask = new ScheduledTask();
    scheduledTask.setScheduledFuture(scheduledFuture);

    // Act
    scheduledTask.cancel();

    // Assert
    verify(scheduledFuture).cancel(eq(true));
    assertTrue(scheduledTask.isStopped());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ScheduledTask#equals(Object)}
   *   <li>{@link ScheduledTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    ScheduledTask scheduledTask2 = new ScheduledTask();

    // Act and Assert
    assertEquals(scheduledTask, scheduledTask2);
    int expectedHashCodeResult = scheduledTask.hashCode();
    assertEquals(expectedHashCodeResult, scheduledTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ScheduledTask#equals(Object)}
   *   <li>{@link ScheduledTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();

    // Act and Assert
    assertEquals(scheduledTask, scheduledTask);
    int expectedHashCodeResult = scheduledTask.hashCode();
    assertEquals(expectedHashCodeResult, scheduledTask.hashCode());
  }

  /**
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), 1);
  }

  /**
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    scheduledTask.setStopped(true);

    // Act and Assert
    assertNotEquals(scheduledTask, new ScheduledTask());
  }

  /**
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    SettableFuture<?> delegate = SettableFuture.create();
    scheduledTask.setScheduledFuture(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    // Act and Assert
    assertNotEquals(scheduledTask, new ScheduledTask());
  }

  /**
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SettableFuture<?> delegate = SettableFuture.create();

    ListenableFutureToApiFuture<?> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    delegate2.addListener(mock(Runnable.class), mock(Executor.class));
    ApiFutureToListenableFuture<?> scheduledFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(delegate2));

    ScheduledTask scheduledTask = new ScheduledTask();
    scheduledTask.setScheduledFuture(scheduledFuture);

    // Act and Assert
    assertNotEquals(scheduledTask, new ScheduledTask());
  }

  /**
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();

    ScheduledTask scheduledTask2 = new ScheduledTask();
    SettableFuture<?> delegate = SettableFuture.create();
    scheduledTask2.setScheduledFuture(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    // Act and Assert
    assertNotEquals(scheduledTask, scheduledTask2);
  }

  /**
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), null);
  }

  /**
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), "Different type to ScheduledTask");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ScheduledTask}
   *   <li>{@link ScheduledTask#setStopped(boolean)}
   *   <li>{@link ScheduledTask#toString()}
   *   <li>{@link ScheduledTask#getScheduledFuture()}
   *   <li>{@link ScheduledTask#isStopped()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ScheduledTask actualScheduledTask = new ScheduledTask();
    actualScheduledTask.setStopped(true);
    String actualToStringResult = actualScheduledTask.toString();
    actualScheduledTask.getScheduledFuture();

    // Assert that nothing has changed
    assertEquals("ScheduledTask(scheduledFuture=null, stopped=true)", actualToStringResult);
    assertTrue(actualScheduledTask.isStopped());
  }
}
