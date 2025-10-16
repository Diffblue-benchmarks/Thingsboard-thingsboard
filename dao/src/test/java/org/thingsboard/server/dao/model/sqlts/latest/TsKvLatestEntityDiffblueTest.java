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
package org.thingsboard.server.dao.model.sqlts.latest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsKvLatestEntityDiffblueTest {
  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} BooleanValue is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTsKvLatestEntityBooleanValueIsTrue_thenReturnTrue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    tsKvLatestEntity.setStrValue(null);
    tsKvLatestEntity.setLongValue(null);
    tsKvLatestEntity.setDoubleValue(null);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} DoubleValue is ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTsKvLatestEntityDoubleValueIsTen_thenReturnTrue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    tsKvLatestEntity.setStrValue(null);
    tsKvLatestEntity.setLongValue(null);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setBooleanValue(null);
    tsKvLatestEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} JsonValue is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTsKvLatestEntityJsonValueIsFoo_thenReturnTrue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    tsKvLatestEntity.setStrValue(null);
    tsKvLatestEntity.setLongValue(null);
    tsKvLatestEntity.setDoubleValue(null);
    tsKvLatestEntity.setBooleanValue(null);
    tsKvLatestEntity.setJsonValue("foo");

    // Act and Assert
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} LongValue is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTsKvLatestEntityLongValueIsOne_thenReturnTrue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    tsKvLatestEntity.setStrValue(null);
    tsKvLatestEntity.setLongValue(1L);
    tsKvLatestEntity.setDoubleValue(null);
    tsKvLatestEntity.setBooleanValue(null);
    tsKvLatestEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()} StrValue is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTsKvLatestEntityStrValueIsFoo_thenReturnTrue() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    tsKvLatestEntity.setStrValue("foo");
    tsKvLatestEntity.setLongValue(null);
    tsKvLatestEntity.setDoubleValue(null);
    tsKvLatestEntity.setBooleanValue(null);
    tsKvLatestEntity.setJsonValue(null);

    // Act and Assert
    assertTrue(tsKvLatestEntity.isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestEntity#TsKvLatestEntity()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#isNotEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.isNotEmpty()"})
  public void testIsNotEmpty_givenTsKvLatestEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TsKvLatestEntity().isNotEmpty());
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}, and {@link TsKvLatestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestEntity#equals(Object)}
   *   <li>{@link TsKvLatestEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(3L);
    tsKvLatestEntity2.setAggValuesLastTs(42L);
    tsKvLatestEntity2.setBooleanValue(true);
    tsKvLatestEntity2.setDoubleValue(10.0d);
    tsKvLatestEntity2.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity2.setJsonValue("42");
    tsKvLatestEntity2.setKey(1);
    tsKvLatestEntity2.setLongValue(42L);
    tsKvLatestEntity2.setStrKey("Str Key");
    tsKvLatestEntity2.setStrValue("42");
    tsKvLatestEntity2.setTs(1L);
    tsKvLatestEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(tsKvLatestEntity, tsKvLatestEntity2);
    assertEquals(tsKvLatestEntity.hashCode(), tsKvLatestEntity2.hashCode());
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}, and {@link TsKvLatestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestEntity#equals(Object)}
   *   <li>{@link TsKvLatestEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(null);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(3L);
    tsKvLatestEntity2.setAggValuesLastTs(42L);
    tsKvLatestEntity2.setBooleanValue(true);
    tsKvLatestEntity2.setDoubleValue(10.0d);
    tsKvLatestEntity2.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity2.setJsonValue("42");
    tsKvLatestEntity2.setKey(1);
    tsKvLatestEntity2.setLongValue(42L);
    tsKvLatestEntity2.setStrKey("Str Key");
    tsKvLatestEntity2.setStrValue("42");
    tsKvLatestEntity2.setTs(1L);
    tsKvLatestEntity2.setVersion(null);

    // Act and Assert
    assertEquals(tsKvLatestEntity, tsKvLatestEntity2);
    assertEquals(tsKvLatestEntity.hashCode(), tsKvLatestEntity2.hashCode());
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}, and {@link TsKvLatestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestEntity#equals(Object)}
   *   <li>{@link TsKvLatestEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    // Act and Assert
    assertEquals(tsKvLatestEntity, tsKvLatestEntity);
    int expectedHashCodeResult = tsKvLatestEntity.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestEntity.hashCode());
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(3L);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(3L);
    tsKvLatestEntity2.setAggValuesLastTs(42L);
    tsKvLatestEntity2.setBooleanValue(true);
    tsKvLatestEntity2.setDoubleValue(10.0d);
    tsKvLatestEntity2.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity2.setJsonValue("42");
    tsKvLatestEntity2.setKey(1);
    tsKvLatestEntity2.setLongValue(42L);
    tsKvLatestEntity2.setStrKey("Str Key");
    tsKvLatestEntity2.setStrValue("42");
    tsKvLatestEntity2.setTs(1L);
    tsKvLatestEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(tsKvLatestEntity, tsKvLatestEntity2);
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(null);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(3L);
    tsKvLatestEntity2.setAggValuesLastTs(42L);
    tsKvLatestEntity2.setBooleanValue(true);
    tsKvLatestEntity2.setDoubleValue(10.0d);
    tsKvLatestEntity2.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity2.setJsonValue("42");
    tsKvLatestEntity2.setKey(1);
    tsKvLatestEntity2.setLongValue(42L);
    tsKvLatestEntity2.setStrKey("Str Key");
    tsKvLatestEntity2.setStrValue("42");
    tsKvLatestEntity2.setTs(1L);
    tsKvLatestEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(tsKvLatestEntity, tsKvLatestEntity2);
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(tsKvLatestEntity, null);
  }

  /**
   * Test {@link TsKvLatestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TsKvLatestEntity.equals(Object)", "int TsKvLatestEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(tsKvLatestEntity, "Different type to TsKvLatestEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestEntity#TsKvLatestEntity(UUID, Integer, String, String, Boolean, Long,
   *       Double, String, Long, Long)}
   *   <li>{@link TsKvLatestEntity#setVersion(Long)}
   *   <li>{@link TsKvLatestEntity#toString()}
   *   <li>{@link TsKvLatestEntity#getVersion()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TsKvLatestEntity.<init>()",
    "void TsKvLatestEntity.<init>(UUID, Integer, String, String, Boolean, Long, Double, String, Long, Long)",
    "Long TsKvLatestEntity.getVersion()",
    "void TsKvLatestEntity.setVersion(Long)",
    "String TsKvLatestEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    TsKvLatestEntity actualTsKvLatestEntity =
        new TsKvLatestEntity(entityId, 1, "Str Key", "42", true, 42L, 10.0d, "42", 1L, 1L);
    actualTsKvLatestEntity.setVersion(1L);
    String actualToStringResult = actualTsKvLatestEntity.toString();
    Long actualVersion = actualTsKvLatestEntity.getVersion();

    // Assert
    UUID entityId2 = actualTsKvLatestEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId2.toString());
    assertEquals("42", actualTsKvLatestEntity.getJsonValue());
    assertEquals("42", actualTsKvLatestEntity.getStrValue());
    assertEquals("Str Key", actualTsKvLatestEntity.getStrKey());
    assertEquals("TsKvLatestEntity(version=1)", actualToStringResult);
    assertNull(actualTsKvLatestEntity.getAggValuesCount());
    assertNull(actualTsKvLatestEntity.getAggValuesLastTs());
    assertEquals(1, actualTsKvLatestEntity.getKey());
    assertEquals(10.0d, actualTsKvLatestEntity.getDoubleValue().doubleValue(), 0.0);
    assertEquals(1L, actualTsKvLatestEntity.getTs().longValue());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(42L, actualTsKvLatestEntity.getLongValue().longValue());
    assertTrue(actualTsKvLatestEntity.getBooleanValue());
    assertSame(entityId, entityId2);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return BooleanValue is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestEntity#TsKvLatestEntity()}
   *   <li>{@link TsKvLatestEntity#setVersion(Long)}
   *   <li>{@link TsKvLatestEntity#toString()}
   *   <li>{@link TsKvLatestEntity#getVersion()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TsKvLatestEntity.<init>()",
    "void TsKvLatestEntity.<init>(UUID, Integer, String, String, Boolean, Long, Double, String, Long, Long)",
    "Long TsKvLatestEntity.getVersion()",
    "void TsKvLatestEntity.setVersion(Long)",
    "String TsKvLatestEntity.toString()"
  })
  public void testGettersAndSetters_thenReturnBooleanValueIsNull() {
    // Arrange and Act
    TsKvLatestEntity actualTsKvLatestEntity = new TsKvLatestEntity();
    actualTsKvLatestEntity.setVersion(1L);
    String actualToStringResult = actualTsKvLatestEntity.toString();
    Long actualVersion = actualTsKvLatestEntity.getVersion();

    // Assert
    assertEquals("TsKvLatestEntity(version=1)", actualToStringResult);
    assertNull(actualTsKvLatestEntity.getBooleanValue());
    assertNull(actualTsKvLatestEntity.getDoubleValue());
    assertNull(actualTsKvLatestEntity.getAggValuesCount());
    assertNull(actualTsKvLatestEntity.getAggValuesLastTs());
    assertNull(actualTsKvLatestEntity.getLongValue());
    assertNull(actualTsKvLatestEntity.getTs());
    assertNull(actualTsKvLatestEntity.getJsonValue());
    assertNull(actualTsKvLatestEntity.getStrKey());
    assertNull(actualTsKvLatestEntity.getStrValue());
    assertNull(actualTsKvLatestEntity.getEntityId());
    assertEquals(0, actualTsKvLatestEntity.getKey());
    assertEquals(1L, actualVersion.longValue());
  }
}
