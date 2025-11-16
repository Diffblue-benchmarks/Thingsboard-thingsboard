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
package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import org.awaitility.core.FieldSupplierBuilder;
import org.awaitility.core.FieldSupplierBuilder.NameAndTypeFieldSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.task.SyncTaskExecutor;

class DonAsynchronDiffblueTest {
  /**
   * Test {@link DonAsynchron#withCallback(ListenableFuture, Consumer, Consumer, Executor)} with
   * {@code future}, {@code onSuccess}, {@code onFailure}, {@code executor}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link DonAsynchron#withCallback(ListenableFuture, Consumer, Consumer,
   * Executor)}
   */
  @Test
  @DisplayName(
      "Test withCallback(ListenableFuture, Consumer, Consumer, Executor) with 'future', 'onSuccess', 'onFailure', 'executor'; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DonAsynchron.withCallback(ListenableFuture, Consumer, Consumer, Executor)"
  })
  void testWithCallbackWithFutureOnSuccessOnFailureExecutor_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Object> future = mock(ListenableFutureTask.class);
    doNothing().when(future).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    DonAsynchron.withCallback(
        future, mock(Consumer.class), mock(Consumer.class), mock(Executor.class));

    // Assert
    verify(future).addListener(isA(Runnable.class), isA(Executor.class));
  }

  /**
   * Test {@link DonAsynchron#withCallback(ListenableFuture, Consumer, Consumer)} with {@code
   * future}, {@code onSuccess}, {@code onFailure}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link DonAsynchron#withCallback(ListenableFuture, Consumer, Consumer)}
   */
  @Test
  @DisplayName(
      "Test withCallback(ListenableFuture, Consumer, Consumer) with 'future', 'onSuccess', 'onFailure'; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DonAsynchron.withCallback(ListenableFuture, Consumer, Consumer)"})
  void testWithCallbackWithFutureOnSuccessOnFailure_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Object> future = mock(ListenableFutureTask.class);
    doNothing().when(future).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    DonAsynchron.withCallback(future, mock(Consumer.class), mock(Consumer.class));

    // Assert
    verify(future).addListener(isA(Runnable.class), isA(Executor.class));
  }

  /**
   * Test {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor, Executor)} with {@code
   * task}, {@code onSuccess}, {@code onFailure}, {@code executor}, {@code callbackExecutor}.
   *
   * <ul>
   *   <li>Then calls {@link Executor#execute(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor,
   * Executor)}
   */
  @Test
  @DisplayName(
      "Test submit(Callable, Consumer, Consumer, Executor, Executor) with 'task', 'onSuccess', 'onFailure', 'executor', 'callbackExecutor'; then calls execute(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DonAsynchron.submit(Callable, Consumer, Consumer, Executor, Executor)"
  })
  void testSubmitWithTaskOnSuccessOnFailureExecutorCallbackExecutor_thenCallsExecute() {
    // Arrange
    Callable<Object> task = mock(Callable.class);
    Consumer<Object> onSuccess = mock(Consumer.class);
    Consumer<Throwable> onFailure = mock(Consumer.class);

    Executor executor = mock(Executor.class);
    doNothing().when(executor).execute(Mockito.<Runnable>any());

    // Act
    DonAsynchron.submit(task, onSuccess, onFailure, executor, mock(Executor.class));

    // Assert
    verify(executor).execute(isA(Runnable.class));
  }

  /**
   * Test {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor, Executor)} with {@code
   * task}, {@code onSuccess}, {@code onFailure}, {@code executor}, {@code callbackExecutor}.
   *
   * <ul>
   *   <li>Then calls {@link Executor#execute(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor,
   * Executor)}
   */
  @Test
  @DisplayName(
      "Test submit(Callable, Consumer, Consumer, Executor, Executor) with 'task', 'onSuccess', 'onFailure', 'executor', 'callbackExecutor'; then calls execute(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DonAsynchron.submit(Callable, Consumer, Consumer, Executor, Executor)"
  })
  void testSubmitWithTaskOnSuccessOnFailureExecutorCallbackExecutor_thenCallsExecute2() {
    // Arrange
    Callable<Object> task = mock(Callable.class);
    Consumer<Object> onSuccess = mock(Consumer.class);
    Consumer<Throwable> onFailure = mock(Consumer.class);

    Executor executor = mock(Executor.class);
    doNothing().when(executor).execute(Mockito.<Runnable>any());

    // Act
    DonAsynchron.submit(task, onSuccess, onFailure, executor, null);

    // Assert
    verify(executor).execute(isA(Runnable.class));
  }

  /**
   * Test {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor)} with {@code task},
   * {@code onSuccess}, {@code onFailure}, {@code executor}.
   *
   * <ul>
   *   <li>Given {@code Call}.
   *   <li>Then return {@link ListenableFuture#get()} is {@code Call}.
   * </ul>
   *
   * <p>Method under test: {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor)}
   */
  @Test
  @DisplayName(
      "Test submit(Callable, Consumer, Consumer, Executor) with 'task', 'onSuccess', 'onFailure', 'executor'; given 'Call'; then return get() is 'Call'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DonAsynchron.submit(Callable, Consumer, Consumer, Executor)"
  })
  void testSubmitWithTaskOnSuccessOnFailureExecutor_givenCall_thenReturnGetIsCall()
      throws Exception {
    // Arrange
    Callable<Object> task = mock(Callable.class);
    when(task.call()).thenReturn("Call");

    Consumer<Object> onSuccess = mock(Consumer.class);
    doNothing().when(onSuccess).accept(Mockito.<Object>any());
    Consumer<Throwable> onFailure = mock(Consumer.class);

    // Act
    ListenableFuture<Object> actualSubmitResult =
        DonAsynchron.submit(task, onSuccess, onFailure, new SyncTaskExecutor());

    // Assert
    verify(task).call();
    verify(onSuccess).accept(isA(Object.class));
    assertEquals("Call", actualSubmitResult.get());
    assertTrue(actualSubmitResult.isDone());
  }

  /**
   * Test {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor)} with {@code task},
   * {@code onSuccess}, {@code onFailure}, {@code executor}.
   *
   * <ul>
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor)}
   */
  @Test
  @DisplayName(
      "Test submit(Callable, Consumer, Consumer, Executor) with 'task', 'onSuccess', 'onFailure', 'executor'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DonAsynchron.submit(Callable, Consumer, Consumer, Executor)"
  })
  void testSubmitWithTaskOnSuccessOnFailureExecutor_thenCallsAccept() {
    // Arrange
    NameAndTypeFieldSupplier<Object> task =
        new FieldSupplierBuilder("Object").new NameAndTypeFieldSupplier();
    Consumer<Object> onSuccess = mock(Consumer.class);

    Consumer<Throwable> onFailure = mock(Consumer.class);
    doNothing().when(onFailure).accept(Mockito.<Throwable>any());

    // Act
    ListenableFuture<Object> actualSubmitResult =
        DonAsynchron.submit(task, onSuccess, onFailure, new SyncTaskExecutor());

    // Assert
    verify(onFailure).accept(isA(Throwable.class));
    assertTrue(actualSubmitResult.isDone());
  }

  /**
   * Test {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor)} with {@code task},
   * {@code onSuccess}, {@code onFailure}, {@code executor}.
   *
   * <ul>
   *   <li>When {@link Callable}.
   *   <li>Then calls {@link Executor#execute(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor)}
   */
  @Test
  @DisplayName(
      "Test submit(Callable, Consumer, Consumer, Executor) with 'task', 'onSuccess', 'onFailure', 'executor'; when Callable; then calls execute(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DonAsynchron.submit(Callable, Consumer, Consumer, Executor)"
  })
  void testSubmitWithTaskOnSuccessOnFailureExecutor_whenCallable_thenCallsExecute() {
    // Arrange
    Callable<Object> task = mock(Callable.class);
    Consumer<Object> onSuccess = mock(Consumer.class);
    Consumer<Throwable> onFailure = mock(Consumer.class);

    Executor executor = mock(Executor.class);
    doNothing().when(executor).execute(Mockito.<Runnable>any());

    // Act
    DonAsynchron.submit(task, onSuccess, onFailure, executor);

    // Assert
    verify(executor).execute(isA(Runnable.class));
  }
}
