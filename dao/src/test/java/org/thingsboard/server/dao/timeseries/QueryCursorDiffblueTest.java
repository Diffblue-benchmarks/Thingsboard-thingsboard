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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.kv.BaseDeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.TsKvQuery;
import org.thingsboard.server.dao.model.ModelConstants;

public class QueryCursorDiffblueTest {
  /**
   * Test {@link QueryCursor#QueryCursor(String, UUID, TsKvQuery, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link QueryCursor#partitions} Empty.
   * </ul>
   *
   * <p>Method under test: {@link QueryCursor#QueryCursor(String, UUID, TsKvQuery, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueryCursor.<init>(String, UUID, TsKvQuery, List)"})
  public void testNewQueryCursor_whenArrayList_thenReturnPartitionsEmpty() {
    // Arrange
    UUID entityId = ModelConstants.NULL_UUID;
    BaseDeleteTsKvQuery baseQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act
    QueryCursor actualQueryCursor =
        new QueryCursor("Entity Type", entityId, baseQuery, new ArrayList<>());

    // Assert
    assertEquals("Entity Type", actualQueryCursor.getEntityType());
    assertEquals("Key", actualQueryCursor.getKey());
    assertEquals(1L, actualQueryCursor.getEndTs());
    assertEquals(1L, actualQueryCursor.getStartTs());
    assertFalse(actualQueryCursor.hasNextPartition());
    assertTrue(actualQueryCursor.partitions.isEmpty());
    assertSame(entityId, actualQueryCursor.getEntityId());
  }

  /**
   * Test {@link QueryCursor#hasNextPartition()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link QueryCursor#hasNextPartition()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueryCursor.hasNextPartition()"})
  public void testHasNextPartition_givenArrayListAddMinusOne_thenReturnTrue() {
    // Arrange
    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(-1L);
    QueryCursor queryCursor =
        new QueryCursor(
            "Entity Type",
            ModelConstants.NULL_UUID,
            new BaseDeleteTsKvQuery("Key", 1L, 1L),
            partitions);

    // Act and Assert
    assertTrue(queryCursor.hasNextPartition());
  }

  /**
   * Test {@link QueryCursor#hasNextPartition()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link QueryCursor#hasNextPartition()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueryCursor.hasNextPartition()"})
  public void testHasNextPartition_thenReturnFalse() {
    // Arrange
    BaseDeleteTsKvQuery baseQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);
    QueryCursor queryCursor =
        new QueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>());

    // Act and Assert
    assertFalse(queryCursor.hasNextPartition());
  }

  /**
   * Test {@link QueryCursor#getNextPartition()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link QueryCursor#getNextPartition()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long QueryCursor.getNextPartition()"})
  public void testGetNextPartition_givenArrayListAddOne_thenReturnOne() {
    // Arrange
    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(1L);
    QueryCursor queryCursor =
        new QueryCursor(
            "Entity Type",
            ModelConstants.NULL_UUID,
            new BaseDeleteTsKvQuery("Key", 1L, 1L),
            partitions);

    // Act and Assert
    assertEquals(1L, queryCursor.getNextPartition());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueryCursor#getEndTs()}
   *   <li>{@link QueryCursor#getEntityId()}
   *   <li>{@link QueryCursor#getEntityType()}
   *   <li>{@link QueryCursor#getKey()}
   *   <li>{@link QueryCursor#getStartTs()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long QueryCursor.getEndTs()",
    "UUID QueryCursor.getEntityId()",
    "String QueryCursor.getEntityType()",
    "String QueryCursor.getKey()",
    "long QueryCursor.getStartTs()"
  })
  public void testGettersAndSetters() {
    // Arrange
    BaseDeleteTsKvQuery baseQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);
    QueryCursor queryCursor =
        new QueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>());

    // Act
    long actualEndTs = queryCursor.getEndTs();
    UUID actualEntityId = queryCursor.getEntityId();
    String actualEntityType = queryCursor.getEntityType();
    String actualKey = queryCursor.getKey();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("Entity Type", actualEntityType);
    assertEquals("Key", actualKey);
    assertEquals(1L, actualEndTs);
    assertEquals(1L, queryCursor.getStartTs());
  }
}
