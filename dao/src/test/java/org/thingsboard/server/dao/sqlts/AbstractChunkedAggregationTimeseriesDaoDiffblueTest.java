package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.AggregationParams;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.IntervalType;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sqlts.sql.JpaSqlTimeseriesDao;

public class AbstractChunkedAggregationTimeseriesDaoDiffblueTest {
  /**
   * Test
   * {@link AbstractChunkedAggregationTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractChunkedAggregationTimeseriesDao#savePartition(TenantId, EntityId, long, String)}
   */
  @Test
  public void testSavePartition_whenAlarmId() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ListenableFuture<Integer> actualSavePartitionResult = (new JpaSqlTimeseriesDao())
        .savePartition(ModelConstants.SYSTEM_TENANT, mock(AlarmId.class), 1L, "Key");

    // Assert
    assertNull(actualSavePartitionResult.get());
    assertTrue(actualSavePartitionResult.isDone());
  }

  /**
   * Test
   * {@link AbstractChunkedAggregationTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractChunkedAggregationTimeseriesDao#savePartition(TenantId, EntityId, long, String)}
   */
  @Test
  public void testSavePartition_whenNull_customer_id() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ListenableFuture<Integer> actualSavePartitionResult = (new JpaSqlTimeseriesDao())
        .savePartition(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, "Key");

    // Assert
    assertNull(actualSavePartitionResult.get());
    assertTrue(actualSavePartitionResult.isDone());
  }

  /**
   * Test
   * {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)}
   * with {@code tenantId}, {@code entityId}, {@code query}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)}
   */
  @Test
  public void testFindAllAsyncWithTenantIdEntityIdQuery_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();
    AggregationParams aggregationParams = mock(AggregationParams.class);
    when(aggregationParams.getInterval()).thenThrow(new IllegalArgumentException("foo"));
    when(aggregationParams.getAggregation()).thenReturn(Aggregation.MIN);
    when(aggregationParams.getIntervalType()).thenReturn(IntervalType.MILLISECONDS);
    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(aggregationParams);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jpaSqlTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(aggregationParams).getAggregation();
    verify(aggregationParams).getInterval();
    verify(aggregationParams).getIntervalType();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query, atLeast(1)).getStartTs();
  }
}
