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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.TsKvEntryAggWrapper;

public class AggregatePartitionsFunctionDiffblueTest {
  /**
   * Test {@link AggregatePartitionsFunction#AggregatePartitionsFunction(Aggregation, String, long,
   * Executor)}.
   *
   * <p>Method under test: {@link
   * AggregatePartitionsFunction#AggregatePartitionsFunction(Aggregation, String, long, Executor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AggregatePartitionsFunction.<init>(Aggregation, String, long, Executor)"
  })
  public void testNewAggregatePartitionsFunction() throws InterruptedException, ExecutionException {
    // Arrange and Act
    AggregatePartitionsFunction actualAggregatePartitionsFunction =
        new AggregatePartitionsFunction(Aggregation.MIN, "Key", 1L, mock(Executor.class));
    ListenableFuture<Optional<TsKvEntryAggWrapper>> actualApplyResult =
        actualAggregatePartitionsFunction.apply(new ArrayList<>());

    // Assert
    assertFalse(actualApplyResult.get().isPresent());
    assertTrue(actualApplyResult.isDone());
  }

  /**
   * Test {@link AggregatePartitionsFunction#apply(List)} with {@code List}.
   *
   * <p>Method under test: {@link AggregatePartitionsFunction#apply(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture AggregatePartitionsFunction.apply(List)"})
  public void testApplyWithList() throws InterruptedException, ExecutionException {
    // Arrange
    AggregatePartitionsFunction aggregatePartitionsFunction =
        new AggregatePartitionsFunction(Aggregation.MIN, "Key", 1L, mock(Executor.class));

    // Act
    ListenableFuture<Optional<TsKvEntryAggWrapper>> actualApplyResult =
        aggregatePartitionsFunction.apply(new ArrayList<>());

    // Assert
    assertFalse(actualApplyResult.get().isPresent());
    assertTrue(actualApplyResult.isDone());
  }
}
