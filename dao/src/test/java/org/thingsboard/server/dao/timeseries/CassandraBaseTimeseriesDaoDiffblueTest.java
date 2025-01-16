package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AggregationParams;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.ReadTsKvQueryResult;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class CassandraBaseTimeseriesDaoDiffblueTest {
  /**
   * Test
   * {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   * with {@code tenantId}, {@code entityId}, {@code queries}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAllAsyncWithTenantIdEntityIdQueries_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();
    ReadTsKvQuery readTsKvQuery = mock(ReadTsKvQuery.class);
    when(readTsKvQuery.getStartTs()).thenThrow(new RuntimeException("foo"));
    when(readTsKvQuery.getAggParameters()).thenReturn(AggregationParams.none());

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(readTsKvQuery);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> cassandraBaseTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, queries));
    verify(readTsKvQuery).getAggParameters();
    verify(readTsKvQuery).getStartTs();
  }

  /**
   * Test
   * {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   * with {@code tenantId}, {@code entityId}, {@code queries}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAllAsyncWithTenantIdEntityIdQueries_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllAsyncResult = cassandraBaseTimeseriesDao
        .findAllAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    assertTrue(actualFindAllAsyncResult.get().isEmpty());
    assertTrue(actualFindAllAsyncResult.isDone());
  }

  /**
   * Test
   * {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   * with {@code tenantId}, {@code entityId}, {@code queries}.
   * <ul>
   *   <li>When {@link EntityId}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAllAsyncWithTenantIdEntityIdQueries_whenEntityId_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();
    EntityId entityId = mock(EntityId.class);

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllAsyncResult = cassandraBaseTimeseriesDao
        .findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, new ArrayList<>());

    // Assert
    assertTrue(actualFindAllAsyncResult.get().isEmpty());
    assertTrue(actualFindAllAsyncResult.isDone());
  }

  /**
   * Test
   * {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)}
   * with {@code tenantId}, {@code entityId}, {@code query}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)}
   */
  @Test
  public void testFindAllAsyncWithTenantIdEntityIdQuery_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();
    ReadTsKvQuery query = mock(ReadTsKvQuery.class);
    when(query.getStartTs()).thenThrow(new RuntimeException("foo"));
    when(query.getAggParameters()).thenReturn(AggregationParams.none());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> cassandraBaseTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(query).getAggParameters();
    verify(query).getStartTs();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraBaseTimeseriesDao#cleanup(long)}
   *   <li>{@link CassandraBaseTimeseriesDao#getPartitioning()}
   *   <li>{@link CassandraBaseTimeseriesDao#isUseTsKeyValuePartitioningOnRead()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    // Act
    cassandraBaseTimeseriesDao.cleanup(1L);
    cassandraBaseTimeseriesDao.getPartitioning();

    // Assert that nothing has changed
    assertFalse(cassandraBaseTimeseriesDao.isUseTsKeyValuePartitioningOnRead());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}
   */
  @Test
  public void testCalculatePartitions_whenMax_value_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<Long> actualCalculatePartitionsResult = (new CassandraBaseTimeseriesDao()).calculatePartitions(Long.MAX_VALUE,
        1L);

    // Assert
    assertEquals(1, actualCalculatePartitionsResult.size());
    assertEquals(1L, actualCalculatePartitionsResult.get(0).longValue());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}
   */
  @Test
  public void testCalculatePartitions_whenOne_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<Long> actualCalculatePartitionsResult = (new CassandraBaseTimeseriesDao()).calculatePartitions(1L, 1L);

    // Assert
    assertEquals(1, actualCalculatePartitionsResult.size());
    assertEquals(1L, actualCalculatePartitionsResult.get(0).longValue());
  }
}
