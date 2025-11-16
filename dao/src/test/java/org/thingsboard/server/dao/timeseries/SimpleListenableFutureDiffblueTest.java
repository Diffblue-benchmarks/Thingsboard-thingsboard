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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SimpleListenableFutureDiffblueTest {
  @Mock private Object object;

  @InjectMocks private SimpleListenableFuture<Object> simpleListenableFuture;

  /**
   * Test {@link SimpleListenableFuture#set(Object)}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleListenableFuture#set(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleListenableFuture.set(Object)"})
  public void testSet_givenObject_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(simpleListenableFuture.set("Value"));
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
