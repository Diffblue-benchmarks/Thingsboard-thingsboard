/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.model.sqlts.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsKvEntityDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvEntity.equals(Object)", "int TsKvEntity.hashCode()"})
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
    assertEquals(tsKvEntity.hashCode(), tsKvEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvEntity.equals(Object)", "int TsKvEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvEntity.equals(Object)", "int TsKvEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvEntity.equals(Object)", "int TsKvEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvEntity.equals(Object)", "int TsKvEntity.hashCode()"})
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TsKvEntity.<init>()",
    "void TsKvEntity.<init>(String, Long)",
    "String TsKvEntity.toString()"
  })
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TsKvEntity.<init>()",
    "void TsKvEntity.<init>(String, Long)",
    "String TsKvEntity.toString()"
  })
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
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then return AggValuesCount longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenAvg_thenReturnAggValuesCountLongValueIsOne() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 0L, 1L, "AVG", 42L);

    // Assert
    assertNull(actualTsKvEntity.getLongValue());
    assertEquals(1L, actualTsKvEntity.getAggValuesCount().longValue());
    assertEquals(52.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then return DoubleValue doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenAvg_thenReturnDoubleValueDoubleValueIsZero() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 0L, 0L, "AVG", 42L);

    // Assert
    assertNull(actualTsKvEntity.getLongValue());
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(0L, actualTsKvEntity.getAggValuesCount().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then return DoubleValue doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenAvg_thenReturnDoubleValueDoubleValueIsZero2() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, null, 0L, 0L, "AVG", 42L);

    // Assert
    assertNull(actualTsKvEntity.getLongValue());
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(0L, actualTsKvEntity.getAggValuesCount().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then return DoubleValue doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenAvg_thenReturnDoubleValueDoubleValueIsZero3() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, 10.0d, 0L, 0L, "AVG", 42L);

    // Assert
    assertNull(actualTsKvEntity.getLongValue());
    assertEquals(0.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(0L, actualTsKvEntity.getAggValuesCount().longValue());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Long, Long, Long, Long, Long)"})
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
   *
   * <ul>
   *   <li>When {@code MAX}.
   *   <li>Then return DoubleValue doubleValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenMax_thenReturnDoubleValueDoubleValueIsFortyTwo() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 1L, 1L, "MAX", 42L);

    // Assert
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertEquals(42.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MAX}.
   *   <li>Then return not NotEmpty.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenMax_thenReturnNotNotEmpty() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 0L, 0L, "MAX", 42L);

    // Assert
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertFalse(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return DoubleValue doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenMin_thenReturnDoubleValueDoubleValueIsTen() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 0L, 1L, "MIN", 42L);

    // Assert
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertEquals(10.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return DoubleValue doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenMin_thenReturnDoubleValueDoubleValueIsTen2() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 1L, 1L, "MIN", 42L);

    // Assert
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertEquals(10.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return LongValue longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenMin_thenReturnLongValueLongValueIsFortyTwo() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 1L, 0L, "MIN", 42L);

    // Assert
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertEquals(42L, actualTsKvEntity.getLongValue().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then return not NotEmpty.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenMin_thenReturnNotNotEmpty() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 0L, 0L, "MIN", 42L);

    // Assert
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertFalse(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code SUM}.
   *   <li>Then return DoubleValue doubleValue is fifty-two.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenSum_thenReturnDoubleValueDoubleValueIsFiftyTwo() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 0L, 1L, "SUM", 42L);

    // Assert
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertEquals(52.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertTrue(actualTsKvEntity.isNotEmpty());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenSum_thenReturnDoubleValueDoubleValueIsTen() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(null, 10.0d, 0L, 1L, "SUM", 42L);

    // Assert
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertEquals(10.0d, actualTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When {@code SUM}.
   *   <li>Then return LongValue longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenSum_thenReturnLongValueLongValueIsFortyTwo() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 0L, 0L, "SUM", 42L);

    // Assert
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertEquals(42L, actualTsKvEntity.getLongValue().longValue());
    assertTrue(actualTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return not NotEmpty.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Double, Long, Long, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Double, Long, Long, String, Long)"})
  public void testNewTsKvEntity_whenThree_thenReturnNotNotEmpty() {
    // Arrange and Act
    TsKvEntity actualTsKvEntity = new TsKvEntity(42L, 10.0d, 3L, 3L, "Agg Type", 42L);

    // Assert
    assertNull(actualTsKvEntity.getDoubleValue());
    assertNull(actualTsKvEntity.getAggValuesCount());
    assertNull(actualTsKvEntity.getLongValue());
    assertFalse(actualTsKvEntity.isNotEmpty());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Long, Long, Long, Long, Long)"})
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
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return LongValue longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Long, Long, Long, Long, Long)"})
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
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return LongValue longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#TsKvEntity(Long, Long, Long, Long, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TsKvEntity.<init>(Long, Long, Long, Long, Long, Long)"})
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
   *
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} DoubleValue is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTsKvEntityDoubleValueIsNull_thenReturnTrue() {
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
   *
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} LongValue is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTsKvEntityLongValueIsNull_thenReturnTrue() {
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
    tsKvEntity.setBooleanValue(true);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvEntity.isNotEmpty()"})
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
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setBooleanValue(true);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvEntity.isNotEmpty()"})
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
    tsKvEntity.setLongValue(1L);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setBooleanValue(true);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTsKvEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TsKvEntity().isNotEmpty());
  }
}
