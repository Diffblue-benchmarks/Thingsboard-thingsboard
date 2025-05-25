package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.kv.BaseDeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.TsKvQuery;

public class QueryCursorDiffblueTest {
  /**
   * Test {@link QueryCursor#QueryCursor(String, UUID, TsKvQuery, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link QueryCursor#partitions} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryCursor#QueryCursor(String, UUID, TsKvQuery, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueryCursor.<init>(String, UUID, TsKvQuery, List)"})
  public void testNewQueryCursor_whenArrayList_thenReturnPartitionsEmpty() {
    // Arrange
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    BaseDeleteTsKvQuery baseQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act
    QueryCursor actualQueryCursor = new QueryCursor("Entity Type", entityId, baseQuery, new ArrayList<>());

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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryCursor#hasNextPartition()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueryCursor.hasNextPartition()"})
  public void testHasNextPartition_givenArrayListAddMinusOne_thenReturnTrue() {
    // Arrange
    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(-1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertTrue((new QueryCursor("Entity Type", entityId, new BaseDeleteTsKvQuery("Key", 1L, 1L), partitions))
        .hasNextPartition());
  }

  /**
   * Test {@link QueryCursor#hasNextPartition()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryCursor#hasNextPartition()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QueryCursor.hasNextPartition()"})
  public void testHasNextPartition_thenReturnFalse() {
    // Arrange
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    BaseDeleteTsKvQuery baseQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertFalse((new QueryCursor("Entity Type", entityId, baseQuery, new ArrayList<>())).hasNextPartition());
  }

  /**
   * Test {@link QueryCursor#getNextPartition()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueryCursor#getNextPartition()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long QueryCursor.getNextPartition()"})
  public void testGetNextPartition_givenArrayListAddOne_thenReturnOne() {
    // Arrange
    ArrayList<Long> partitions = new ArrayList<>();
    partitions.add(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertEquals(1L, (new QueryCursor("Entity Type", entityId, new BaseDeleteTsKvQuery("Key", 1L, 1L), partitions))
        .getNextPartition());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueryCursor#getEndTs()}
   *   <li>{@link QueryCursor#getEntityId()}
   *   <li>{@link QueryCursor#getEntityType()}
   *   <li>{@link QueryCursor#getKey()}
   *   <li>{@link QueryCursor#getStartTs()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long QueryCursor.getEndTs()", "UUID QueryCursor.getEntityId()",
      "String QueryCursor.getEntityType()", "String QueryCursor.getKey()", "long QueryCursor.getStartTs()"})
  public void testGettersAndSetters() {
    // Arrange
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    BaseDeleteTsKvQuery baseQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    QueryCursor queryCursor = new QueryCursor("Entity Type", entityId, baseQuery, new ArrayList<>());

    // Act
    long actualEndTs = queryCursor.getEndTs();
    UUID actualEntityId = queryCursor.getEntityId();
    String actualEntityType = queryCursor.getEntityType();
    String actualKey = queryCursor.getKey();
    long actualStartTs = queryCursor.getStartTs();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals("Entity Type", actualEntityType);
    assertEquals("Key", actualKey);
    assertEquals(1L, actualEndTs);
    assertEquals(1L, actualStartTs);
  }
}
