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
package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.apache.zookeeper.server.SessionTrackerImpl;
import org.apache.zookeeper.server.ZooKeeperServer;
import org.apache.zookeeper.server.ZooKeeperServerListener;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.scheduling.concurrent.DefaultManagedTaskExecutor;

public class SimpleListenableFutureDiffblueTest {
  /**
   * Test {@link SimpleListenableFuture#set(Object)}.
   *
   * <p>Method under test: {@link SimpleListenableFuture#set(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleListenableFuture.set(Object)"})
  public void testSet() throws InterruptedException, ExecutionException {
    // Arrange
    SimpleListenableFuture<Object> simpleListenableFuture = new SimpleListenableFuture<>();
    ZooKeeperServer expirer = new ZooKeeperServer();
    SessionTrackerImpl listener =
        new SessionTrackerImpl(
            expirer, new ConcurrentHashMap<>(), 4, 1L, mock(ZooKeeperServerListener.class));
    simpleListenableFuture.addListener(listener, new DefaultManagedTaskExecutor());

    // Act
    boolean actualSetResult = simpleListenableFuture.set("Value");

    // Assert
    assertEquals("Value", simpleListenableFuture.get());
    assertTrue(simpleListenableFuture.isDone());
    assertTrue(actualSetResult);
  }

  /**
   * Test {@link SimpleListenableFuture#set(Object)}.
   *
   * <ul>
   *   <li>Given {@link Executor} {@link Executor#execute(Runnable)} does nothing.
   *   <li>Then calls {@link Executor#execute(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleListenableFuture#set(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleListenableFuture.set(Object)"})
  public void testSet_givenExecutorExecuteDoesNothing_thenCallsExecute()
      throws InterruptedException, ExecutionException {
    // Arrange
    Executor executor = mock(Executor.class);
    doNothing().when(executor).execute(Mockito.<Runnable>any());

    SimpleListenableFuture<Object> simpleListenableFuture = new SimpleListenableFuture<>();
    simpleListenableFuture.addListener(mock(Runnable.class), executor);

    // Act
    boolean actualSetResult = simpleListenableFuture.set("Value");

    // Assert
    verify(executor).execute(isA(Runnable.class));
    assertEquals("Value", simpleListenableFuture.get());
    assertTrue(simpleListenableFuture.isDone());
    assertTrue(actualSetResult);
  }

  /**
   * Test {@link SimpleListenableFuture#set(Object)}.
   *
   * <ul>
   *   <li>Given {@link SimpleListenableFuture} (default constructor).
   *   <li>Then {@link SimpleListenableFuture} (default constructor) is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleListenableFuture#set(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleListenableFuture.set(Object)"})
  public void testSet_givenSimpleListenableFuture_thenSimpleListenableFutureIsValue()
      throws InterruptedException, ExecutionException {
    // Arrange
    SimpleListenableFuture<Object> simpleListenableFuture = new SimpleListenableFuture<>();

    // Act
    boolean actualSetResult = simpleListenableFuture.set("Value");

    // Assert
    assertEquals("Value", simpleListenableFuture.get());
    assertTrue(simpleListenableFuture.isDone());
    assertTrue(actualSetResult);
  }
}
