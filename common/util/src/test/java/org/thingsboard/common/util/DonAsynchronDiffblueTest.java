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

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DonAsynchronDiffblueTest {
  /**
   * Method under test:
   * {@link DonAsynchron#withCallback(ListenableFuture, Consumer, Consumer)}
   */
  @Test
  void testWithCallback() {
    // Arrange
    ListenableFutureTask<Object> future = mock(ListenableFutureTask.class);
    doNothing().when(future).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    DonAsynchron.withCallback(future, mock(Consumer.class), mock(Consumer.class));

    // Assert
    verify(future).addListener(isA(Runnable.class), isA(Executor.class));
  }

  /**
   * Method under test:
   * {@link DonAsynchron#withCallback(ListenableFuture, Consumer, Consumer, Executor)}
   */
  @Test
  void testWithCallback2() {
    // Arrange
    ListenableFutureTask<Object> future = mock(ListenableFutureTask.class);
    doNothing().when(future).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    DonAsynchron.withCallback(future, mock(Consumer.class), mock(Consumer.class), mock(Executor.class));

    // Assert
    verify(future).addListener(isA(Runnable.class), isA(Executor.class));
  }

  /**
   * Method under test:
   * {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor)}
   */
  @Test
  void testSubmit() {
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

  /**
   * Method under test:
   * {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor, Executor)}
   */
  @Test
  void testSubmit2() {
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
   * Method under test:
   * {@link DonAsynchron#submit(Callable, Consumer, Consumer, Executor, Executor)}
   */
  @Test
  void testSubmit3() {
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
}
