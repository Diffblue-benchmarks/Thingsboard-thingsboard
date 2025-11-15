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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ScheduledTaskDiffblueTest {
  /**
   * Test {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}.
   * <ul>
   *   <li>Given {@link Runnable}.</li>
   *   <li>When minus one.</li>
   *   <li>Then not {@link DefaultEventLoop#DefaultEventLoop()} Terminated.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}
   */
  @Test
  @DisplayName("Test init(AsyncCallable, long, ScheduledExecutorService); given Runnable; when minus one; then not DefaultEventLoop() Terminated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScheduledTask.init(AsyncCallable, long, ScheduledExecutorService)"})
  void testInit_givenRunnable_whenMinusOne_thenNotDefaultEventLoopTerminated() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    AsyncCallable<Void> task = mock(AsyncCallable.class);

    DefaultEventLoop scheduler = new DefaultEventLoop();
    scheduler.addShutdownHook(mock(Runnable.class));

    // Act
    scheduledTask.init(task, -1L, scheduler);

    // Assert that nothing has changed
    assertFalse(scheduler.isTerminated());
  }

  /**
   * Test {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}.
   * <ul>
   *   <li>Given {@link ScheduledTask} (default constructor) Stopped is {@code true}.</li>
   *   <li>When {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}
   */
  @Test
  @DisplayName("Test init(AsyncCallable, long, ScheduledExecutorService); given ScheduledTask (default constructor) Stopped is 'true'; when DefaultEventLoop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScheduledTask.init(AsyncCallable, long, ScheduledExecutorService)"})
  void testInit_givenScheduledTaskStoppedIsTrue_whenDefaultEventLoop() {
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
   * Test {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}.
   * <ul>
   *   <li>When {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   *   <li>Then not {@link DefaultEventLoop#DefaultEventLoop()} Terminated.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}
   */
  @Test
  @DisplayName("Test init(AsyncCallable, long, ScheduledExecutorService); when DefaultEventLoop(); then not DefaultEventLoop() Terminated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScheduledTask.init(AsyncCallable, long, ScheduledExecutorService)"})
  void testInit_whenDefaultEventLoop_thenNotDefaultEventLoopTerminated() {
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
   * Test {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}.
   * <ul>
   *   <li>When {@link io.netty.channel.DefaultEventLoop#DefaultEventLoop()}.</li>
   *   <li>Then not {@link io.netty.channel.DefaultEventLoop#DefaultEventLoop()} Terminated.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#init(AsyncCallable, long, ScheduledExecutorService)}
   */
  @Test
  @DisplayName("Test init(AsyncCallable, long, ScheduledExecutorService); when DefaultEventLoop(); then not DefaultEventLoop() Terminated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScheduledTask.init(AsyncCallable, long, ScheduledExecutorService)"})
  void testInit_whenDefaultEventLoop_thenNotDefaultEventLoopTerminated2() {
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
   * Test {@link ScheduledTask#cancel()}.
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link FutureTask#cancel(boolean)} return {@code true}.</li>
   *   <li>Then calls {@link FutureTask#cancel(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#cancel()}
   */
  @Test
  @DisplayName("Test cancel(); given ListenableFutureTask cancel(boolean) return 'true'; then calls cancel(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScheduledTask.cancel()"})
  void testCancel_givenListenableFutureTaskCancelReturnTrue_thenCallsCancel() {
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
   * Test {@link ScheduledTask#cancel()}.
   * <ul>
   *   <li>Given {@link ScheduledTask} (default constructor).</li>
   *   <li>Then {@link ScheduledTask} (default constructor) Stopped.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#cancel()}
   */
  @Test
  @DisplayName("Test cancel(); given ScheduledTask (default constructor); then ScheduledTask (default constructor) Stopped")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScheduledTask.cancel()"})
  void testCancel_givenScheduledTask_thenScheduledTaskStopped() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();

    // Act
    scheduledTask.cancel();

    // Assert
    assertTrue(scheduledTask.isStopped());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}, and {@link ScheduledTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ScheduledTask#equals(Object)}
   *   <li>{@link ScheduledTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
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
   * Test {@link ScheduledTask#equals(Object)}, and {@link ScheduledTask#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ScheduledTask#equals(Object)}
   *   <li>{@link ScheduledTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();

    // Act and Assert
    assertEquals(scheduledTask, scheduledTask);
    int expectedHashCodeResult = scheduledTask.hashCode();
    assertEquals(expectedHashCodeResult, scheduledTask.hashCode());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), 1);
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    scheduledTask.setStopped(true);

    // Act and Assert
    assertNotEquals(scheduledTask, new ScheduledTask());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
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
   * Test {@link ScheduledTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * Test {@link ScheduledTask#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), null);
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), "Different type to ScheduledTask");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScheduledTask.<init>()", "ListenableFuture ScheduledTask.getScheduledFuture()",
      "boolean ScheduledTask.isStopped()", "void ScheduledTask.setScheduledFuture(ListenableFuture)",
      "void ScheduledTask.setStopped(boolean)", "String ScheduledTask.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ScheduledTask actualScheduledTask = new ScheduledTask();
    actualScheduledTask.setStopped(true);
    String actualToStringResult = actualScheduledTask.toString();
    ListenableFuture<?> actualScheduledFuture = actualScheduledTask.getScheduledFuture();

    // Assert
    assertEquals("ScheduledTask(scheduledFuture=null, stopped=true)", actualToStringResult);
    assertNull(actualScheduledFuture);
    assertTrue(actualScheduledTask.isStopped());
  }
}
