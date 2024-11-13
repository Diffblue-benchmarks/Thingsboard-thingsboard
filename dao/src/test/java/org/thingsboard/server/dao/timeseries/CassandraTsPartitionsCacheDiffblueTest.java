package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.thingsboard.server.dao.entity.BaseEntityService;

public class CassandraTsPartitionsCacheDiffblueTest {
  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   * <p>
   * Method under test:
   * {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  public void testHas() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);
    cassandraTsPartitionsCache.put(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID,
        "org.thingsboard.server.dao.timeseries.CassandraPartitionCacheKey", 59L));

    // Act and Assert
    assertFalse(
        cassandraTsPartitionsCache.has(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L)));
  }

  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   * <ul>
   *   <li>Given {@link CassandraTsPartitionsCache#CassandraTsPartitionsCache(long)}
   * with maxCacheSize is three.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  public void testHas_givenCassandraTsPartitionsCacheWithMaxCacheSizeIsThree_thenReturnFalse() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);

    // Act and Assert
    assertFalse(
        cassandraTsPartitionsCache.has(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L)));
  }

  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  public void testHas_thenReturnTrue() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);
    cassandraTsPartitionsCache.put(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L));

    // Act and Assert
    assertTrue(
        cassandraTsPartitionsCache.has(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L)));
  }

  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   * <ul>
   *   <li>When
   * {@link CassandraPartitionCacheKey#CassandraPartitionCacheKey(EntityId, String, long)}
   * with entityId is {@code null} and {@code Key} and partition is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  public void testHas_whenCassandraPartitionCacheKeyWithEntityIdIsNullAndKeyAndPartitionIsOne() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);
    cassandraTsPartitionsCache.put(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID,
        "org.thingsboard.server.dao.timeseries.CassandraPartitionCacheKey", 59L));

    // Act and Assert
    assertFalse(cassandraTsPartitionsCache.has(new CassandraPartitionCacheKey(null, "Key", 1L)));
  }
}
