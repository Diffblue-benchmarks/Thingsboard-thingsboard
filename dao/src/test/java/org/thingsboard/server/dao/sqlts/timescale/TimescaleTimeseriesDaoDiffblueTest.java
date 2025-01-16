package org.thingsboard.server.dao.sqlts.timescale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.AggregationParams;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sqlts.timescale.ts.TimescaleTsKvEntity;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueParams;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueWrapper;

public class TimescaleTimeseriesDaoDiffblueTest {
  /**
   * Test {@link TimescaleTimeseriesDao#init()}.
   * <p>
   * Method under test: {@link TimescaleTimeseriesDao#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimescaleTimeseriesDao timescaleTimeseriesDao = new TimescaleTimeseriesDao();

    // Act
    timescaleTimeseriesDao.init();

    // Assert
    TbSqlBlockingQueueWrapper<TimescaleTsKvEntity, Void> tbSqlBlockingQueueWrapper = timescaleTimeseriesDao.tsQueue;
    TbSqlBlockingQueueParams params = tbSqlBlockingQueueWrapper.getParams();
    assertEquals("TS Timescale", params.getLogName());
    assertEquals("ts.timescale", params.getStatsNamePrefix());
    assertNull(tbSqlBlockingQueueWrapper.getStatsFactory());
    assertEquals(0, params.getBatchSize());
    assertEquals(0, tbSqlBlockingQueueWrapper.getMaxThreads());
    assertEquals(0L, params.getMaxDelay());
    assertEquals(0L, params.getStatsPrintIntervalMs());
    assertFalse(params.isBatchSortEnabled());
    assertFalse(params.isWithResponse());
    assertTrue(tbSqlBlockingQueueWrapper.getQueues().isEmpty());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   * with {@code tenantId}, {@code entityId}, {@code queries}.
   * <p>
   * Method under test:
   * {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAllAsyncWithTenantIdEntityIdQueries() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimescaleTimeseriesDao timescaleTimeseriesDao = new TimescaleTimeseriesDao();
    EntityId entityId = mock(EntityId.class);
    ReadTsKvQuery readTsKvQuery = mock(ReadTsKvQuery.class);
    when(readTsKvQuery.getAggregation()).thenThrow(new IllegalArgumentException("foo"));
    when(readTsKvQuery.getAggParameters()).thenReturn(AggregationParams.none());

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(readTsKvQuery);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(readTsKvQuery).getAggParameters();
    verify(readTsKvQuery).getAggregation();
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   * with {@code tenantId}, {@code entityId}, {@code queries}.
   * <ul>
   *   <li>Then calls {@link ReadTsKvQuery#getInterval()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAllAsyncWithTenantIdEntityIdQueries_thenCallsGetInterval() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimescaleTimeseriesDao timescaleTimeseriesDao = new TimescaleTimeseriesDao();
    EntityId entityId = mock(EntityId.class);
    ReadTsKvQuery readTsKvQuery = mock(ReadTsKvQuery.class);
    when(readTsKvQuery.getInterval()).thenThrow(new IllegalArgumentException("foo"));
    when(readTsKvQuery.getEndTs()).thenReturn(1L);
    when(readTsKvQuery.getStartTs()).thenReturn(1L);
    when(readTsKvQuery.getAggregation()).thenReturn(Aggregation.MIN);
    when(readTsKvQuery.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(readTsKvQuery);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(readTsKvQuery).getAggParameters();
    verify(readTsKvQuery).getAggregation();
    verify(readTsKvQuery).getInterval();
    verify(readTsKvQuery).getEndTs();
    verify(readTsKvQuery, atLeast(1)).getStartTs();
  }

  /**
   * Test
   * {@link TimescaleTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimescaleTimeseriesDao#savePartition(TenantId, EntityId, long, String)}
   */
  @Test
  public void testSavePartition_whenAlarmId() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ListenableFuture<Integer> actualSavePartitionResult = (new TimescaleTimeseriesDao())
        .savePartition(ModelConstants.SYSTEM_TENANT, mock(AlarmId.class), 1L, "Key");

    // Assert
    assertEquals(0, actualSavePartitionResult.get().intValue());
    assertTrue(actualSavePartitionResult.isDone());
  }

  /**
   * Test
   * {@link TimescaleTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimescaleTimeseriesDao#savePartition(TenantId, EntityId, long, String)}
   */
  @Test
  public void testSavePartition_whenNull_customer_id() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ListenableFuture<Integer> actualSavePartitionResult = (new TimescaleTimeseriesDao())
        .savePartition(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, "Key");

    // Assert
    assertEquals(0, actualSavePartitionResult.get().intValue());
    assertTrue(actualSavePartitionResult.isDone());
  }
}
