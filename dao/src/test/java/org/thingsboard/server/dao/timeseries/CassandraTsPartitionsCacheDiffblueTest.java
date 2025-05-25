package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.entity.BaseEntityService;

public class CassandraTsPartitionsCacheDiffblueTest {
  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   * <p>
   * Method under test: {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraTsPartitionsCache.has(CassandraPartitionCacheKey)"})
  public void testHas() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);
    cassandraTsPartitionsCache.put(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "42", 59L));

    // Act and Assert
    assertFalse(
        cassandraTsPartitionsCache.has(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L)));
  }

  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   * <p>
   * Method under test: {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraTsPartitionsCache.has(CassandraPartitionCacheKey)"})
  public void testHas2() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);
    cassandraTsPartitionsCache
        .put(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", Long.MAX_VALUE));
    cassandraTsPartitionsCache.put(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L));

    // Act and Assert
    assertTrue(
        cassandraTsPartitionsCache.has(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L)));
  }

  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   * <ul>
   *   <li>Given {@link CassandraTsPartitionsCache#CassandraTsPartitionsCache(long)} with maxCacheSize is three.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraTsPartitionsCache.has(CassandraPartitionCacheKey)"})
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
   * Method under test: {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraTsPartitionsCache.has(CassandraPartitionCacheKey)"})
  public void testHas_thenReturnTrue() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);
    cassandraTsPartitionsCache.put(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L));

    // Act and Assert
    assertTrue(
        cassandraTsPartitionsCache.has(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L)));
  }
}
