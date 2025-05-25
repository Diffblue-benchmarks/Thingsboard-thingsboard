package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import org.thingsboard.server.common.data.query.TsValue;
import org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestEntity;
import org.thingsboard.server.dao.model.sqlts.timescale.ts.TimescaleTsKvEntity;

public class AbstractTsKvEntityDiffblueTest {
  /**
   * Test {@link AbstractTsKvEntity#getAggValuesCount()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getAggValuesCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long AbstractTsKvEntity.getAggValuesCount()"})
  public void testGetAggValuesCount() {
    // Arrange, Act and Assert
    assertNull((new TsKvLatestEntity()).getAggValuesCount());
  }

  /**
   * Test {@link AbstractTsKvEntity#getAggValuesLastTs()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getAggValuesLastTs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long AbstractTsKvEntity.getAggValuesLastTs()"})
  public void testGetAggValuesLastTs() {
    // Arrange, Act and Assert
    assertNull((new TsKvLatestEntity()).getAggValuesLastTs());
  }

  /**
   * Test {@link AbstractTsKvEntity#getBooleanValue()}.
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getBooleanValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AbstractTsKvEntity.getBooleanValue()"})
  public void testGetBooleanValue_givenTsKvLatestEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TsKvLatestEntity()).getBooleanValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getBooleanValue()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getBooleanValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AbstractTsKvEntity.getBooleanValue()"})
  public void testGetBooleanValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TsKvLatestEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, "Str Key", "42",
        false, 42L, 10.0d, "42", 1L, 1L)).getBooleanValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getBooleanValue()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getBooleanValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AbstractTsKvEntity.getBooleanValue()"})
  public void testGetBooleanValue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new TsKvLatestEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, "Str Key", "42", true,
        42L, 10.0d, "42", 1L, 1L)).getBooleanValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getDoubleValue()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getDoubleValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Double AbstractTsKvEntity.getDoubleValue()"})
  public void testGetDoubleValue() {
    // Arrange, Act and Assert
    assertNull((new TsKvLatestEntity()).getDoubleValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getEntityId()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getEntityId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID AbstractTsKvEntity.getEntityId()"})
  public void testGetEntityId() {
    // Arrange, Act and Assert
    assertNull((new TsKvLatestEntity()).getEntityId());
  }

  /**
   * Test {@link AbstractTsKvEntity#getJsonValue()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getJsonValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTsKvEntity.getJsonValue()"})
  public void testGetJsonValue() {
    // Arrange, Act and Assert
    assertNull((new TsKvLatestEntity()).getJsonValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getKey()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AbstractTsKvEntity.getKey()"})
  public void testGetKey() {
    // Arrange, Act and Assert
    assertEquals(0, (new TsKvLatestEntity()).getKey());
  }

  /**
   * Test {@link AbstractTsKvEntity#getLongValue()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getLongValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long AbstractTsKvEntity.getLongValue()"})
  public void testGetLongValue() {
    // Arrange, Act and Assert
    assertNull((new TsKvLatestEntity()).getLongValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getStrKey()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getStrKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTsKvEntity.getStrKey()"})
  public void testGetStrKey() {
    // Arrange, Act and Assert
    assertNull((new TsKvLatestEntity()).getStrKey());
  }

  /**
   * Test {@link AbstractTsKvEntity#getStrValue()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getStrValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTsKvEntity.getStrValue()"})
  public void testGetStrValue() {
    // Arrange, Act and Assert
    assertNull((new TsKvLatestEntity()).getStrValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getTs()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getTs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long AbstractTsKvEntity.getTs()"})
  public void testGetTs() {
    // Arrange, Act and Assert
    assertNull((new TsKvLatestEntity()).getTs());
  }

  /**
   * Test {@link AbstractTsKvEntity#isAllNull(Object[])}.
   * <ul>
   *   <li>When {@code Args}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#isAllNull(Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTsKvEntity.isAllNull(Object[])"})
  public void testIsAllNull_whenArgs_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AbstractTsKvEntity.isAllNull("Args"));
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  public void testToData() {
    // Arrange and Act
    TsKvEntry actualToDataResult = (new TsKvLatestEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1,
        "Str Key", "42", true, 42L, 10.0d, "42", 1L, 1L)).toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) actualToDataResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} AggValuesCount is three.</li>
   *   <li>Then return {@link AggTsKvEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  public void testToData_givenTsKvLatestEntityAggValuesCountIsThree_thenReturnAggTsKvEntry() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    // Act
    TsKvEntry actualToDataResult = tsKvLatestEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) actualToDataResult).getKv() instanceof StringDataEntry);
    TsValue toTsValueResult = actualToDataResult.toTsValue();
    assertEquals("42", toTsValueResult.getValue());
    assertEquals(1L, toTsValueResult.getTs());
    assertEquals(3L, toTsValueResult.getCount().longValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} Ts is one.</li>
   *   <li>Then return Version is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  public void testToData_givenTsKvLatestEntityTsIsOne_thenReturnVersionIsNull() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setTs(1L);

    // Act
    TsKvEntry actualToDataResult = tsKvLatestEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    assertNull(actualToDataResult.getVersion());
    assertNull(((BasicTsKvEntry) actualToDataResult).getKv());
    assertEquals(1L, actualToDataResult.getTs());
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   * <ul>
   *   <li>Then Kv return {@link BooleanDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  public void testToData_thenKvReturnBooleanDataEntry() {
    // Arrange and Act
    TsKvEntry actualToDataResult = (new TsKvLatestEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1,
        "Str Key", null, true, null, null, "42", 1L, 1L)).toData();

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
   * <ul>
   *   <li>Then Kv return {@link DoubleDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  public void testToData_thenKvReturnDoubleDataEntry() {
    // Arrange and Act
    TsKvEntry actualToDataResult = (new TsKvLatestEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1,
        "Str Key", null, true, null, 10.0d, "42", 1L, 1L)).toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) actualToDataResult).getKv() instanceof DoubleDataEntry);
    assertEquals("10.0", actualToDataResult.getValueAsString());
    assertEquals(10.0d, ((Double) actualToDataResult.getValue()).doubleValue(), 0.0);
    assertEquals(DataType.DOUBLE, actualToDataResult.getDataType());
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   * <ul>
   *   <li>Then Kv return {@link JsonDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  public void testToData_thenKvReturnJsonDataEntry() {
    // Arrange and Act
    TsKvEntry actualToDataResult = (new TsKvLatestEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1,
        "Str Key", null, null, null, null, "42", 1L, 1L)).toData();

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
   * <ul>
   *   <li>Then Kv return {@link LongDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TsKvEntry AbstractTsKvEntity.toData()"})
  public void testToData_thenKvReturnLongDataEntry() {
    // Arrange and Act
    TsKvEntry actualToDataResult = (new TsKvLatestEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1,
        "Str Key", null, true, 42L, 10.0d, "42", 1L, 1L)).toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) actualToDataResult).getKv() instanceof LongDataEntry);
    assertEquals(42L, ((Long) actualToDataResult.getValue()).longValue());
    assertEquals(DataType.LONG, actualToDataResult.getDataType());
  }

  /**
   * Test {@link AbstractTsKvEntity#getVersion()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long AbstractTsKvEntity.getVersion()"})
  public void testGetVersion() {
    // Arrange, Act and Assert
    assertNull((new TimescaleTsKvEntity()).getVersion());
  }

  /**
   * Test {@link AbstractTsKvEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#canEqual(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTsKvEntity.canEqual(Object)"})
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(((AbstractTsKvEntity) new TsKvLatestEntity()).canEqual("Other"));
  }

  /**
   * Test {@link AbstractTsKvEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@link TsKvLatestEntity#TsKvLatestEntity()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#canEqual(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTsKvEntity.canEqual(Object)"})
  public void testCanEqual_whenTsKvLatestEntity_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(((AbstractTsKvEntity) new TsKvLatestEntity()).canEqual(new TsKvLatestEntity()));
  }

  /**
   * Test {@link AbstractTsKvEntity#equals(Object)}, and {@link AbstractTsKvEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTsKvEntity.equals(Object)", "int AbstractTsKvEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTsKvEntity.equals(Object)", "int AbstractTsKvEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act and Assert
    assertEquals(tsKvLatestEntity, tsKvLatestEntity);
    int expectedHashCodeResult = tsKvLatestEntity.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestEntity.hashCode());
  }

  /**
   * Test {@link AbstractTsKvEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTsKvEntity.equals(Object)", "int AbstractTsKvEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1,
        "Str Key", "42", true, 42L, 10.0d, "42", 1L, 1L);

    // Act and Assert
    assertNotEquals(tsKvLatestEntity, new TsKvLatestEntity());
  }

  /**
   * Test {@link AbstractTsKvEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTsKvEntity.equals(Object)", "int AbstractTsKvEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvLatestEntity(), null);
  }

  /**
   * Test {@link AbstractTsKvEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTsKvEntity.equals(Object)", "int AbstractTsKvEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvLatestEntity(), "Different type to AbstractTsKvEntity");
  }

  /**
   * Test {@link AbstractTsKvEntity#setAggValuesCount(Long)}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setAggValuesCount(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setAggValuesCount(Long)"})
  public void testSetAggValuesCount() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setAggValuesCount(3L);

    // Assert
    assertEquals(3L, tsKvLatestEntity.getAggValuesCount().longValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#setAggValuesLastTs(Long)}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setAggValuesLastTs(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setAggValuesLastTs(Long)"})
  public void testSetAggValuesLastTs() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setAggValuesLastTs(42L);

    // Assert
    assertEquals(42L, tsKvLatestEntity.getAggValuesLastTs().longValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#setBooleanValue(Boolean)}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setBooleanValue(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setBooleanValue(Boolean)"})
  public void testSetBooleanValue() {
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
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setDoubleValue(Double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setDoubleValue(Double)"})
  public void testSetDoubleValue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setDoubleValue(10.0d);

    // Assert
    assertEquals(10.0d, tsKvLatestEntity.getDoubleValue().doubleValue(), 0.0);
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link AbstractTsKvEntity#setEntityId(UUID)}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setEntityId(UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setEntityId(UUID)"})
  public void testSetEntityId() {
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
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setJsonValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setJsonValue(String)"})
  public void testSetJsonValue() {
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
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setKey(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setKey(int)"})
  public void testSetKey() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setKey(1);

    // Assert
    assertEquals(1, tsKvLatestEntity.getKey());
  }

  /**
   * Test {@link AbstractTsKvEntity#setLongValue(Long)}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setLongValue(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setLongValue(Long)"})
  public void testSetLongValue() {
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
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setStrKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setStrKey(String)"})
  public void testSetStrKey() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();

    // Act
    tsKvLatestEntity.setStrKey("Str Key");

    // Assert
    assertEquals("Str Key", tsKvLatestEntity.getStrKey());
  }

  /**
   * Test {@link AbstractTsKvEntity#setStrValue(String)}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setStrValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setStrValue(String)"})
  public void testSetStrValue() {
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
   * <p>
   * Method under test: {@link AbstractTsKvEntity#setTs(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractTsKvEntity.setTs(Long)"})
  public void testSetTs() {
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
   * <p>
   * Method under test: {@link AbstractTsKvEntity#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractTsKvEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("TsKvLatestEntity(version=null)", (new TsKvLatestEntity()).toString());
  }
}
