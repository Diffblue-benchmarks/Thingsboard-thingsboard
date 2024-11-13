package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.AggKey;

class ReadTsKvQueryInfoDiffblueTest {
  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}, and
   * {@link ReadTsKvQueryInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReadTsKvQueryInfo#equals(Object)}
   *   <li>{@link ReadTsKvQueryInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(new AggKey(), null, true);
    ReadTsKvQueryInfo readTsKvQueryInfo2 = new ReadTsKvQueryInfo(new AggKey(), null, true);

    // Act and Assert
    assertEquals(readTsKvQueryInfo, readTsKvQueryInfo2);
    int expectedHashCodeResult = readTsKvQueryInfo.hashCode();
    assertEquals(expectedHashCodeResult, readTsKvQueryInfo2.hashCode());
  }

  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}, and
   * {@link ReadTsKvQueryInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReadTsKvQueryInfo#equals(Object)}
   *   <li>{@link ReadTsKvQueryInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AggKey key = new AggKey();
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), true);

    // Act and Assert
    assertEquals(readTsKvQueryInfo, readTsKvQueryInfo);
    int expectedHashCodeResult = readTsKvQueryInfo.hashCode();
    assertEquals(expectedHashCodeResult, readTsKvQueryInfo.hashCode());
  }

  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AggKey key = new AggKey();
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), true);
    AggKey key2 = new AggKey();

    // Act and Assert
    assertNotEquals(readTsKvQueryInfo, new ReadTsKvQueryInfo(key2, new BaseReadTsKvQuery("Key", 1L, 1L), true));
  }

  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(null, new BaseReadTsKvQuery("Key", 1L, 1L), true);
    AggKey key = new AggKey();

    // Act and Assert
    assertNotEquals(readTsKvQueryInfo, new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), true));
  }

  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AggKey key = mock(AggKey.class);
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), true);
    AggKey key2 = new AggKey();

    // Act and Assert
    assertNotEquals(readTsKvQueryInfo, new ReadTsKvQueryInfo(key2, new BaseReadTsKvQuery("Key", 1L, 1L), true));
  }

  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(new AggKey(), null, true);
    AggKey key = new AggKey();

    // Act and Assert
    assertNotEquals(readTsKvQueryInfo, new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), true));
  }

  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AggKey key = new AggKey();
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), false);
    AggKey key2 = new AggKey();

    // Act and Assert
    assertNotEquals(readTsKvQueryInfo, new ReadTsKvQueryInfo(key2, new BaseReadTsKvQuery("Key", 1L, 1L), true));
  }

  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(null, new BaseReadTsKvQuery("Key", 1L, 1L), true);

    // Act and Assert
    assertNotEquals(readTsKvQueryInfo, new ReadTsKvQueryInfo(null, new BaseReadTsKvQuery("Key", 1L, 1L), true));
  }

  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AggKey key = new AggKey();

    // Act and Assert
    assertNotEquals(new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), true), null);
  }

  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReadTsKvQueryInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AggKey key = new AggKey();

    // Act and Assert
    assertNotEquals(new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), true),
        "Different type to ReadTsKvQueryInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ReadTsKvQueryInfo#ReadTsKvQueryInfo(AggKey, ReadTsKvQuery, boolean)}
   *   <li>{@link ReadTsKvQueryInfo#toString()}
   *   <li>{@link ReadTsKvQueryInfo#getKey()}
   *   <li>{@link ReadTsKvQueryInfo#getQuery()}
   *   <li>{@link ReadTsKvQueryInfo#isPrevious()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    AggKey key = new AggKey();
    key.setAgg(Aggregation.MIN);
    key.setId(1);
    key.setKey("Key");
    key.setPreviousEndTs(1L);
    key.setPreviousStartTs(1L);
    key.setPreviousValueOnly(true);
    BaseReadTsKvQuery query = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act
    ReadTsKvQueryInfo actualReadTsKvQueryInfo = new ReadTsKvQueryInfo(key, query, true);
    actualReadTsKvQueryInfo.toString();
    AggKey actualKey = actualReadTsKvQueryInfo.getKey();
    ReadTsKvQuery actualQuery = actualReadTsKvQueryInfo.getQuery();

    // Assert
    assertTrue(actualReadTsKvQueryInfo.isPrevious());
    assertSame(query, actualQuery);
    assertSame(key, actualKey);
  }
}
