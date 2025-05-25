package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.AggKey;

class ReadTsKvQueryInfoDiffblueTest {
  /**
   * Test {@link ReadTsKvQueryInfo#equals(Object)}, and {@link ReadTsKvQueryInfo#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReadTsKvQueryInfo.equals(Object)", "int ReadTsKvQueryInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AggKey key = new AggKey();
    key.setAgg(Aggregation.MIN);
    key.setId(1);
    key.setKey("Key");
    key.setPreviousEndTs(1L);
    key.setPreviousStartTs(1L);
    key.setPreviousValueOnly(true);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReadTsKvQueryInfo.equals(Object)", "int ReadTsKvQueryInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AggKey key = new AggKey();
    key.setAgg(Aggregation.MIN);
    key.setId(1);
    key.setKey("Key");
    key.setPreviousEndTs(1L);
    key.setPreviousStartTs(1L);
    key.setPreviousValueOnly(true);
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), true);

    AggKey key2 = new AggKey();
    key2.setAgg(Aggregation.MIN);
    key2.setId(1);
    key2.setKey("Key");
    key2.setPreviousEndTs(1L);
    key2.setPreviousStartTs(1L);
    key2.setPreviousValueOnly(true);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReadTsKvQueryInfo.equals(Object)", "int ReadTsKvQueryInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AggKey key = mock(AggKey.class);
    doNothing().when(key).setAgg(Mockito.<Aggregation>any());
    doNothing().when(key).setId(anyInt());
    doNothing().when(key).setKey(Mockito.<String>any());
    doNothing().when(key).setPreviousEndTs(Mockito.<Long>any());
    doNothing().when(key).setPreviousStartTs(Mockito.<Long>any());
    doNothing().when(key).setPreviousValueOnly(Mockito.<Boolean>any());
    key.setAgg(Aggregation.MIN);
    key.setId(1);
    key.setKey("Key");
    key.setPreviousEndTs(1L);
    key.setPreviousStartTs(1L);
    key.setPreviousValueOnly(true);
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), true);

    AggKey key2 = new AggKey();
    key2.setAgg(Aggregation.MIN);
    key2.setId(1);
    key2.setKey("Key");
    key2.setPreviousEndTs(1L);
    key2.setPreviousStartTs(1L);
    key2.setPreviousValueOnly(true);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReadTsKvQueryInfo.equals(Object)", "int ReadTsKvQueryInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AggKey key = mock(AggKey.class);
    doNothing().when(key).setAgg(Mockito.<Aggregation>any());
    doNothing().when(key).setId(anyInt());
    doNothing().when(key).setKey(Mockito.<String>any());
    doNothing().when(key).setPreviousEndTs(Mockito.<Long>any());
    doNothing().when(key).setPreviousStartTs(Mockito.<Long>any());
    doNothing().when(key).setPreviousValueOnly(Mockito.<Boolean>any());
    key.setAgg(Aggregation.MIN);
    key.setId(1);
    key.setKey("Key");
    key.setPreviousEndTs(1L);
    key.setPreviousStartTs(1L);
    key.setPreviousValueOnly(true);
    ReadTsKvQueryInfo readTsKvQueryInfo = new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), false);

    AggKey key2 = new AggKey();
    key2.setAgg(Aggregation.MIN);
    key2.setId(1);
    key2.setKey("Key");
    key2.setPreviousEndTs(1L);
    key2.setPreviousStartTs(1L);
    key2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(readTsKvQueryInfo, new ReadTsKvQueryInfo(key2, new BaseReadTsKvQuery("Key", 1L, 1L), true));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReadTsKvQueryInfo.equals(Object)", "int ReadTsKvQueryInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AggKey key = new AggKey();
    key.setAgg(Aggregation.MIN);
    key.setId(1);
    key.setKey("Key");
    key.setPreviousEndTs(1L);
    key.setPreviousStartTs(1L);
    key.setPreviousValueOnly(true);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReadTsKvQueryInfo.equals(Object)", "int ReadTsKvQueryInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AggKey key = new AggKey();
    key.setAgg(Aggregation.MIN);
    key.setId(1);
    key.setKey("Key");
    key.setPreviousEndTs(1L);
    key.setPreviousStartTs(1L);
    key.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(new ReadTsKvQueryInfo(key, new BaseReadTsKvQuery("Key", 1L, 1L), true),
        "Different type to ReadTsKvQueryInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReadTsKvQueryInfo#ReadTsKvQueryInfo(AggKey, ReadTsKvQuery, boolean)}
   *   <li>{@link ReadTsKvQueryInfo#toString()}
   *   <li>{@link ReadTsKvQueryInfo#getKey()}
   *   <li>{@link ReadTsKvQueryInfo#getQuery()}
   *   <li>{@link ReadTsKvQueryInfo#isPrevious()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ReadTsKvQueryInfo.<init>(AggKey, ReadTsKvQuery, boolean)",
      "AggKey ReadTsKvQueryInfo.getKey()", "ReadTsKvQuery ReadTsKvQueryInfo.getQuery()",
      "boolean ReadTsKvQueryInfo.isPrevious()", "String ReadTsKvQueryInfo.toString()"})
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
