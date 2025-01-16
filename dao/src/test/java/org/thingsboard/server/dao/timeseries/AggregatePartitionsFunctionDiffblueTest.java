package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.junit.Test;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.TsKvEntryAggWrapper;

public class AggregatePartitionsFunctionDiffblueTest {
  /**
   * Test
   * {@link AggregatePartitionsFunction#AggregatePartitionsFunction(Aggregation, String, long, Executor)}.
   * <p>
   * Method under test:
   * {@link AggregatePartitionsFunction#AggregatePartitionsFunction(Aggregation, String, long, Executor)}
   */
  @Test
  public void testNewAggregatePartitionsFunction() throws InterruptedException, ExecutionException {
    // Arrange and Act
    AggregatePartitionsFunction actualAggregatePartitionsFunction = new AggregatePartitionsFunction(Aggregation.MIN,
        "Key", 1L, mock(Executor.class));
    ListenableFuture<Optional<TsKvEntryAggWrapper>> actualApplyResult = actualAggregatePartitionsFunction
        .apply(new ArrayList<>());

    // Assert
    assertFalse(actualApplyResult.get().isPresent());
    assertTrue(actualApplyResult.isDone());
  }

  /**
   * Test {@link AggregatePartitionsFunction#apply(List)} with {@code List}.
   * <p>
   * Method under test: {@link AggregatePartitionsFunction#apply(List)}
   */
  @Test
  public void testApplyWithList() throws InterruptedException, ExecutionException {
    // Arrange
    AggregatePartitionsFunction aggregatePartitionsFunction = new AggregatePartitionsFunction(Aggregation.MIN, "Key",
        1L, mock(Executor.class));

    // Act
    ListenableFuture<Optional<TsKvEntryAggWrapper>> actualApplyResult = aggregatePartitionsFunction
        .apply(new ArrayList<>());

    // Assert
    assertFalse(actualApplyResult.get().isPresent());
    assertTrue(actualApplyResult.isDone());
  }
}
