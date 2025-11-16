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
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsKvQueryCursorDiffblueTest {
  /**
   * Test {@link TsKvQueryCursor#TsKvQueryCursor(String, UUID, ReadTsKvQuery, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return {@link QueryCursor#partitions} size is one.
   * </ul>
   *
   * <p>Method under test: {@link TsKvQueryCursor#TsKvQueryCursor(String, UUID, ReadTsKvQuery,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvQueryCursor.<init>(String, UUID, ReadTsKvQuery, List)"})
  public void testNewTsKvQueryCursor_givenOne_thenReturnPartitionsSizeIsOne() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(1L);

    // Act
    TsKvQueryCursor actualTsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, partitions);

    // Assert
    assertEquals("Key", actualTsKvQueryCursor.getKey());
    List<Long> resultLongList = actualTsKvQueryCursor.partitions;
    assertEquals(1, resultLongList.size());
    assertEquals(1L, resultLongList.get(0).longValue());
    assertEquals(AbstractCassandraBaseTimeseriesDao.DESC_ORDER, actualTsKvQueryCursor.getOrderBy());
  }

  /**
   * Test {@link TsKvQueryCursor#TsKvQueryCursor(String, UUID, ReadTsKvQuery, List)}.
   *
   * <ul>
   *   <li>Then return {@code Entity Type}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvQueryCursor#TsKvQueryCursor(String, UUID, ReadTsKvQuery,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvQueryCursor.<init>(String, UUID, ReadTsKvQuery, List)"})
  public void testNewTsKvQueryCursor_thenReturnEntityType() {
    // Arrange
    UUID entityId = ModelConstants.NULL_UUID;
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act
    TsKvQueryCursor actualTsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", entityId, baseQuery, new ArrayList<>());

    // Assert
    assertEquals("Entity Type", actualTsKvQueryCursor.getEntityType());
    assertEquals("Key", actualTsKvQueryCursor.getKey());
    assertEquals(1, actualTsKvQueryCursor.getCurrentLimit());
    assertEquals(1L, actualTsKvQueryCursor.getEndTs());
    assertEquals(1L, actualTsKvQueryCursor.getStartTs());
    assertFalse(actualTsKvQueryCursor.hasNextPartition());
    assertFalse(actualTsKvQueryCursor.isFull());
    assertTrue(actualTsKvQueryCursor.getData().isEmpty());
    assertTrue(actualTsKvQueryCursor.partitions.isEmpty());
    assertEquals(AbstractCassandraBaseTimeseriesDao.DESC_ORDER, actualTsKvQueryCursor.getOrderBy());
    assertSame(entityId, actualTsKvQueryCursor.getEntityId());
  }

  /**
   * Test {@link TsKvQueryCursor#TsKvQueryCursor(String, UUID, ReadTsKvQuery, List)}.
   *
   * <ul>
   *   <li>Then return OrderBy is {@code Order}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvQueryCursor#TsKvQueryCursor(String, UUID, ReadTsKvQuery,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvQueryCursor.<init>(String, UUID, ReadTsKvQuery, List)"})
  public void testNewTsKvQueryCursor_thenReturnOrderByIsOrder() {
    // Arrange
    UUID entityId = ModelConstants.NULL_UUID;
    BaseReadTsKvQuery baseQuery =
        new BaseReadTsKvQuery(AbstractCassandraBaseTimeseriesDao.DESC_ORDER, 1L, 1L, 1, "Order");

    // Act
    TsKvQueryCursor actualTsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", entityId, baseQuery, new ArrayList<>());

    // Assert
    assertEquals("Entity Type", actualTsKvQueryCursor.getEntityType());
    assertEquals("Order", actualTsKvQueryCursor.getOrderBy());
    assertEquals(1, actualTsKvQueryCursor.getCurrentLimit());
    assertEquals(1L, actualTsKvQueryCursor.getEndTs());
    assertEquals(1L, actualTsKvQueryCursor.getStartTs());
    assertFalse(actualTsKvQueryCursor.hasNextPartition());
    assertFalse(actualTsKvQueryCursor.isFull());
    assertTrue(actualTsKvQueryCursor.getData().isEmpty());
    assertTrue(actualTsKvQueryCursor.partitions.isEmpty());
    assertEquals(AbstractCassandraBaseTimeseriesDao.DESC_ORDER, actualTsKvQueryCursor.getKey());
    assertSame(entityId, actualTsKvQueryCursor.getEntityId());
  }

  /**
   * Test {@link TsKvQueryCursor#hasNextPartition()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add five.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvQueryCursor#hasNextPartition()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvQueryCursor.hasNextPartition()"})
  public void testHasNextPartition_givenArrayListAddFive_thenReturnTrue() {
    // Arrange
    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(5L);
    TsKvQueryCursor tsKvQueryCursor =
        new TsKvQueryCursor(
            "Entity Type",
            ModelConstants.NULL_UUID,
            new BaseReadTsKvQuery("Key", 1L, 1L),
            partitions);

    // Act and Assert
    assertTrue(tsKvQueryCursor.hasNextPartition());
  }

  /**
   * Test {@link TsKvQueryCursor#hasNextPartition()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvQueryCursor#hasNextPartition()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvQueryCursor.hasNextPartition()"})
  public void testHasNextPartition_thenReturnFalse() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);
    TsKvQueryCursor tsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>());

    // Act and Assert
    assertFalse(tsKvQueryCursor.hasNextPartition());
  }

  /**
   * Test {@link TsKvQueryCursor#isFull()}.
   *
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvQueryCursor#isFull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvQueryCursor.isFull()"})
  public void testIsFull_givenJsonDataEntryWithKeyAndValueIs42_thenReturnTrue() {
    // Arrange
    ArrayList<TsKvEntry> newData = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    newData.add(basicTsKvEntry);
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    TsKvQueryCursor tsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>());
    tsKvQueryCursor.addData(newData);

    // Act and Assert
    assertTrue(tsKvQueryCursor.isFull());
  }

  /**
   * Test {@link TsKvQueryCursor#isFull()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvQueryCursor#isFull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvQueryCursor.isFull()"})
  public void testIsFull_thenReturnFalse() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);
    TsKvQueryCursor tsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>());

    // Act and Assert
    assertFalse(tsKvQueryCursor.isFull());
  }

  /**
   * Test {@link TsKvQueryCursor#getNextPartition()}.
   *
   * <p>Method under test: {@link TsKvQueryCursor#getNextPartition()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TsKvQueryCursor.getNextPartition()"})
  public void testGetNextPartition() {
    // Arrange
    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(1L);
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L, 1, "Order");

    TsKvQueryCursor tsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, partitions);

    // Act and Assert
    assertEquals(1L, tsKvQueryCursor.getNextPartition());
  }

  /**
   * Test {@link TsKvQueryCursor#getNextPartition()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TsKvQueryCursor#getNextPartition()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TsKvQueryCursor.getNextPartition()"})
  public void testGetNextPartition_givenArrayListAddOne_thenReturnOne() {
    // Arrange
    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(1L);
    TsKvQueryCursor tsKvQueryCursor =
        new TsKvQueryCursor(
            "Entity Type",
            ModelConstants.NULL_UUID,
            new BaseReadTsKvQuery("Key", 1L, 1L),
            partitions);

    // Act and Assert
    assertEquals(1L, tsKvQueryCursor.getNextPartition());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvQueryCursor#getCurrentLimit()}
   *   <li>{@link TsKvQueryCursor#getData()}
   *   <li>{@link TsKvQueryCursor#getOrderBy()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int TsKvQueryCursor.getCurrentLimit()",
    "List TsKvQueryCursor.getData()",
    "String TsKvQueryCursor.getOrderBy()"
  })
  public void testGettersAndSetters() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);
    TsKvQueryCursor tsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>());

    // Act
    int actualCurrentLimit = tsKvQueryCursor.getCurrentLimit();
    List<TsKvEntry> actualData = tsKvQueryCursor.getData();
    String actualOrderBy = tsKvQueryCursor.getOrderBy();

    // Assert
    assertEquals(1, actualCurrentLimit);
    assertTrue(actualData.isEmpty());
    assertEquals(AbstractCassandraBaseTimeseriesDao.DESC_ORDER, actualOrderBy);
  }

  /**
   * Test {@link TsKvQueryCursor#addData(List)}.
   *
   * <p>Method under test: {@link TsKvQueryCursor#addData(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvQueryCursor.addData(List)"})
  public void testAddData() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);
    TsKvQueryCursor tsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>());

    // Act
    tsKvQueryCursor.addData(new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(1, tsKvQueryCursor.getCurrentLimit());
    assertFalse(tsKvQueryCursor.isFull());
    assertTrue(tsKvQueryCursor.getData().isEmpty());
  }

  /**
   * Test {@link TsKvQueryCursor#addData(List)}.
   *
   * <p>Method under test: {@link TsKvQueryCursor#addData(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvQueryCursor.addData(List)"})
  public void testAddData2() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);
    TsKvQueryCursor tsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>());

    ArrayList<TsKvEntry> newData = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    newData.add(basicTsKvEntry);

    // Act
    tsKvQueryCursor.addData(newData);

    // Assert
    assertEquals(0, tsKvQueryCursor.getCurrentLimit());
    List<TsKvEntry> data = tsKvQueryCursor.getData();
    assertEquals(1, data.size());
    assertTrue(tsKvQueryCursor.isFull());
    assertSame(basicTsKvEntry, data.get(0));
  }

  /**
   * Test {@link TsKvQueryCursor#addData(List)}.
   *
   * <p>Method under test: {@link TsKvQueryCursor#addData(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvQueryCursor.addData(List)"})
  public void testAddData3() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);
    TsKvQueryCursor tsKvQueryCursor =
        new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>());

    ArrayList<TsKvEntry> newData = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    newData.add(basicTsKvEntry);
    BasicTsKvEntry basicTsKvEntry2 = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    newData.add(basicTsKvEntry2);

    // Act
    tsKvQueryCursor.addData(newData);

    // Assert
    assertEquals(-1, tsKvQueryCursor.getCurrentLimit());
    assertTrue(tsKvQueryCursor.isFull());
    assertEquals(newData, tsKvQueryCursor.getData());
  }
}
