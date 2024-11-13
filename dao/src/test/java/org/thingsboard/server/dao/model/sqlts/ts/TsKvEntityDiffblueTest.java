package org.thingsboard.server.dao.model.sqlts.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsKvEntityDiffblueTest {
  /**
   * Test {@link TsKvEntity#equals(Object)}, and {@link TsKvEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvEntity#equals(Object)}
   *   <li>{@link TsKvEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
    tsKvEntity2.setEntityId(ModelConstants.NULL_UUID);
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
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvEntity#equals(Object)}
   *   <li>{@link TsKvEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(42L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
    tsKvEntity2.setEntityId(ModelConstants.NULL_UUID);
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
   * <ul>
   *   <li>Then return AggValuesLastTs is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvEntity#TsKvEntity()}
   *   <li>{@link TsKvEntity#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_thenReturnAggValuesLastTsIsNull() {
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
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return StrValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvEntity#TsKvEntity(String, Long)}
   *   <li>{@link TsKvEntity#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_when42_thenReturnStrValueIs42() {
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
   * <ul>
   *   <li>When {@code Agg Type}.</li>
   *   <li>Then return DoubleValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenAggType_thenReturnDoubleValueIsNull() {
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
   * <ul>
   *   <li>When {@code AVG}.</li>
   *   <li>Then return AggValuesCount longValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenAvg_thenReturnAggValuesCountLongValueIsOne() {
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
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(1L, actualTsKvEntity.getAggValuesCount().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   * <ul>
   *   <li>When {@code AVG}.</li>
   *   <li>Then return AggValuesCount longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenAvg_thenReturnAggValuesCountLongValueIsZero() {
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
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(0L, actualTsKvEntity.getAggValuesCount().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   * <ul>
   *   <li>When {@code AVG}.</li>
   *   <li>Then return AggValuesCount longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenAvg_thenReturnAggValuesCountLongValueIsZero2() {
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
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(0L, actualTsKvEntity.getAggValuesCount().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   * <ul>
   *   <li>When {@code AVG}.</li>
   *   <li>Then return AggValuesCount longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenAvg_thenReturnAggValuesCountLongValueIsZero3() {
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
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(0L, actualTsKvEntity.getAggValuesCount().longValue());
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return LongValue longValue is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenFortyTwo_thenReturnLongValueLongValueIsThree() {
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
   * <ul>
   *   <li>When {@code MAX}.</li>
   *   <li>Then return DoubleValue doubleValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenMax_thenReturnDoubleValueDoubleValueIsFortyTwo() {
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
    assertEquals(42.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   * <ul>
   *   <li>When {@code MAX}.</li>
   *   <li>Then return DoubleValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenMax_thenReturnDoubleValueIsNull() {
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
   * <ul>
   *   <li>When {@code MIN}.</li>
   *   <li>Then return DoubleValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenMin_thenReturnDoubleValueIsNull() {
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
   * <ul>
   *   <li>When {@code MIN}.</li>
   *   <li>Then return DoubleValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenMin_thenReturnDoubleValueIsNull2() {
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
   * <ul>
   *   <li>When {@code MIN}.</li>
   *   <li>Then return DoubleValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenMin_thenReturnDoubleValueIsNull3() {
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
   * <ul>
   *   <li>When {@code SUM}.</li>
   *   <li>Then return DoubleValue doubleValue is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenSum_thenReturnDoubleValueDoubleValueIsTen() {
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
    assertEquals(10.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   * <ul>
   *   <li>When {@code SUM}.</li>
   *   <li>Then return DoubleValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenSum_thenReturnDoubleValueIsNull() {
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
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return DoubleValue doubleValue is fifty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenThree_thenReturnDoubleValueDoubleValueIsFiftyTwo() {
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
    assertEquals(52.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return DoubleValue doubleValue is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenThree_thenReturnDoubleValueDoubleValueIsTen() {
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
    assertEquals(10.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(42L, actualTsKvEntity.getAggValuesLastTs().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return LongValue longValue is six.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenZero_thenReturnLongValueLongValueIsSix() {
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
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return LongValue longValue is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenZero_thenReturnLongValueLongValueIsThree() {
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
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return LongValue longValue is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}
   */
  @Test
  public void testNewTsKvEntity_whenZero_thenReturnLongValueLongValueIsThree2() {
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
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} BooleanValue is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  public void testIsNotEmpty_givenTsKvEntityBooleanValueIsTrue_thenReturnTrue() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} DoubleValue is ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  public void testIsNotEmpty_givenTsKvEntityDoubleValueIsTen_thenReturnTrue() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} LongValue is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  public void testIsNotEmpty_givenTsKvEntityLongValueIsOne_thenReturnTrue() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} StrValue is {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  public void testIsNotEmpty_givenTsKvEntityStrValueIsFoo_thenReturnTrue() {
    // Arrange
    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  public void testIsNotEmpty_givenTsKvEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TsKvEntity()).isNotEmpty());
  }
}
