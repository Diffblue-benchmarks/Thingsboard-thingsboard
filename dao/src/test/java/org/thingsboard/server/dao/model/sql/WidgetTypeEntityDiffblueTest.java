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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.widget.WidgetType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetTypeEntityDiffblueTest {
  /**
   * Test {@link WidgetTypeEntity#equals(Object)}, and {@link WidgetTypeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeEntity#equals(Object)}
   *   <li>{@link WidgetTypeEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeEntity.equals(Object)", "int WidgetTypeEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    WidgetTypeEntity widgetTypeEntity2 = new WidgetTypeEntity();
    widgetTypeEntity2.setCreatedTime(1L);
    widgetTypeEntity2.setDeprecated(true);
    widgetTypeEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity2.setFqn("Fqn");
    widgetTypeEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setName("Name");
    widgetTypeEntity2.setScada(true);
    widgetTypeEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeEntity, widgetTypeEntity2);
    assertEquals(widgetTypeEntity.hashCode(), widgetTypeEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}, and {@link WidgetTypeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeEntity#equals(Object)}
   *   <li>{@link WidgetTypeEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeEntity.equals(Object)", "int WidgetTypeEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(null);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    WidgetTypeEntity widgetTypeEntity2 = new WidgetTypeEntity();
    widgetTypeEntity2.setCreatedTime(1L);
    widgetTypeEntity2.setDeprecated(true);
    widgetTypeEntity2.setDescriptor(null);
    widgetTypeEntity2.setFqn("Fqn");
    widgetTypeEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setName("Name");
    widgetTypeEntity2.setScada(true);
    widgetTypeEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeEntity, widgetTypeEntity2);
    assertEquals(widgetTypeEntity.hashCode(), widgetTypeEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}, and {@link WidgetTypeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeEntity#equals(Object)}
   *   <li>{@link WidgetTypeEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeEntity.equals(Object)", "int WidgetTypeEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeEntity, widgetTypeEntity);
    int expectedHashCodeResult = widgetTypeEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeEntity.hashCode());
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeEntity.equals(Object)", "int WidgetTypeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(3L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    WidgetTypeEntity widgetTypeEntity2 = new WidgetTypeEntity();
    widgetTypeEntity2.setCreatedTime(1L);
    widgetTypeEntity2.setDeprecated(true);
    widgetTypeEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity2.setFqn("Fqn");
    widgetTypeEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setName("Name");
    widgetTypeEntity2.setScada(true);
    widgetTypeEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, widgetTypeEntity2);
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeEntity.equals(Object)", "int WidgetTypeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(DoubleNode.valueOf(10.0d));
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    WidgetTypeEntity widgetTypeEntity2 = new WidgetTypeEntity();
    widgetTypeEntity2.setCreatedTime(1L);
    widgetTypeEntity2.setDeprecated(true);
    widgetTypeEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity2.setFqn("Fqn");
    widgetTypeEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setName("Name");
    widgetTypeEntity2.setScada(true);
    widgetTypeEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, widgetTypeEntity2);
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeEntity.equals(Object)", "int WidgetTypeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(null);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    WidgetTypeEntity widgetTypeEntity2 = new WidgetTypeEntity();
    widgetTypeEntity2.setCreatedTime(1L);
    widgetTypeEntity2.setDeprecated(true);
    widgetTypeEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity2.setFqn("Fqn");
    widgetTypeEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setName("Name");
    widgetTypeEntity2.setScada(true);
    widgetTypeEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, widgetTypeEntity2);
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeEntity.equals(Object)", "int WidgetTypeEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, null);
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WidgetTypeEntity.equals(Object)", "int WidgetTypeEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, "Different type to WidgetTypeEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link WidgetTypeEntity}
   *   <li>{@link WidgetTypeEntity#setDescriptor(JsonNode)}
   *   <li>{@link WidgetTypeEntity#toString()}
   *   <li>{@link WidgetTypeEntity#getDescriptor()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeEntity.<init>()",
    "JsonNode WidgetTypeEntity.getDescriptor()",
    "void WidgetTypeEntity.setDescriptor(JsonNode)",
    "String WidgetTypeEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeEntity actualWidgetTypeEntity = new WidgetTypeEntity();
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualWidgetTypeEntity.setDescriptor(descriptor);
    String actualToStringResult = actualWidgetTypeEntity.toString();
    JsonNode actualDescriptor = actualWidgetTypeEntity.getDescriptor();

    // Assert
    assertEquals("WidgetTypeEntity(descriptor={\"isPublic\":true})", actualToStringResult);
    assertNull(actualWidgetTypeEntity.getVersion());
    assertNull(actualWidgetTypeEntity.getFqn());
    assertNull(actualWidgetTypeEntity.getName());
    assertNull(actualWidgetTypeEntity.getId());
    assertNull(actualWidgetTypeEntity.getUuid());
    assertNull(actualWidgetTypeEntity.getTenantId());
    assertEquals(0L, actualWidgetTypeEntity.getCreatedTime());
    assertFalse(actualWidgetTypeEntity.isDeprecated());
    assertFalse(actualWidgetTypeEntity.isScada());
    assertSame(descriptor, actualDescriptor);
  }

  /**
   * Test {@link WidgetTypeEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeEntity} (default constructor) TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetType WidgetTypeEntity.toData()"})
  public void testToData_givenWidgetTypeEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act
    WidgetType actualToDataResult = widgetTypeEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualToDataResult.getFqn());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isDeprecated());
    assertTrue(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetTypeEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeEntity} (default constructor) TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetType WidgetTypeEntity.toData()"})
  public void testToData_givenWidgetTypeEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    widgetTypeEntity.setTenantId(UUID.randomUUID());

    // Act
    WidgetType actualToDataResult = widgetTypeEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualToDataResult.getFqn());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isDeprecated());
    assertTrue(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetTypeEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeEntity} (default constructor).
   *   <li>Then return Descriptor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetType WidgetTypeEntity.toData()"})
  public void testToData_givenWidgetTypeEntity_thenReturnDescriptorIsNull() {
    // Arrange and Act
    WidgetType actualToDataResult = new WidgetTypeEntity().toData();

    // Assert
    assertNull(actualToDataResult.getDescriptor());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getFqn());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    WidgetTypeId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(id.isNullUid());
    assertFalse(actualToDataResult.isDeprecated());
    assertFalse(actualToDataResult.isScada());
  }
}
