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
package org.thingsboard.server.dao.model.sqlts.timescale.ts;

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
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.model.ModelConstants;

public class TimescaleTsKvEntityDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvEntity.equals(Object)",
    "int TimescaleTsKvEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
    timescaleTsKvEntity2.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity2.setJsonValue("42");
    timescaleTsKvEntity2.setKey(1);
    timescaleTsKvEntity2.setLongValue(42L);
    timescaleTsKvEntity2.setStrKey("Str Key");
    timescaleTsKvEntity2.setStrValue("42");
    timescaleTsKvEntity2.setTs(1L);

    // Act and Assert
    assertEquals(timescaleTsKvEntity, timescaleTsKvEntity2);
    assertEquals(timescaleTsKvEntity.hashCode(), timescaleTsKvEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvEntity.equals(Object)",
    "int TimescaleTsKvEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvEntity.equals(Object)",
    "int TimescaleTsKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(42L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
    timescaleTsKvEntity2.setEntityId(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvEntity.equals(Object)",
    "int TimescaleTsKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TimescaleTsKvEntity.equals(Object)",
    "int TimescaleTsKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimescaleTsKvEntity.<init>()", "String TimescaleTsKvEntity.toString()"})
  public void testGettersAndSetters() {
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
   *   <li>When {@code AVG}.
   *   <li>Then return AggValuesCount longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenAvg_thenReturnAggValuesCountLongValueIsOne() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 0L, 1L, "", "AVG", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
    assertEquals(1L, actualTimescaleTsKvEntity.getAggValuesCount().longValue());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code AVG}.
   *   <li>Then toData return {@link AggTsKvEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenAvg_thenToDataReturnAggTsKvEntry() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 0L, 0L, "", "AVG", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Long, Long, Long, Long, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenFortyTwo_thenToDataKvReturnLongDataEntry() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 3L, 3L, 3L, 3L, 3L, 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof LongDataEntry);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenMax_thenReturnDoubleValueIsNull() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 0L, 0L, "", "MAX", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertNull(actualTimescaleTsKvEntity.getDoubleValue());
    assertNull(actualTimescaleTsKvEntity.getAggValuesCount());
    assertNull(((BasicTsKvEntry) toDataResult).getKv());
    assertFalse(actualTimescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MAX}.
   *   <li>Then return toData ValueAsString is {@code 42.0}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenMax_thenReturnToDataValueAsStringIs420() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 1L, 1L, "", "MAX", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertEquals("42.0", toDataResult.getValueAsString());
    assertEquals(42.0d, actualTimescaleTsKvEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(42.0d, ((Double) toDataResult.getValue()).doubleValue(), 0.0);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenMin_thenReturnDoubleValueIsNull() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 0L, 0L, "", "MIN", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertNull(actualTimescaleTsKvEntity.getDoubleValue());
    assertNull(actualTimescaleTsKvEntity.getAggValuesCount());
    assertNull(((BasicTsKvEntry) toDataResult).getKv());
    assertFalse(actualTimescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then toData Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenMin_thenToDataKvReturnDoubleDataEntry() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 0L, 1L, "", "MIN", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then toData Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenMin_thenToDataKvReturnDoubleDataEntry2() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 1L, 1L, "", "MIN", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code MIN}.
   *   <li>Then toData Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenMin_thenToDataKvReturnLongDataEntry() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 1L, 0L, "", "MIN", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof LongDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then toData return {@link AggTsKvEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenNull_thenToDataReturnAggTsKvEntry() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 0L, 0L, null, "AVG", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then toData return {@link AggTsKvEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenNull_thenToDataReturnAggTsKvEntry2() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, null, 0L, 0L, "", "AVG", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then toData return {@link AggTsKvEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenNull_thenToDataReturnAggTsKvEntry3() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, null, 10.0d, 0L, 0L, "", "AVG", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code SUM}.
   *   <li>Then return toData toTsValue Value is {@code 52.0}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenSum_thenReturnToDataToTsValueValueIs520() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 0L, 1L, "", "SUM", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof DoubleDataEntry);
    assertEquals("52.0", toDataResult.toTsValue().getValue());
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code SUM}.
   *   <li>Then toData Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenSum_thenToDataKvReturnLongDataEntry() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 0L, 0L, "", "SUM", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof LongDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double, Long, Long,
   * String, String, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then toData Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#TimescaleTsKvEntity(Long, Long, Long, Double,
   * Long, Long, String, String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Double, Long, Long, String, String, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenThree_thenToDataKvReturnStringDataEntry() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 42L, 10.0d, 3L, 3L, "42", "Agg Type", 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
    assertEquals("42", actualTimescaleTsKvEntity.getStrValue());
    assertEquals("42", toDataResult.getValue());
    assertEquals(DataType.STRING, toDataResult.getDataType());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Long, Long, Long, Long, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenZero_thenReturnToDataValueAsStringIs6() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Long, Long, Long, Long, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenZero_thenToDataKvReturnLongDataEntry() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 0L, 3L, 3L, 3L, 3L, 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimescaleTsKvEntity.<init>(Long, Long, Long, Long, Long, Long, Long, Long)"
  })
  public void testNewTimescaleTsKvEntity_whenZero_thenToDataKvReturnLongDataEntry2() {
    // Arrange and Act
    TimescaleTsKvEntity actualTimescaleTsKvEntity =
        new TimescaleTsKvEntity(1L, 42L, 0L, 0L, 3L, 3L, 3L, 42L);

    // Assert
    TsKvEntry toDataResult = actualTimescaleTsKvEntity.toData();
    assertTrue(toDataResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) toDataResult).getKv() instanceof LongDataEntry);
  }

  /**
   * Test {@link TimescaleTsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} BooleanValue is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTimescaleTsKvEntityBooleanValueIsNull_thenReturnTrue() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} DoubleValue is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTimescaleTsKvEntityDoubleValueIsNull_thenReturnTrue() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setTs(1L);
    timescaleTsKvEntity.setStrValue(null);
    timescaleTsKvEntity.setLongValue(null);
    timescaleTsKvEntity.setDoubleValue(null);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setJsonValue("foo");

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTimescaleTsKvEntityDoubleValueIsTen_thenReturnTrue() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setTs(1L);
    timescaleTsKvEntity.setStrValue(null);
    timescaleTsKvEntity.setLongValue(null);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setJsonValue("foo");

    // Act and Assert
    assertTrue(timescaleTsKvEntity.isNotEmpty());
  }

  /**
   * Test {@link TimescaleTsKvEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} JsonValue is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTimescaleTsKvEntityJsonValueIsNull_thenReturnFalse() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
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
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} LongValue is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTimescaleTsKvEntityLongValueIsOne_thenReturnTrue() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setTs(1L);
    timescaleTsKvEntity.setStrValue(null);
    timescaleTsKvEntity.setLongValue(1L);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setJsonValue("foo");

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTimescaleTsKvEntityStrValueIsFoo_thenReturnTrue() {
    // Arrange
    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setTs(1L);
    timescaleTsKvEntity.setStrValue("foo");
    timescaleTsKvEntity.setLongValue(1L);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setJsonValue("foo");

    // Act and Assert
    assertTrue(timescaleTsKvEntity.isNotEmpty());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimescaleTsKvEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTimescaleTsKvEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TimescaleTsKvEntity().isNotEmpty());
  }
}
