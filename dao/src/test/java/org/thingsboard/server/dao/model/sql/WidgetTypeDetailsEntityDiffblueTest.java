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

import static org.junit.Assert.assertArrayEquals;
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
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetTypeDetailsEntityDiffblueTest {
  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}, and {@link
   * WidgetTypeDetailsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#equals(Object)}
   *   <li>{@link WidgetTypeDetailsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
    assertEquals(widgetTypeDetailsEntity.hashCode(), widgetTypeDetailsEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}, and {@link
   * WidgetTypeDetailsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#equals(Object)}
   *   <li>{@link WidgetTypeDetailsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription(null);
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription(null);
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
    assertEquals(widgetTypeDetailsEntity.hashCode(), widgetTypeDetailsEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}, and {@link
   * WidgetTypeDetailsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#equals(Object)}
   *   <li>{@link WidgetTypeDetailsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(null);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(null);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
    assertEquals(widgetTypeDetailsEntity.hashCode(), widgetTypeDetailsEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}, and {@link
   * WidgetTypeDetailsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#equals(Object)}
   *   <li>{@link WidgetTypeDetailsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(null);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(null);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
    assertEquals(widgetTypeDetailsEntity.hashCode(), widgetTypeDetailsEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}, and {@link
   * WidgetTypeDetailsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#equals(Object)}
   *   <li>{@link WidgetTypeDetailsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity);
    int expectedHashCodeResult = widgetTypeDetailsEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetailsEntity.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(3L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("Fqn");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription(null);
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(DoubleNode.valueOf(10.0d));
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(null);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.randomUUID());
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(null);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Fqn");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage(null);
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(null);
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, null);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, "Different type to WidgetTypeDetailsEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()}
   *   <li>{@link WidgetTypeDetailsEntity#setDescription(String)}
   *   <li>{@link WidgetTypeDetailsEntity#setDescriptor(JsonNode)}
   *   <li>{@link WidgetTypeDetailsEntity#setExternalId(UUID)}
   *   <li>{@link WidgetTypeDetailsEntity#setImage(String)}
   *   <li>{@link WidgetTypeDetailsEntity#setTags(String[])}
   *   <li>{@link WidgetTypeDetailsEntity#toString()}
   *   <li>{@link WidgetTypeDetailsEntity#getDescription()}
   *   <li>{@link WidgetTypeDetailsEntity#getDescriptor()}
   *   <li>{@link WidgetTypeDetailsEntity#getExternalId()}
   *   <li>{@link WidgetTypeDetailsEntity#getImage()}
   *   <li>{@link WidgetTypeDetailsEntity#getTags()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeDetailsEntity.<init>()",
    "String WidgetTypeDetailsEntity.getDescription()",
    "JsonNode WidgetTypeDetailsEntity.getDescriptor()",
    "UUID WidgetTypeDetailsEntity.getExternalId()",
    "String WidgetTypeDetailsEntity.getImage()",
    "String[] WidgetTypeDetailsEntity.getTags()",
    "void WidgetTypeDetailsEntity.setDescription(String)",
    "void WidgetTypeDetailsEntity.setDescriptor(JsonNode)",
    "void WidgetTypeDetailsEntity.setExternalId(UUID)",
    "void WidgetTypeDetailsEntity.setImage(String)",
    "void WidgetTypeDetailsEntity.setTags(String[])",
    "String WidgetTypeDetailsEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    actualWidgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualWidgetTypeDetailsEntity.setDescriptor(descriptor);
    UUID externalId = ModelConstants.NULL_UUID;
    actualWidgetTypeDetailsEntity.setExternalId(externalId);
    actualWidgetTypeDetailsEntity.setImage("Image");
    String[] tags = new String[] {"Tags"};
    actualWidgetTypeDetailsEntity.setTags(tags);
    String actualToStringResult = actualWidgetTypeDetailsEntity.toString();
    String actualDescription = actualWidgetTypeDetailsEntity.getDescription();
    JsonNode actualDescriptor = actualWidgetTypeDetailsEntity.getDescriptor();
    UUID actualExternalId = actualWidgetTypeDetailsEntity.getExternalId();
    String actualImage = actualWidgetTypeDetailsEntity.getImage();
    String[] actualTags = actualWidgetTypeDetailsEntity.getTags();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(
        "WidgetTypeDetailsEntity(image=Image, description=The characteristics of someone or something, tags=[Tags],"
            + " descriptor={\"isPublic\":true}, externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertNull(actualWidgetTypeDetailsEntity.getVersion());
    assertNull(actualWidgetTypeDetailsEntity.getFqn());
    assertNull(actualWidgetTypeDetailsEntity.getName());
    assertNull(actualWidgetTypeDetailsEntity.getId());
    assertNull(actualWidgetTypeDetailsEntity.getUuid());
    assertNull(actualWidgetTypeDetailsEntity.getTenantId());
    assertEquals(0L, actualWidgetTypeDetailsEntity.getCreatedTime());
    assertFalse(actualWidgetTypeDetailsEntity.isDeprecated());
    assertFalse(actualWidgetTypeDetailsEntity.isScada());
    assertSame(tags, actualTags);
    assertSame(descriptor, actualDescriptor);
    assertSame(externalId, actualExternalId);
    assertArrayEquals(new String[] {"Tags"}, actualTags);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}.
   *
   * <p>Method under test: {@link
   * WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDetailsEntity.<init>(WidgetTypeDetails)"})
  public void testNewWidgetTypeDetailsEntity() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setExternalId(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity =
        new WidgetTypeDetailsEntity(widgetTypeDetails);

    // Assert
    UUID externalId = actualWidgetTypeDetailsEntity.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.toString());
    assertNull(actualWidgetTypeDetailsEntity.getTenantId());
    assertSame(externalId, actualWidgetTypeDetailsEntity.getId());
    assertSame(externalId, actualWidgetTypeDetailsEntity.getUuid());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}.
   *
   * <p>Method under test: {@link
   * WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDetailsEntity.<init>(WidgetTypeDetails)"})
  public void testNewWidgetTypeDetailsEntity2() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity =
        new WidgetTypeDetailsEntity(widgetTypeDetails);

    // Assert
    UUID id = actualWidgetTypeDetailsEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualWidgetTypeDetailsEntity.getTenantId().toString());
    assertNull(actualWidgetTypeDetailsEntity.getExternalId());
    assertSame(id, actualWidgetTypeDetailsEntity.getUuid());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}.
   *
   * <ul>
   *   <li>When {@link WidgetTypeDetails#WidgetTypeDetails()}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDetailsEntity.<init>(WidgetTypeDetails)"})
  public void testNewWidgetTypeDetailsEntity_whenWidgetTypeDetails_thenReturnIdIsNull() {
    // Arrange and Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity =
        new WidgetTypeDetailsEntity(new WidgetTypeDetails());

    // Assert
    assertNull(actualWidgetTypeDetailsEntity.getId());
    assertNull(actualWidgetTypeDetailsEntity.getUuid());
    assertNull(actualWidgetTypeDetailsEntity.getTenantId());
    assertNull(actualWidgetTypeDetailsEntity.getExternalId());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeDetailsEntity.toData()"})
  public void testToData_givenWidgetTypeDetailsEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    WidgetTypeDetails actualToDataResult = widgetTypeDetailsEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualToDataResult.getFqn());
    assertEquals("Image", actualToDataResult.getImage());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(
        "The characteristics of someone or something", actualToDataResult.getDescription());
    assertEquals(1, actualToDataResult.getTags().length);
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isDeprecated());
    assertTrue(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeDetailsEntity.toData()"})
  public void testToData_givenWidgetTypeDetailsEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.randomUUID());
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    WidgetTypeDetails actualToDataResult = widgetTypeDetailsEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualToDataResult.getFqn());
    assertEquals("Image", actualToDataResult.getImage());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(
        "The characteristics of someone or something", actualToDataResult.getDescription());
    assertEquals(1, actualToDataResult.getTags().length);
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isDeprecated());
    assertTrue(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()}.
   *   <li>Then return Descriptor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeDetailsEntity.toData()"})
  public void testToData_givenWidgetTypeDetailsEntity_thenReturnDescriptorIsNull() {
    // Arrange and Act
    WidgetTypeDetails actualToDataResult = new WidgetTypeDetailsEntity().toData();

    // Assert
    assertNull(actualToDataResult.getDescriptor());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getFqn());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getTags());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getExternalId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDeprecated());
    assertFalse(actualToDataResult.isScada());
  }
}
