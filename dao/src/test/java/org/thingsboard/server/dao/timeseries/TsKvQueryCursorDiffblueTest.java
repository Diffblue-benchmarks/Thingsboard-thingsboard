package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsKvQueryCursorDiffblueTest {
  /**
   * Test
   * {@link TsKvQueryCursor#TsKvQueryCursor(String, UUID, ReadTsKvQuery, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link QueryCursor#partitions} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvQueryCursor#TsKvQueryCursor(String, UUID, ReadTsKvQuery, List)}
   */
  @Test
  public void testNewTsKvQueryCursor_whenArrayList_thenReturnPartitionsEmpty() {
    // Arrange
    UUID entityId = ModelConstants.NULL_UUID;
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act
    TsKvQueryCursor actualTsKvQueryCursor = new TsKvQueryCursor("Entity Type", entityId, baseQuery, new ArrayList<>());

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
   * Test {@link TsKvQueryCursor#hasNextPartition()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add five.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvQueryCursor#hasNextPartition()}
   */
  @Test
  public void testHasNextPartition_givenArrayListAddFive_thenReturnTrue() {
    // Arrange
    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(5L);

    // Act and Assert
    assertTrue(
        (new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, new BaseReadTsKvQuery("Key", 1L, 1L), partitions))
            .hasNextPartition());
  }

  /**
   * Test {@link TsKvQueryCursor#hasNextPartition()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvQueryCursor#hasNextPartition()}
   */
  @Test
  public void testHasNextPartition_thenReturnFalse() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertFalse((new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>()))
        .hasNextPartition());
  }

  /**
   * Test {@link TsKvQueryCursor#isFull()}.
   * <p>
   * Method under test: {@link TsKvQueryCursor#isFull()}
   */
  @Test
  public void testIsFull() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertFalse((new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery, new ArrayList<>())).isFull());
  }

  /**
   * Test {@link TsKvQueryCursor#getNextPartition()}.
   * <p>
   * Method under test: {@link TsKvQueryCursor#getNextPartition()}
   */
  @Test
  public void testGetNextPartition() {
    // Arrange
    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(1L);

    // Act and Assert
    assertEquals(1L, (new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID,
        new BaseReadTsKvQuery("Key", 1L, 1L, 1, "Order"), partitions)).getNextPartition());
  }

  /**
   * Test {@link TsKvQueryCursor#getNextPartition()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvQueryCursor#getNextPartition()}
   */
  @Test
  public void testGetNextPartition_givenArrayListAddOne_thenReturnOne() {
    // Arrange
    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(1L);

    // Act and Assert
    assertEquals(1L,
        (new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, new BaseReadTsKvQuery("Key", 1L, 1L), partitions))
            .getNextPartition());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvQueryCursor#getCurrentLimit()}
   *   <li>{@link TsKvQueryCursor#getData()}
   *   <li>{@link TsKvQueryCursor#getOrderBy()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    TsKvQueryCursor tsKvQueryCursor = new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery,
        new ArrayList<>());

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
   * <p>
   * Method under test: {@link TsKvQueryCursor#addData(List)}
   */
  @Test
  public void testAddData() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    TsKvQueryCursor tsKvQueryCursor = new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery,
        new ArrayList<>());

    // Act
    tsKvQueryCursor.addData(new ArrayList<>());

    // Assert
    assertEquals(1, tsKvQueryCursor.getCurrentLimit());
    assertFalse(tsKvQueryCursor.isFull());
    assertTrue(tsKvQueryCursor.getData().isEmpty());
  }

  /**
   * Test {@link TsKvQueryCursor#addData(List)}.
   * <p>
   * Method under test: {@link TsKvQueryCursor#addData(List)}
   */
  @Test
  public void testAddData2() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    TsKvQueryCursor tsKvQueryCursor = new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery,
        new ArrayList<>());

    ArrayList<TsKvEntry> newData = new ArrayList<>();
    newData.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    tsKvQueryCursor.addData(newData);

    // Assert
    assertEquals(0, tsKvQueryCursor.getCurrentLimit());
    assertTrue(tsKvQueryCursor.isFull());
    assertEquals(newData, tsKvQueryCursor.getData());
  }

  /**
   * Test {@link TsKvQueryCursor#addData(List)}.
   * <p>
   * Method under test: {@link TsKvQueryCursor#addData(List)}
   */
  @Test
  public void testAddData3() {
    // Arrange
    BaseReadTsKvQuery baseQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    TsKvQueryCursor tsKvQueryCursor = new TsKvQueryCursor("Entity Type", ModelConstants.NULL_UUID, baseQuery,
        new ArrayList<>());

    ArrayList<TsKvEntry> newData = new ArrayList<>();
    newData.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    newData.add(basicTsKvEntry);

    // Act
    tsKvQueryCursor.addData(newData);

    // Assert
    assertEquals(-1, tsKvQueryCursor.getCurrentLimit());
    List<TsKvEntry> data = tsKvQueryCursor.getData();
    assertEquals(2, data.size());
    assertSame(basicTsKvEntry, data.get(1));
  }
}
