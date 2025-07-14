package org.thingsboard.server.dao.model.sqlts.timescale.ts;

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
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.query.TsValue;

class TimescaleTsKvEntityDiffblueTest {
  /**
   * Test {@link TimescaleTsKvEntity#equals(Object)}, and {@link TimescaleTsKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvEntity#equals(Object)}
   *   <li>{@link TimescaleTsKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvEntity.equals(Object)",
    "int TimescaleTsKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setJsonValue("42");
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setLongValue(42L);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setStrValue("42");
    timescaleTsKvEntity.setTs(1L);

    TimescaleTsKvEntity timescaleTsKvEntity2 = new TimescaleTsKvEntity();
    timescaleTsKvEntity2.setAggValuesCount(3L);
    timescaleTsKvEntity2.setAggValuesLastTs(42L);
    timescaleTsKvEntity2.setBooleanValue(true);
    timescaleTsKvEntity2.setDoubleValue(10.0d);
    timescaleTsKvEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity2.setJsonValue("42");
    timescaleTsKvEntity2.setKey(1);
    timescaleTsKvEntity2.setLongValue(42L);
    timescaleTsKvEntity2.setStrKey("Str Key");
    timescaleTsKvEntity2.setStrValue("42");
    timescaleTsKvEntity2.setTs(1L);

    // Act and Assert
    assertEquals(timescaleTsKvEntity, timescaleTsKvEntity2);
    int expectedHashCodeResult = timescaleTsKvEntity.hashCode();
    assertEquals(expectedHashCodeResult, timescaleTsKvEntity2.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvEntity#equals(Object)}, and {@link TimescaleTsKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvEntity#equals(Object)}
   *   <li>{@link TimescaleTsKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvEntity.equals(Object)",
    "int TimescaleTsKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setJsonValue("42");
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setLongValue(42L);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setStrValue("42");
    timescaleTsKvEntity.setTs(1L);

    // Act and Assert
    assertEquals(timescaleTsKvEntity, timescaleTsKvEntity);
    int expectedHashCodeResult = timescaleTsKvEntity.hashCode();
    assertEquals(expectedHashCodeResult, timescaleTsKvEntity.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvEntity.equals(Object)",
    "int TimescaleTsKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(42L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setJsonValue("42");
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setLongValue(42L);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setStrValue("42");
    timescaleTsKvEntity.setTs(1L);

    TimescaleTsKvEntity timescaleTsKvEntity2 = new TimescaleTsKvEntity();
    timescaleTsKvEntity2.setAggValuesCount(3L);
    timescaleTsKvEntity2.setAggValuesLastTs(42L);
    timescaleTsKvEntity2.setBooleanValue(true);
    timescaleTsKvEntity2.setDoubleValue(10.0d);
    timescaleTsKvEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity2.setJsonValue("42");
    timescaleTsKvEntity2.setKey(1);
    timescaleTsKvEntity2.setLongValue(42L);
    timescaleTsKvEntity2.setStrKey("Str Key");
    timescaleTsKvEntity2.setStrValue("42");
    timescaleTsKvEntity2.setTs(1L);

    // Act and Assert
    assertNotEquals(timescaleTsKvEntity, timescaleTsKvEntity2);
  }

  /**
   * Test {@link TimescaleTsKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvEntity.equals(Object)",
    "int TimescaleTsKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setJsonValue("42");
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setLongValue(42L);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setStrValue("42");
    timescaleTsKvEntity.setTs(1L);

    // Act and Assert
    assertNotEquals(timescaleTsKvEntity, null);
  }

  /**
   * Test {@link TimescaleTsKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvEntity.equals(Object)",
    "int TimescaleTsKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setJsonValue("42");
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setLongValue(42L);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setStrValue("42");
    timescaleTsKvEntity.setTs(1L);

    // Act and Assert
    assertNotEquals(timescaleTsKvEntity, "Different type to TimescaleTsKvEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvEntity#TimescaleTsKvEntity()}
   *   <li>{@link TimescaleTsKvEntity#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimescaleTsKvEntity.<init>()", "String TimescaleTsKvEntity.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity = new TimescaleTsKvEntity();

    // Assert
    assertEquals("TimescaleTsKvEntity()", actualTimescaleTsKvEntity.toString());
    assertNull(actualTimescaleTsKvEntity.getBooleanValue());
    assertNull(actualTimescaleTsKvEntity.getDoubleValue());
    assertNull(actualTimescaleTsKvEntity.getAggValuesCount());
    assertNull(actualTimescaleTsKvEntity.getAggValuesLastTs());
    assertNull(actualTimescaleTsKvEntity.getLongValue());
    assertNull(actualTimescaleTsKvEntity.getTs());
    assertNull(actualTimescaleTsKvEntity.getJsonValue());
    assertNull(actualTimescaleTsKvEntity.getStrKey());
    assertNull(actualTimescaleTsKvEntity.getStrValue());
    assertNull(actualTimescaleTsKvEntity.getEntityId());
    assertEquals(0, actualTimescaleTsKvEntity.getKey());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code Agg Type}.
   *   <li>Then toData Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'Agg Type'; then toData Kv return StringDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenAggType_thenToDataKvReturnStringDataEntry() {
    // Arrange, Act and Assert
    TsKvEntry toDataResult =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 3L, 3L, "42", "Agg Type", 42L).toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then return toData toTsValue Count longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'AVG'; then return toData toTsValue Count longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenAvg_thenReturnToDataToTsValueCountLongValueIsOne() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, null, null, 0L, 1L, "", "AVG", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
    assertEquals(1L, toDataResult.toTsValue().getCount().longValue());
    assertEquals(1L, actualTimescaleTsKvEntity.getAggValuesCount().longValue());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then return toData toTsValue Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'AVG'; then return toData toTsValue Value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenAvg_thenReturnToDataToTsValueValueIs42() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 3L, 3L, "42", "AVG", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
    TsValue toTsValueResult = toDataResult.toTsValue();
    assertEquals("42", toTsValueResult.getValue());
    assertEquals(6L, toTsValueResult.getCount().longValue());
    assertEquals(6L, actualTimescaleTsKvEntity.getAggValuesCount().longValue());
    assertEquals(8.666666666666666d, actualTimescaleTsKvEntity.getDoubleValue().doubleValue());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then toData Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'AVG'; then toData Kv return DoubleDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenAvg_thenToDataKvReturnDoubleDataEntry() {
    // Arrange, Act and Assert
    TsKvEntry toDataResult =
        new TimescaleTsKvEntity(1L, 42L, null, null, 0L, 0L, "", "AVG", 42L).toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then toData Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'AVG'; then toData Kv return DoubleDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenAvg_thenToDataKvReturnDoubleDataEntry2() {
    // Arrange, Act and Assert
    TsKvEntry toDataResult =
        new TimescaleTsKvEntity(1L, 42L, null, null, 0L, 0L, null, "AVG", 42L).toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then toData Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'AVG'; then toData Kv return DoubleDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenAvg_thenToDataKvReturnDoubleDataEntry3() {
    // Arrange, Act and Assert
    TsKvEntry toDataResult =
        new TimescaleTsKvEntity(1L, 42L, null, 10.0d, 0L, 0L, "", "AVG", 42L).toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Long, Long, Long, Long,
   * Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then toData Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Long,
   * Long, Long, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Long, Long, Long, Long, Long); when forty-two; then toData Kv return LongDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Long, Long, Long, Long, Long)"
  })
  void testNewTimescaleTsKvEntity_whenFortyTwo_thenToDataKvReturnLongDataEntry() {
    // Arrange, Act and Assert
    TsKvEntry toDataResult = new TimescaleTsKvEntity(1L, 42L, 3L, 3L, 3L, 3L, 3L, 42L).toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof LongDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MAX}.
   *   <li>Then return DoubleValue doubleValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'MAX'; then return DoubleValue doubleValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenMax_thenReturnDoubleValueDoubleValueIsFortyTwo() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 3L, 3L, "42", "MAX", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
    assertEquals(42.0d, actualTimescaleTsKvEntity.getDoubleValue().doubleValue());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MAX}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'MAX'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenMax_thenReturnDoubleValueIsNull() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, null, null, 0L, 0L, "", "MAX", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertNull(actualTimescaleTsKvEntity.getDoubleValue());
    assertNull(actualTimescaleTsKvEntity.getStrValue());
    assertNull(((BasicTsKvEntry) toDataResult).getKv());
    assertFalse(actualTimescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'MIN'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenMin_thenReturnDoubleValueIsNull() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, null, null, 0L, 0L, "", "MIN", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertNull(actualTimescaleTsKvEntity.getDoubleValue());
    assertNull(actualTimescaleTsKvEntity.getStrValue());
    assertNull(((BasicTsKvEntry) toDataResult).getKv());
    assertFalse(actualTimescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'MIN'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenMin_thenReturnDoubleValueIsNull2() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, null, null, 0L, 1L, "", "MIN", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertNull(actualTimescaleTsKvEntity.getDoubleValue());
    assertNull(actualTimescaleTsKvEntity.getStrValue());
    assertNull(((BasicTsKvEntry) toDataResult).getKv());
    assertFalse(actualTimescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'MIN'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenMin_thenReturnDoubleValueIsNull3() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, null, null, 1L, 0L, "", "MIN", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertNull(actualTimescaleTsKvEntity.getDoubleValue());
    assertNull(actualTimescaleTsKvEntity.getStrValue());
    assertNull(((BasicTsKvEntry) toDataResult).getKv());
    assertFalse(actualTimescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then toData Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'MIN'; then toData Kv return StringDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenMin_thenToDataKvReturnStringDataEntry() {
    // Arrange, Act and Assert
    TsKvEntry toDataResult =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 3L, 3L, "42", "MIN", 42L).toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code SUM}.
   *   <li>Then return DoubleValue doubleValue is fifty-two.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'SUM'; then return DoubleValue doubleValue is fifty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenSum_thenReturnDoubleValueDoubleValueIsFiftyTwo() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 3L, 3L, "42", "SUM", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
    assertEquals(52.0d, actualTimescaleTsKvEntity.getDoubleValue().doubleValue());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code SUM}.
   *   <li>Then return DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'SUM'; then return DoubleValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenSum_thenReturnDoubleValueIsNull() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, null, null, 0L, 0L, "", "SUM", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertNull(actualTimescaleTsKvEntity.getDoubleValue());
    assertNull(actualTimescaleTsKvEntity.getStrValue());
    assertNull(((BasicTsKvEntry) toDataResult).getKv());
    assertFalse(actualTimescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code SUM}.
   *   <li>Then toData Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long, String, String, Long); when 'SUM'; then toData Kv return StringDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  void testNewTimescaleTsKvEntity_whenSum_thenToDataKvReturnStringDataEntry() {
    // Arrange, Act and Assert
    TsKvEntry toDataResult =
        new TimescaleTsKvEntity(1L, 42L, null, 10.0d, 3L, 3L, "42", "SUM", 42L).toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Long, Long, Long, Long,
   * Long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return toData ValueAsString is {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Long,
   * Long, Long, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Long, Long, Long, Long, Long); when zero; then return toData ValueAsString is '6'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Long, Long, Long, Long, Long)"
  })
  void testNewTimescaleTsKvEntity_whenZero_thenReturnToDataValueAsStringIs6() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 0L, 0L, 3L, 3L, 0L, 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertEquals("6", toDataResult.getValueAsString());
    assertEquals(6L, actualTimescaleTsKvEntity.getLongValue().longValue());
    assertEquals(6L, ((Long) toDataResult.getValue()).longValue());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Long, Long, Long, Long,
   * Long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then toData Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Long,
   * Long, Long, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Long, Long, Long, Long, Long); when zero; then toData Kv return LongDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Long, Long, Long, Long, Long)"
  })
  void testNewTimescaleTsKvEntity_whenZero_thenToDataKvReturnLongDataEntry() {
    // Arrange, Act and Assert
    TsKvEntry toDataResult = new TimescaleTsKvEntity(1L, 42L, 0L, 3L, 3L, 3L, 3L, 42L).toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof LongDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Long, Long, Long, Long,
   * Long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then toData Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Long,
   * Long, Long, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimescaleTsKvEntity(Long, Long, Long, Long, Long, Long, Long, Long); when zero; then toData Kv return LongDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Long, Long, Long, Long, Long)"
  })
  void testNewTimescaleTsKvEntity_whenZero_thenToDataKvReturnLongDataEntry2() {
    // Arrange, Act and Assert
    TsKvEntry toDataResult = new TimescaleTsKvEntity(1L, 42L, 0L, 0L, 3L, 3L, 3L, 42L).toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof LongDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} BooleanValue is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given TimescaleTsKvEntity() BooleanValue is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTimescaleTsKvEntityBooleanValueIsTrue_thenReturnTrue() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setTs(1L);
    timescaleTsKvEntity.setStrValue(null);
    timescaleTsKvEntity.setLongValue(null);
    timescaleTsKvEntity.setDoubleValue(null);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(timescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} DoubleValue is ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given TimescaleTsKvEntity() DoubleValue is ten; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTimescaleTsKvEntityDoubleValueIsTen_thenReturnTrue() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setTs(1L);
    timescaleTsKvEntity.setStrValue(null);
    timescaleTsKvEntity.setLongValue(null);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setBooleanValue(null);
    timescaleTsKvEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(timescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} JsonValue is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given TimescaleTsKvEntity() JsonValue is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTimescaleTsKvEntityJsonValueIsFoo_thenReturnTrue() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setTs(1L);
    timescaleTsKvEntity.setStrValue(null);
    timescaleTsKvEntity.setLongValue(null);
    timescaleTsKvEntity.setDoubleValue(null);
    timescaleTsKvEntity.setBooleanValue(null);
    timescaleTsKvEntity.setJsonValue("foo");

    // Act and Assert
    assertTrue(timescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} LongValue is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given TimescaleTsKvEntity() LongValue is one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTimescaleTsKvEntityLongValueIsOne_thenReturnTrue() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setTs(1L);
    timescaleTsKvEntity.setStrValue(null);
    timescaleTsKvEntity.setLongValue(1L);
    timescaleTsKvEntity.setDoubleValue(null);
    timescaleTsKvEntity.setBooleanValue(null);
    timescaleTsKvEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(timescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} StrValue is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given TimescaleTsKvEntity() StrValue is 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTimescaleTsKvEntityStrValueIsFoo_thenReturnTrue() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setTs(1L);
    timescaleTsKvEntity.setStrValue("foo");
    timescaleTsKvEntity.setLongValue(null);
    timescaleTsKvEntity.setDoubleValue(null);
    timescaleTsKvEntity.setBooleanValue(null);
    timescaleTsKvEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(timescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} StrValue is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given TimescaleTsKvEntity() StrValue is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTimescaleTsKvEntityStrValueIsNull_thenReturnFalse() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setTs(1L);
    timescaleTsKvEntity.setStrValue(null);
    timescaleTsKvEntity.setLongValue(null);
    timescaleTsKvEntity.setDoubleValue(null);
    timescaleTsKvEntity.setBooleanValue(null);
    timescaleTsKvEntity.setJsonValue(null);

    // Act and Assert
    assertFalse(timescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @DisplayName("Test isNotEmpty(); given TimescaleTsKvEntity(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  void testIsNotEmpty_givenTimescaleTsKvEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TimescaleTsKvEntity().isNotEmpty());
  }
}
