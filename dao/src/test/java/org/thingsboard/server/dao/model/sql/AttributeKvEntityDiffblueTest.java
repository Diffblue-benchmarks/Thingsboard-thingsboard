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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.dao.model.ModelConstants;

public class AttributeKvEntityDiffblueTest {
  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) BooleanValue is {@code true}.
   *   <li>Then Kv return {@link BooleanDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  public void testToData_givenAttributeKvEntityBooleanValueIsTrue_thenKvReturnBooleanDataEntry() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setJsonValue(null);

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) actualToDataResult).getKv() instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, actualToDataResult.getDataType());
    Optional<Double> doubleValue = actualToDataResult.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    assertTrue((Boolean) actualToDataResult.getValue());
    assertEquals(Boolean.TRUE.toString(), actualToDataResult.getValueAsString());
    assertSame(doubleValue, actualToDataResult.getJsonValue());
    assertSame(doubleValue, actualToDataResult.getLongValue());
    assertSame(doubleValue, actualToDataResult.getStrValue());
  }

  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) DoubleValue is ten.
   *   <li>Then Kv return {@link DoubleDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  public void testToData_givenAttributeKvEntityDoubleValueIsTen_thenKvReturnDoubleDataEntry() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setJsonValue(null);

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) actualToDataResult).getKv();
    assertTrue(kv instanceof DoubleDataEntry);
    assertEquals("10.0", kv.getValueAsString());
    assertEquals("10.0", actualToDataResult.getValueAsString());
    Optional<Double> doubleValue = actualToDataResult.getDoubleValue();
    assertEquals(10.0d, doubleValue.get().doubleValue(), 0.0);
    assertEquals(10.0d, ((Double) kv.getValue()).doubleValue(), 0.0);
    assertEquals(10.0d, ((Double) actualToDataResult.getValue()).doubleValue(), 0.0);
    assertEquals(DataType.DOUBLE, kv.getDataType());
    assertEquals(DataType.DOUBLE, actualToDataResult.getDataType());
    assertTrue(doubleValue.isPresent());
    assertEquals(doubleValue, kv.getDoubleValue());
  }

  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) JsonValue is {@code foo}.
   *   <li>Then Kv return {@link JsonDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  public void testToData_givenAttributeKvEntityJsonValueIsFoo_thenKvReturnJsonDataEntry() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setJsonValue("foo");

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) actualToDataResult).getKv();
    assertTrue(kv instanceof JsonDataEntry);
    Optional<String> jsonValue = actualToDataResult.getJsonValue();
    assertEquals("foo", jsonValue.get());
    assertEquals("foo", kv.getValueAsString());
    assertEquals("foo", kv.getValue());
    assertEquals(DataType.JSON, kv.getDataType());
    assertEquals(DataType.JSON, actualToDataResult.getDataType());
    assertTrue(jsonValue.isPresent());
    assertEquals(jsonValue, kv.getJsonValue());
  }

  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) LongValue is one.
   *   <li>Then Kv return {@link LongDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  public void testToData_givenAttributeKvEntityLongValueIsOne_thenKvReturnLongDataEntry() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setLongValue(1L);
    attributeKvEntity.setJsonValue(null);

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) actualToDataResult).getKv();
    assertTrue(kv instanceof LongDataEntry);
    assertEquals("1", kv.getValueAsString());
    assertEquals("1", actualToDataResult.getValueAsString());
    Optional<Long> longValue = actualToDataResult.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(1L, ((Long) kv.getValue()).longValue());
    assertEquals(1L, ((Long) actualToDataResult.getValue()).longValue());
    assertEquals(DataType.LONG, kv.getDataType());
    assertEquals(DataType.LONG, actualToDataResult.getDataType());
    assertTrue(longValue.isPresent());
    assertEquals(longValue, kv.getLongValue());
  }

  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) StrValue is {@code foo}.
   *   <li>Then Kv return {@link StringDataEntry}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  public void testToData_givenAttributeKvEntityStrValueIsFoo_thenKvReturnStringDataEntry() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue("foo");
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setJsonValue(null);

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) actualToDataResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    Optional<String> strValue = actualToDataResult.getStrValue();
    assertEquals("foo", strValue.get());
    assertEquals("foo", kv.getValueAsString());
    assertEquals("foo", kv.getValue());
    assertEquals(DataType.STRING, kv.getDataType());
    assertEquals(DataType.STRING, actualToDataResult.getDataType());
    assertTrue(strValue.isPresent());
    assertEquals(strValue, kv.getStrValue());
  }

  /**
   * Test {@link AttributeKvEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) StrValue is {@code null}.
   *   <li>Then return Kv is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeKvEntry AttributeKvEntity.toData()"})
  public void testToData_givenAttributeKvEntityStrValueIsNull_thenReturnKvIsNull() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setId(id);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setVersion(1L);
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setJsonValue(null);

    // Act
    AttributeKvEntry actualToDataResult = attributeKvEntity.toData();

    // Assert
    assertTrue(actualToDataResult instanceof BaseAttributeKvEntry);
    assertNull(((BaseAttributeKvEntry) actualToDataResult).getKv());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getLastUpdateTs());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(null);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(null);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue(null);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue(null);
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(null);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(null);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(null);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey(null);
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey(null);
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity2);
    assertEquals(attributeKvEntity.hashCode(), attributeKvEntity2.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}, and {@link AttributeKvEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvEntity#equals(Object)}
   *   <li>{@link AttributeKvEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    // Act and Assert
    assertEquals(attributeKvEntity, attributeKvEntity);
    int expectedHashCodeResult = attributeKvEntity.hashCode();
    assertEquals(expectedHashCodeResult, attributeKvEntity.hashCode());
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(false);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(0.5d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(3);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("Str Key");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue(null);
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(3L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(null);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(1L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("42");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey(null);
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("Str Key");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue(null);
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(3L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(null);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(1);
    id2.setAttributeType(1);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(true);
    attributeKvEntity2.setDoubleValue(10.0d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("42");
    attributeKvEntity2.setLastUpdateTs(1L);
    attributeKvEntity2.setLongValue(42L);
    attributeKvEntity2.setStrKey("Str Key");
    attributeKvEntity2.setStrValue("42");
    attributeKvEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, attributeKvEntity2);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, null);
  }

  /**
   * Test {@link AttributeKvEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvEntity.equals(Object)",
    "int AttributeKvEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(attributeKvEntity, "Different type to AttributeKvEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AttributeKvEntity}
   *   <li>{@link AttributeKvEntity#setBooleanValue(Boolean)}
   *   <li>{@link AttributeKvEntity#setDoubleValue(Double)}
   *   <li>{@link AttributeKvEntity#setId(AttributeKvCompositeKey)}
   *   <li>{@link AttributeKvEntity#setJsonValue(String)}
   *   <li>{@link AttributeKvEntity#setLastUpdateTs(Long)}
   *   <li>{@link AttributeKvEntity#setLongValue(Long)}
   *   <li>{@link AttributeKvEntity#setStrKey(String)}
   *   <li>{@link AttributeKvEntity#setStrValue(String)}
   *   <li>{@link AttributeKvEntity#setVersion(Long)}
   *   <li>{@link AttributeKvEntity#toString()}
   *   <li>{@link AttributeKvEntity#getBooleanValue()}
   *   <li>{@link AttributeKvEntity#getDoubleValue()}
   *   <li>{@link AttributeKvEntity#getId()}
   *   <li>{@link AttributeKvEntity#getJsonValue()}
   *   <li>{@link AttributeKvEntity#getLastUpdateTs()}
   *   <li>{@link AttributeKvEntity#getLongValue()}
   *   <li>{@link AttributeKvEntity#getStrKey()}
   *   <li>{@link AttributeKvEntity#getStrValue()}
   *   <li>{@link AttributeKvEntity#getVersion()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvEntity.<init>()",
    "Boolean AttributeKvEntity.getBooleanValue()",
    "Double AttributeKvEntity.getDoubleValue()",
    "AttributeKvCompositeKey AttributeKvEntity.getId()",
    "String AttributeKvEntity.getJsonValue()",
    "Long AttributeKvEntity.getLastUpdateTs()",
    "Long AttributeKvEntity.getLongValue()",
    "String AttributeKvEntity.getStrKey()",
    "String AttributeKvEntity.getStrValue()",
    "Long AttributeKvEntity.getVersion()",
    "void AttributeKvEntity.setBooleanValue(Boolean)",
    "void AttributeKvEntity.setDoubleValue(Double)",
    "void AttributeKvEntity.setId(AttributeKvCompositeKey)",
    "void AttributeKvEntity.setJsonValue(String)",
    "void AttributeKvEntity.setLastUpdateTs(Long)",
    "void AttributeKvEntity.setLongValue(Long)",
    "void AttributeKvEntity.setStrKey(String)",
    "void AttributeKvEntity.setStrValue(String)",
    "void AttributeKvEntity.setVersion(Long)",
    "String AttributeKvEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AttributeKvEntity actualAttributeKvEntity = new AttributeKvEntity();
    actualAttributeKvEntity.setBooleanValue(true);
    actualAttributeKvEntity.setDoubleValue(10.0d);
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);
    actualAttributeKvEntity.setId(id);
    actualAttributeKvEntity.setJsonValue("42");
    actualAttributeKvEntity.setLastUpdateTs(1L);
    actualAttributeKvEntity.setLongValue(42L);
    actualAttributeKvEntity.setStrKey("Str Key");
    actualAttributeKvEntity.setStrValue("42");
    actualAttributeKvEntity.setVersion(1L);
    String actualToStringResult = actualAttributeKvEntity.toString();
    Boolean actualBooleanValue = actualAttributeKvEntity.getBooleanValue();
    Double actualDoubleValue = actualAttributeKvEntity.getDoubleValue();
    AttributeKvCompositeKey actualId = actualAttributeKvEntity.getId();
    String actualJsonValue = actualAttributeKvEntity.getJsonValue();
    Long actualLastUpdateTs = actualAttributeKvEntity.getLastUpdateTs();
    Long actualLongValue = actualAttributeKvEntity.getLongValue();
    String actualStrKey = actualAttributeKvEntity.getStrKey();
    String actualStrValue = actualAttributeKvEntity.getStrValue();
    Long actualVersion = actualAttributeKvEntity.getVersion();

    // Assert
    assertEquals("42", actualJsonValue);
    assertEquals("42", actualStrValue);
    assertEquals(
        "AttributeKvEntity(id=AttributeKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, attributeType=1,"
            + " attributeKey=1), booleanValue=true, strValue=42, longValue=42, doubleValue=10.0, jsonValue=42,"
            + " lastUpdateTs=1, version=1, strKey=Str Key)",
        actualToStringResult);
    assertEquals("Str Key", actualStrKey);
    assertEquals(10.0d, actualDoubleValue.doubleValue(), 0.0);
    assertEquals(1L, actualLastUpdateTs.longValue());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(42L, actualLongValue.longValue());
    assertTrue(actualBooleanValue);
    assertSame(id, actualId);
  }
}
