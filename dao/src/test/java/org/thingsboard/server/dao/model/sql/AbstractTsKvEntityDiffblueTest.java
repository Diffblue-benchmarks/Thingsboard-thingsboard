package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestEntity;
import org.thingsboard.server.dao.model.sqlts.timescale.ts.TimescaleTsKvEntity;

class AbstractTsKvEntityDiffblueTest {
  /**
   * Test {@link AbstractTsKvEntity#getAggValuesCount()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getAggValuesCount()}
   */
  @Test
  @DisplayName("Test getAggValuesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AbstractTsKvEntity.getAggValuesCount()"})
  void testGetAggValuesCount() {
    // Arrange, Act and Assert
    assertNull(new TsKvLatestEntity().getAggValuesCount());
  }

  /**
   * Test {@link AbstractTsKvEntity#getAggValuesLastTs()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getAggValuesLastTs()}
   */
  @Test
  @DisplayName("Test getAggValuesLastTs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AbstractTsKvEntity.getAggValuesLastTs()"})
  void testGetAggValuesLastTs() {
    // Arrange, Act and Assert
    assertNull(new TsKvLatestEntity().getAggValuesLastTs());
  }

  /**
   * Test {@link AbstractTsKvEntity#getBooleanValue()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue(); given TsKvLatestEntity(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean AbstractTsKvEntity.getBooleanValue()"})
  void testGetBooleanValue_givenTsKvLatestEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TsKvLatestEntity().getBooleanValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getBooleanValue()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean AbstractTsKvEntity.getBooleanValue()"})
  void testGetBooleanValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new TsKvLatestEntity(
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                1,
                "Str Key",
                "42",
                false,
                42L,
                10.0d,
                "42",
                1L,
                1L)
            .getBooleanValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getBooleanValue()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getBooleanValue()}
   */
  @Test
  @DisplayName("Test getBooleanValue(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean AbstractTsKvEntity.getBooleanValue()"})
  void testGetBooleanValue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new TsKvLatestEntity(
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                1,
                "Str Key",
                "42",
                true,
                42L,
                10.0d,
                "42",
                1L,
                1L)
            .getBooleanValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getDoubleValue()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getDoubleValue()}
   */
  @Test
  @DisplayName("Test getDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Double AbstractTsKvEntity.getDoubleValue()"})
  void testGetDoubleValue() {
    // Arrange, Act and Assert
    assertNull(new TsKvLatestEntity().getDoubleValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getEntityId()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID AbstractTsKvEntity.getEntityId()"})
  void testGetEntityId() {
    // Arrange, Act and Assert
    assertNull(new TsKvLatestEntity().getEntityId());
  }

  /**
   * Test {@link AbstractTsKvEntity#getJsonValue()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getJsonValue()}
   */
  @Test
  @DisplayName("Test getJsonValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractTsKvEntity.getJsonValue()"})
  void testGetJsonValue() {
    // Arrange, Act and Assert
    assertNull(new TsKvLatestEntity().getJsonValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getKey()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AbstractTsKvEntity.getKey()"})
  void testGetKey() {
    // Arrange, Act and Assert
    assertEquals(0, new TsKvLatestEntity().getKey());
  }

  /**
   * Test {@link AbstractTsKvEntity#getLongValue()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getLongValue()}
   */
  @Test
  @DisplayName("Test getLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AbstractTsKvEntity.getLongValue()"})
  void testGetLongValue() {
    // Arrange, Act and Assert
    assertNull(new TsKvLatestEntity().getLongValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getStrKey()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getStrKey()}
   */
  @Test
  @DisplayName("Test getStrKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractTsKvEntity.getStrKey()"})
  void testGetStrKey() {
    // Arrange, Act and Assert
    assertNull(new TsKvLatestEntity().getStrKey());
  }

  /**
   * Test {@link AbstractTsKvEntity#getStrValue()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getStrValue()}
   */
  @Test
  @DisplayName("Test getStrValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractTsKvEntity.getStrValue()"})
  void testGetStrValue() {
    // Arrange, Act and Assert
    assertNull(new TsKvLatestEntity().getStrValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getTs()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getTs()}
   */
  @Test
  @DisplayName("Test getTs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AbstractTsKvEntity.getTs()"})
  void testGetTs() {
    // Arrange, Act and Assert
    assertNull(new TsKvLatestEntity().getTs());
  }

  /**
   * Test {@link AbstractTsKvEntity#isAllNull(Object[])}.
   *
   * <ul>
   *   <li>When {@code Args}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#isAllNull(Object[])}
   */
  @Test
  @DisplayName("Test isAllNull(Object[]); when 'Args'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractTsKvEntity.isAllNull(Object[])"})
  void testIsAllNull_whenArgs_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AbstractTsKvEntity.isAllNull("Args"));
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   *
   * <ul>
   *   <li>Then Kv return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Kv return BooleanDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  void testToData_thenKvReturnBooleanDataEntry() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity =
        new TsKvLatestEntity(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            1,
            "Str Key",
            null,
            true,
            null,
            null,
            null,
            1L,
            1L);
    tsKvLatestEntity.setAggValuesCount(null);

    // Act
    TsKvEntry actualToDataResult = tsKvLatestEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) actualToDataResult).getKv() instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, actualToDataResult.getDataType());
    Optional<Double> doubleValue = actualToDataResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue((Boolean) actualToDataResult.getValue());
    String expectedValueAsString = Boolean.TRUE.toString();
    assertEquals(expectedValueAsString, actualToDataResult.getValueAsString());
    assertSame(doubleValue, actualToDataResult.getJsonValue());
    assertSame(doubleValue, actualToDataResult.getLongValue());
    assertSame(doubleValue, actualToDataResult.getStrValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   *
   * <ul>
   *   <li>Then Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Kv return DoubleDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  void testToData_thenKvReturnDoubleDataEntry() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity =
        new TsKvLatestEntity(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            1,
            "Str Key",
            null,
            null,
            null,
            10.0d,
            null,
            1L,
            1L);
    tsKvLatestEntity.setAggValuesCount(null);

    // Act
    TsKvEntry actualToDataResult = tsKvLatestEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) actualToDataResult).getKv() instanceof DoubleDataEntry);
    assertEquals("10.0", actualToDataResult.getValueAsString());
    assertEquals(10.0d, ((Double) actualToDataResult.getValue()).doubleValue());
    assertEquals(DataType.DOUBLE, actualToDataResult.getDataType());
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   *
   * <ul>
   *   <li>Then Kv return {@link JsonDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Kv return JsonDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  void testToData_thenKvReturnJsonDataEntry() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity =
        new TsKvLatestEntity(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            1,
            "Str Key",
            null,
            null,
            null,
            null,
            "42",
            1L,
            1L);
    tsKvLatestEntity.setAggValuesCount(null);

    // Act
    TsKvEntry actualToDataResult = tsKvLatestEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) actualToDataResult).getKv();
    assertTrue(kv instanceof JsonDataEntry);
    Optional<String> jsonValue = actualToDataResult.getJsonValue();
    assertEquals("42", jsonValue.get());
    assertEquals("42", kv.getValueAsString());
    assertEquals("42", kv.getValue());
    assertEquals(DataType.JSON, kv.getDataType());
    assertEquals(DataType.JSON, actualToDataResult.getDataType());
    assertTrue(jsonValue.isPresent());
    assertEquals(jsonValue, kv.getJsonValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   *
   * <ul>
   *   <li>Then Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Kv return LongDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  void testToData_thenKvReturnLongDataEntry() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity =
        new TsKvLatestEntity(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            1,
            "Str Key",
            null,
            null,
            42L,
            null,
            null,
            1L,
            1L);
    tsKvLatestEntity.setAggValuesCount(null);

    // Act
    TsKvEntry actualToDataResult = tsKvLatestEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) actualToDataResult).getKv() instanceof LongDataEntry);
    assertEquals(42L, ((Long) actualToDataResult.getValue()).longValue());
    assertEquals(DataType.LONG, actualToDataResult.getDataType());
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   *
   * <ul>
   *   <li>Then Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Kv return StringDataEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  void testToData_thenKvReturnStringDataEntry() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity =
        new TsKvLatestEntity(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            1,
            "Str Key",
            "42",
            null,
            null,
            null,
            null,
            1L,
            1L);
    tsKvLatestEntity.setAggValuesCount(null);

    // Act
    TsKvEntry actualToDataResult = tsKvLatestEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    KvEntry kv = ((BasicTsKvEntry) actualToDataResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    Optional<String> strValue = actualToDataResult.getStrValue();
    assertEquals("42", strValue.get());
    assertEquals("42", kv.getValueAsString());
    assertEquals("42", kv.getValue());
    assertEquals(DataType.STRING, kv.getDataType());
    assertEquals(DataType.STRING, actualToDataResult.getDataType());
    assertTrue(strValue.isPresent());
    assertEquals(strValue, kv.getStrValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   *
   * <ul>
   *   <li>Then return {@link AggTsKvEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return AggTsKvEntry")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  void testToData_thenReturnAggTsKvEntry() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity =
        new TsKvLatestEntity(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            1,
            "Str Key",
            null,
            null,
            null,
            null,
            null,
            1L,
            1L);
    tsKvLatestEntity.setAggValuesCount(1L);

    // Act
    TsKvEntry actualToDataResult = tsKvLatestEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof AggTsKvEntry);
    assertNull(actualToDataResult.getVersion());
    assertNull(((AggTsKvEntry) actualToDataResult).getKv());
    assertEquals(1L, actualToDataResult.getTs());
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   *
   * <ul>
   *   <li>Then return Version longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return Version longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  void testToData_thenReturnVersionLongValueIsOne() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity =
        new TsKvLatestEntity(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            1,
            "Str Key",
            null,
            null,
            null,
            null,
            null,
            1L,
            1L);
    tsKvLatestEntity.setAggValuesCount(null);

    // Act
    TsKvEntry actualToDataResult = tsKvLatestEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    assertNull(((BasicTsKvEntry) actualToDataResult).getKv());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getTs());
  }

  /**
   * Test {@link AbstractTsKvEntity#getVersion()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AbstractTsKvEntity.getVersion()"})
  void testGetVersion() {
    // Arrange, Act and Assert
    assertNull(new TimescaleTsKvEntity().getVersion());
  }

  /**
   * Test {@link AbstractTsKvEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractTsKvEntity.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(((AbstractTsKvEntity) new TsKvLatestEntity()).canEqual("Other"));
  }

  /**
   * Test {@link AbstractTsKvEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link TsKvLatestEntity#TsKvLatestEntity()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when TsKvLatestEntity(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractTsKvEntity.canEqual(Object)"})
  void testCanEqual_whenTsKvLatestEntity_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(((AbstractTsKvEntity) new TsKvLatestEntity()).canEqual(new TsKvLatestEntity()));
  }

  /**
   * Test {@link AbstractTsKvEntity#equals(Object)}, and {@link AbstractTsKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractTsKvEntity.equals(Object)",
    "int AbstractTsKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();

    // Act and Assert
    assertEquals(tsKvLatestEntity, tsKvLatestEntity2);
    int expectedHashCodeResult = tsKvLatestEntity.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestEntity2.hashCode());
  }

  /**
   * Test {@link AbstractTsKvEntity#equals(Object)}, and {@link AbstractTsKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractTsKvEntity.equals(Object)",
    "int AbstractTsKvEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act and Assert
    assertEquals(tsKvLatestEntity, tsKvLatestEntity);
    int expectedHashCodeResult = tsKvLatestEntity.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestEntity.hashCode());
  }

  /**
   * Test {@link AbstractTsKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractTsKvEntity.equals(Object)",
    "int AbstractTsKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity =
        new TsKvLatestEntity(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            1,
            "Str Key",
            "42",
            true,
            42L,
            10.0d,
            "42",
            1L,
            1L);

    // Act and Assert
    assertNotEquals(tsKvLatestEntity, new TsKvLatestEntity());
  }

  /**
   * Test {@link AbstractTsKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractTsKvEntity.equals(Object)",
    "int AbstractTsKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvLatestEntity(), null);
  }

  /**
   * Test {@link AbstractTsKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractTsKvEntity.equals(Object)",
    "int AbstractTsKvEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvLatestEntity(), "Different type to AbstractTsKvEntity");
  }

  /**
   * Test {@link AbstractTsKvEntity#setAggValuesCount(Long)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setAggValuesCount(Long)}
   */
  @Test
  @DisplayName("Test setAggValuesCount(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setAggValuesCount(Long)"})
  void testSetAggValuesCount() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setAggValuesCount(3L);

    // Assert
    assertEquals(3L, tsKvLatestEntity.getAggValuesCount().longValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#setAggValuesLastTs(Long)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setAggValuesLastTs(Long)}
   */
  @Test
  @DisplayName("Test setAggValuesLastTs(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setAggValuesLastTs(Long)"})
  void testSetAggValuesLastTs() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setAggValuesLastTs(42L);

    // Assert
    assertEquals(42L, tsKvLatestEntity.getAggValuesLastTs().longValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#setBooleanValue(Boolean)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setBooleanValue(Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanValue(Boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setBooleanValue(Boolean)"})
  void testSetBooleanValue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setBooleanValue(true);

    // Assert
    assertTrue(tsKvLatestEntity.getBooleanValue());
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link AbstractTsKvEntity#setDoubleValue(Double)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setDoubleValue(Double)}
   */
  @Test
  @DisplayName("Test setDoubleValue(Double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setDoubleValue(Double)"})
  void testSetDoubleValue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setDoubleValue(10.0d);

    // Assert
    assertEquals(10.0d, tsKvLatestEntity.getDoubleValue().doubleValue());
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link AbstractTsKvEntity#setEntityId(UUID)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setEntityId(UUID)}
   */
  @Test
  @DisplayName("Test setEntityId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setEntityId(UUID)"})
  void testSetEntityId() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    tsKvLatestEntity.setEntityId(entityId);

    // Assert
    assertSame(entityId, tsKvLatestEntity.getEntityId());
  }

  /**
   * Test {@link AbstractTsKvEntity#setJsonValue(String)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setJsonValue(String)}
   */
  @Test
  @DisplayName("Test setJsonValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setJsonValue(String)"})
  void testSetJsonValue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setJsonValue("42");

    // Assert
    assertEquals("42", tsKvLatestEntity.getJsonValue());
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link AbstractTsKvEntity#setKey(int)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setKey(int)}
   */
  @Test
  @DisplayName("Test setKey(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setKey(int)"})
  void testSetKey() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setKey(1);

    // Assert
    assertEquals(1, tsKvLatestEntity.getKey());
  }

  /**
   * Test {@link AbstractTsKvEntity#setLongValue(Long)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setLongValue(Long)}
   */
  @Test
  @DisplayName("Test setLongValue(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setLongValue(Long)"})
  void testSetLongValue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setLongValue(42L);

    // Assert
    assertEquals(42L, tsKvLatestEntity.getLongValue().longValue());
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link AbstractTsKvEntity#setStrKey(String)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setStrKey(String)}
   */
  @Test
  @DisplayName("Test setStrKey(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setStrKey(String)"})
  void testSetStrKey() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setStrKey("Str Key");

    // Assert
    assertEquals("Str Key", tsKvLatestEntity.getStrKey());
  }

  /**
   * Test {@link AbstractTsKvEntity#setStrValue(String)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setStrValue(String)}
   */
  @Test
  @DisplayName("Test setStrValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setStrValue(String)"})
  void testSetStrValue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setStrValue("42");

    // Assert
    assertEquals("42", tsKvLatestEntity.getStrValue());
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link AbstractTsKvEntity#setTs(Long)}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#setTs(Long)}
   */
  @Test
  @DisplayName("Test setTs(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractTsKvEntity.setTs(Long)"})
  void testSetTs() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setTs(1L);

    // Assert
    TsKvEntry toDataResult = tsKvLatestEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertNull(toDataResult.getVersion());
    assertNull(((BasicTsKvEntry) toDataResult).getKv());
    assertEquals(1L, tsKvLatestEntity.getTs().longValue());
    assertEquals(1L, toDataResult.getTs());
  }

  /**
   * Test {@link AbstractTsKvEntity#toString()}.
   *
   * <p>Method under test: {@link AbstractTsKvEntity#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractTsKvEntity.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TsKvLatestEntity(version=null)", new TsKvLatestEntity().toString());
  }
}
