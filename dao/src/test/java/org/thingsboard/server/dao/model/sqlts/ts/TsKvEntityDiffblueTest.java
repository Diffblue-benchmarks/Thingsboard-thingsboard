package org.thingsboard.server.dao.model.sqlts.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TsKvEntityDiffblueTest {
  /**
   * Test {@link TsKvEntity#equals(Object)}, and {@link TsKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvEntity#equals(Object)}
   *   <li>{@link TsKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvEntity.equals(Object)", "int TsKvEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);

    TsKvEntity tsKvEntity2 = new TsKvEntity();
    tsKvEntity2.setAggValuesCount(3L);
    tsKvEntity2.setAggValuesLastTs(42L);
    tsKvEntity2.setBooleanValue(true);
    tsKvEntity2.setDoubleValue(10.0d);
    tsKvEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity2.setJsonValue("42");
    tsKvEntity2.setKey(1);
    tsKvEntity2.setLongValue(42L);
    tsKvEntity2.setStrKey("Str Key");
    tsKvEntity2.setStrValue("42");
    tsKvEntity2.setTs(1L);

    // Act and Assert
    assertEquals(tsKvEntity, tsKvEntity2);
    int expectedHashCodeResult = tsKvEntity.hashCode();
    assertEquals(expectedHashCodeResult, tsKvEntity2.hashCode());
  }

  /**
   * Test {@link TsKvEntity#equals(Object)}, and {@link TsKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvEntity#equals(Object)}
   *   <li>{@link TsKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvEntity.equals(Object)", "int TsKvEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);

    // Act and Assert
    assertEquals(tsKvEntity, tsKvEntity);
    int expectedHashCodeResult = tsKvEntity.hashCode();
    assertEquals(expectedHashCodeResult, tsKvEntity.hashCode());
  }

  /**
   * Test {@link TsKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvEntity.equals(Object)", "int TsKvEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(42L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);

    TsKvEntity tsKvEntity2 = new TsKvEntity();
    tsKvEntity2.setAggValuesCount(3L);
    tsKvEntity2.setAggValuesLastTs(42L);
    tsKvEntity2.setBooleanValue(true);
    tsKvEntity2.setDoubleValue(10.0d);
    tsKvEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity2.setJsonValue("42");
    tsKvEntity2.setKey(1);
    tsKvEntity2.setLongValue(42L);
    tsKvEntity2.setStrKey("Str Key");
    tsKvEntity2.setStrValue("42");
    tsKvEntity2.setTs(1L);

    // Act and Assert
    assertNotEquals(tsKvEntity, tsKvEntity2);
  }

  /**
   * Test {@link TsKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvEntity.equals(Object)", "int TsKvEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);

    // Act and Assert
    assertNotEquals(tsKvEntity, null);
  }

  /**
   * Test {@link TsKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvEntity.equals(Object)", "int TsKvEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);

    // Act and Assert
    assertNotEquals(tsKvEntity, "Different type to TsKvEntity");
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return AggValuesLastTs is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvEntity#TsKvEntity()}
   *   <li>{@link TsKvEntity#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return AggValuesLastTs is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TsKvEntity.<init>()",
    "void TsKvEntity.<init>(String, Long)",
    "String TsKvEntity.toString()"
  })
  void testGettersAndSetters_thenReturnAggValuesLastTsIsNull() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity();

    // Assert
    assertEquals("TsKvEntity()", actualTsKvEntity.toString());
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getAggValuesLastTs());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return StrValue is {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvEntity#TsKvEntity(String, Long)}
   *   <li>{@link TsKvEntity#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'; then return StrValue is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TsKvEntity.<init>()",
    "void TsKvEntity.<init>(String, Long)",
    "String TsKvEntity.toString()"
  })
  void testGettersAndSetters_when42_thenReturnStrValueIs42() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity("42", 42L);
    String actualToStringResult = actualTsKvEntity.toString();

    // Assert
    assertEquals("42", actualTsKvEntity.getStrValue());
    assertEquals("TsKvEntity()", actualToStringResult);
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code Agg Type}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'Agg Type'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenAggType_thenReturnDoubleValueIsNull() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 3L, 3L, "Agg Type", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertFalse(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then return AggValuesCount longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'AVG'; then return AggValuesCount longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenAvg_thenReturnAggValuesCountLongValueIsOne() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, null, 0L, 1L, "AVG", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue());
    assertEquals(1L, actualTsKvEntity.getAggValuesCount().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then return AggValuesCount longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'AVG'; then return AggValuesCount longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenAvg_thenReturnAggValuesCountLongValueIsZero() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, null, 0L, 0L, "AVG", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue());
    assertEquals(0L, actualTsKvEntity.getAggValuesCount().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then return AggValuesCount longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'AVG'; then return AggValuesCount longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenAvg_thenReturnAggValuesCountLongValueIsZero2() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, 10.0d, 0L, 0L, "AVG", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue());
    assertEquals(0L, actualTsKvEntity.getAggValuesCount().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then return AggValuesCount longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'AVG'; then return AggValuesCount longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenAvg_thenReturnAggValuesCountLongValueIsZero3() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, null, 0L, 0L, "AVG", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue());
    assertEquals(0L, actualTsKvEntity.getAggValuesCount().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return LongValue longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Long, Long, Long, Long, Long); when forty-two; then return LongValue longValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Long, Long, Long, Long, Long)"})
  void testNewTsKvEntity_whenFortyTwo_thenReturnLongValueLongValueIsThree() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(3L, 3L, 3L, 3L, 3L, 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(3L, actualTsKvEntity.getLongValue().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MAX}.
   *   <li>Then return DoubleValue doubleValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'MAX'; then return DoubleValue doubleValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenMax_thenReturnDoubleValueDoubleValueIsFortyTwo() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 3L, 3L, "MAX", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(42.0d, actualTsKvEntity.getDoubleValue().doubleValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MAX}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'MAX'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenMax_thenReturnDoubleValueIsNull() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, null, 0L, 0L, "MAX", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertFalse(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'MIN'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenMin_thenReturnDoubleValueIsNull() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, null, 0L, 0L, "MIN", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertFalse(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'MIN'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenMin_thenReturnDoubleValueIsNull2() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, null, 0L, 1L, "MIN", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertFalse(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'MIN'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenMin_thenReturnDoubleValueIsNull3() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, null, 1L, 0L, "MIN", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertFalse(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code SUM}.
   *   <li>Then return DoubleValue doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'SUM'; then return DoubleValue doubleValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenSum_thenReturnDoubleValueDoubleValueIsTen() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, 10.0d, 0L, 1L, "SUM", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(10.0d, actualTsKvEntity.getDoubleValue().doubleValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code SUM}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when 'SUM'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenSum_thenReturnDoubleValueIsNull() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, null, 0L, 0L, "SUM", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertFalse(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return DoubleValue doubleValue is fifty-two.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when three; then return DoubleValue doubleValue is fifty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenThree_thenReturnDoubleValueDoubleValueIsFiftyTwo() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 3L, 3L, "SUM", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertEquals(52.0d, actualTsKvEntity.getDoubleValue().doubleValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return DoubleValue doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Double, Long, Long, String, Long); when three; then return DoubleValue doubleValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  void testNewTsKvEntity_whenThree_thenReturnDoubleValueDoubleValueIsTen() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 3L, 3L, "MIN", 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(10.0d, actualTsKvEntity.getDoubleValue().doubleValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return LongValue longValue is six.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Long, Long, Long, Long, Long); when zero; then return LongValue longValue is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Long, Long, Long, Long, Long)"})
  void testNewTsKvEntity_whenZero_thenReturnLongValueLongValueIsSix() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(0L, 0L, 3L, 3L, 0L, 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertEquals(6L, actualTsKvEntity.getLongValue().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return LongValue longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Long, Long, Long, Long, Long); when zero; then return LongValue longValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Long, Long, Long, Long, Long)"})
  void testNewTsKvEntity_whenZero_thenReturnLongValueLongValueIsThree() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(0L, 3L, 3L, 3L, 3L, 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(3L, actualTsKvEntity.getLongValue().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return LongValue longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test new TsKvEntity(Long, Long, Long, Long, Long, Long); when zero; then return LongValue longValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Long, Long, Long, Long, Long)"})
  void testNewTsKvEntity_whenZero_thenReturnLongValueLongValueIsThree2() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(0L, 0L, 3L, 3L, 3L, 42L);

    // Assert
    assertNull(actualTsKvEntity.getBooleanValue());
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getTs());
    assertNull(actualTsKvEntity.getVersion());
    assertNull(actualTsKvEntity.getJsonValue());
    assertNull(actualTsKvEntity.getStrKey());
    assertNull(actualTsKvEntity.getStrValue());
    assertNull(actualTsKvEntity.getEntityId());
    assertEquals(0, actualTsKvEntity.getKey());
    assertEquals(3L, actualTsKvEntity.getLongValue().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} BooleanValue is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TsKvEntity() BooleanValue is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvEntityBooleanValueIsTrue_thenReturnTrue() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setTs(1L);
    tsKvEntity.setStrValue(null);
    tsKvEntity.setLongValue(null);
    tsKvEntity.setDoubleValue(null);
    tsKvEntity.setBooleanValue(true);

    // Act and Assert
    assertTrue(tsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} DoubleValue is ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TsKvEntity() DoubleValue is ten; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvEntityDoubleValueIsTen_thenReturnTrue() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setTs(1L);
    tsKvEntity.setStrValue(null);
    tsKvEntity.setLongValue(null);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setBooleanValue(null);

    // Act and Assert
    assertTrue(tsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} LongValue is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TsKvEntity() LongValue is one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvEntityLongValueIsOne_thenReturnTrue() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setTs(1L);
    tsKvEntity.setStrValue(null);
    tsKvEntity.setLongValue(1L);
    tsKvEntity.setDoubleValue(null);
    tsKvEntity.setBooleanValue(null);

    // Act and Assert
    assertTrue(tsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} StrValue is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TsKvEntity() StrValue is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvEntityStrValueIsFoo_thenReturnTrue() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setTs(1L);
    tsKvEntity.setStrValue("foo");
    tsKvEntity.setLongValue(null);
    tsKvEntity.setDoubleValue(null);
    tsKvEntity.setBooleanValue(null);

    // Act and Assert
    assertTrue(tsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TsKvEntity(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTsKvEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TsKvEntity().isNotEmpty());
  }
}
