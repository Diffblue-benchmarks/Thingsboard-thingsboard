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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.entity.BaseEntityService;

public class CassandraTsPartitionsCacheDiffblueTest {
  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   *
   * <p>Method under test: {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CassandraTsPartitionsCache.has(CassandraPartitionCacheKey)"})
  public void testHas() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);
    CassandraPartitionCacheKey key =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);
    cassandraTsPartitionsCache.put(key);
    CassandraPartitionCacheKey key2 =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);

    // Act
    boolean actualHasResult = cassandraTsPartitionsCache.has(key2);

    // Assert
    assertTrue(actualHasResult);
  }

  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   *
   * <p>Method under test: {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CassandraTsPartitionsCache.has(CassandraPartitionCacheKey)"})
  public void testHas2() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);
    CassandraPartitionCacheKey key =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 59L);
    cassandraTsPartitionsCache.put(key);
    CassandraPartitionCacheKey key2 =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);
    cassandraTsPartitionsCache.put(key2);
    CassandraPartitionCacheKey key3 =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);

    // Act
    boolean actualHasResult = cassandraTsPartitionsCache.has(key3);

    // Assert
    assertTrue(actualHasResult);
  }

  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   *
   * <p>Method under test: {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CassandraTsPartitionsCache.has(CassandraPartitionCacheKey)"})
  public void testHas3() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);
    CassandraPartitionCacheKey key =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 32L);
    cassandraTsPartitionsCache.put(key);
    CassandraPartitionCacheKey key2 =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);
    cassandraTsPartitionsCache.put(key2);
    CassandraPartitionCacheKey key3 =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);

    // Act
    boolean actualHasResult = cassandraTsPartitionsCache.has(key3);

    // Assert
    assertTrue(actualHasResult);
  }

  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   *
   * <p>Method under test: {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CassandraTsPartitionsCache.has(CassandraPartitionCacheKey)"})
  public void testHas4() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache =
        new CassandraTsPartitionsCache(Long.MAX_VALUE);
    CassandraPartitionCacheKey key =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);
    cassandraTsPartitionsCache.put(key);
    CassandraPartitionCacheKey key2 =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);

    // Act
    boolean actualHasResult = cassandraTsPartitionsCache.has(key2);

    // Assert
    assertTrue(actualHasResult);
  }

  /**
   * Test {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}.
   *
   * <ul>
   *   <li>Given {@link CassandraTsPartitionsCache#CassandraTsPartitionsCache(long)} with
   *       maxCacheSize is three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CassandraTsPartitionsCache.has(CassandraPartitionCacheKey)"})
  public void testHas_givenCassandraTsPartitionsCacheWithMaxCacheSizeIsThree_thenReturnFalse() {
    // Arrange
    CassandraTsPartitionsCache cassandraTsPartitionsCache = new CassandraTsPartitionsCache(3L);
    CassandraPartitionCacheKey key =
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);

    // Act
    boolean actualHasResult = cassandraTsPartitionsCache.has(key);

    // Assert
    assertFalse(actualHasResult);
  }
}
