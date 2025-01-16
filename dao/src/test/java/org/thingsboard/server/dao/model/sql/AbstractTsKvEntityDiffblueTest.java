package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.query.TsValue;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestEntity;
import org.thingsboard.server.dao.model.sqlts.timescale.ts.TimescaleTsKvEntity;

public class AbstractTsKvEntityDiffblueTest {
  /**
   * Test {@link AbstractTsKvEntity#getAggValuesCount()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getAggValuesCount()}
   */
  @Test
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
  public void testGetBooleanValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TsKvLatestEntity(ModelConstants.NULL_UUID, 1, "Str Key", "42", false, 42L, 10.0d, "42", 1L, 1L))
        .getBooleanValue());
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
  public void testGetBooleanValue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new TsKvLatestEntity(ModelConstants.NULL_UUID, 1, "Str Key", "42", true, 42L, 10.0d, "42", 1L, 1L))
        .getBooleanValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#getDoubleValue()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getDoubleValue()}
   */
  @Test
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
  public void testIsAllNull_whenArgs_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AbstractTsKvEntity.isAllNull("Args"));
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   * <ul>
   *   <li>Then return {@link AggTsKvEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  public void testToData_thenReturnAggTsKvEntry() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity(ModelConstants.NULL_UUID, 1, "Str Key", "42", true, 42L,
        10.0d, "42", 1L, 1L);
    tsKvLatestEntity.setAggValuesCount(3L);

    // Act
    TsKvEntry actualToDataResult = tsKvLatestEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof AggTsKvEntry);
    TsValue toTsValueResult = actualToDataResult.toTsValue();
    assertEquals("42", toTsValueResult.getValue());
    assertNull(actualToDataResult.getVersion());
    assertEquals(1L, toTsValueResult.getTs());
    assertEquals(3L, toTsValueResult.getCount().longValue());
  }

  /**
   * Test {@link AbstractTsKvEntity#toData()}.
   * <ul>
   *   <li>Then return {@link BasicTsKvEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#toData()}
   */
  @Test
  public void testToData_thenReturnBasicTsKvEntry() {
    // Arrange and Act
    TsKvEntry actualToDataResult = (new TsKvLatestEntity(ModelConstants.NULL_UUID, 1, "Str Key", "42", true, 42L, 10.0d,
        "42", 1L, 1L)).toData();

    // Assert
    assertTrue(actualToDataResult instanceof BasicTsKvEntry);
    TsValue toTsValueResult = actualToDataResult.toTsValue();
    assertEquals("42", toTsValueResult.getValue());
    assertNull(toTsValueResult.getCount());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, toTsValueResult.getTs());
  }

  /**
   * Test {@link AbstractTsKvEntity#getVersion()}.
   * <p>
   * Method under test: {@link AbstractTsKvEntity#getVersion()}
   */
  @Test
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
  public void testCanEqual_whenTsKvLatestEntity_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(((AbstractTsKvEntity) new TsKvLatestEntity()).canEqual(new TsKvLatestEntity()));
  }

  /**
   * Test {@link AbstractTsKvEntity#equals(Object)}, and
   * {@link AbstractTsKvEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
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
   * Test {@link AbstractTsKvEntity#equals(Object)}, and
   * {@link AbstractTsKvEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTsKvEntity#equals(Object)}
   */
  @Test
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
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity(ModelConstants.NULL_UUID, 1, "Str Key", "42", true, 42L,
        10.0d, "42", 1L, 1L);

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
  public void testSetEntityId() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    UUID entityId = ModelConstants.NULL_UUID;

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
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("TsKvLatestEntity(version=null)", (new TsKvLatestEntity()).toString());
  }
}
