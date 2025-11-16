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
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.ComponentDescriptorId;
import org.thingsboard.server.common.data.plugin.ComponentClusteringMode;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentScope;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class ComponentDescriptorEntityDiffblueTest {
  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}, and {@link
   * ComponentDescriptorEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptorEntity#equals(Object)}
   *   <li>{@link ComponentDescriptorEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(componentDescriptorEntity, componentDescriptorEntity2);
    assertEquals(componentDescriptorEntity.hashCode(), componentDescriptorEntity2.hashCode());
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}, and {@link
   * ComponentDescriptorEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptorEntity#equals(Object)}
   *   <li>{@link ComponentDescriptorEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions(null);
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions(null);
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(componentDescriptorEntity, componentDescriptorEntity2);
    assertEquals(componentDescriptorEntity.hashCode(), componentDescriptorEntity2.hashCode());
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}, and {@link
   * ComponentDescriptorEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptorEntity#equals(Object)}
   *   <li>{@link ComponentDescriptorEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz(null);
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz(null);
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(componentDescriptorEntity, componentDescriptorEntity2);
    assertEquals(componentDescriptorEntity.hashCode(), componentDescriptorEntity2.hashCode());
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}, and {@link
   * ComponentDescriptorEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptorEntity#equals(Object)}
   *   <li>{@link ComponentDescriptorEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(null);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(null);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(componentDescriptorEntity, componentDescriptorEntity2);
    assertEquals(componentDescriptorEntity.hashCode(), componentDescriptorEntity2.hashCode());
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}, and {@link
   * ComponentDescriptorEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptorEntity#equals(Object)}
   *   <li>{@link ComponentDescriptorEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(null);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(null);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(componentDescriptorEntity, componentDescriptorEntity2);
    assertEquals(componentDescriptorEntity.hashCode(), componentDescriptorEntity2.hashCode());
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}, and {@link
   * ComponentDescriptorEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptorEntity#equals(Object)}
   *   <li>{@link ComponentDescriptorEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(componentDescriptorEntity, componentDescriptorEntity);
    int expectedHashCodeResult = componentDescriptorEntity.hashCode();
    assertEquals(expectedHashCodeResult, componentDescriptorEntity.hashCode());
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Name");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions(null);
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Name");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz(null);
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(null);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.ENABLED);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(DoubleNode.valueOf(10.0d));
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(null);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(3);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(3L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(false);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Clazz");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName(null);
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(null);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.TENANT);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(null);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.FILTER);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    ComponentDescriptorEntity componentDescriptorEntity2 = new ComponentDescriptorEntity();
    componentDescriptorEntity2.setActions("Actions");
    componentDescriptorEntity2.setClazz("Clazz");
    componentDescriptorEntity2.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity2.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity2.setConfigurationVersion(1);
    componentDescriptorEntity2.setCreatedTime(1L);
    componentDescriptorEntity2.setHasQueueName(true);
    componentDescriptorEntity2.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity2.setName("Name");
    componentDescriptorEntity2.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity2.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, componentDescriptorEntity2);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, null);
  }

  /**
   * Test {@link ComponentDescriptorEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ComponentDescriptorEntity.equals(Object)",
    "int ComponentDescriptorEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ComponentDescriptorEntity componentDescriptorEntity = new ComponentDescriptorEntity();
    componentDescriptorEntity.setActions("Actions");
    componentDescriptorEntity.setClazz("Clazz");
    componentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    componentDescriptorEntity.setConfigurationDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    componentDescriptorEntity.setConfigurationVersion(1);
    componentDescriptorEntity.setCreatedTime(1L);
    componentDescriptorEntity.setHasQueueName(true);
    componentDescriptorEntity.setId(ModelConstants.NULL_UUID);
    componentDescriptorEntity.setName("Name");
    componentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    componentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    componentDescriptorEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(componentDescriptorEntity, "Different type to ComponentDescriptorEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComponentDescriptorEntity#ComponentDescriptorEntity()}
   *   <li>{@link ComponentDescriptorEntity#setActions(String)}
   *   <li>{@link ComponentDescriptorEntity#setClazz(String)}
   *   <li>{@link ComponentDescriptorEntity#setClusteringMode(ComponentClusteringMode)}
   *   <li>{@link ComponentDescriptorEntity#setConfigurationDescriptor(JsonNode)}
   *   <li>{@link ComponentDescriptorEntity#setConfigurationVersion(int)}
   *   <li>{@link ComponentDescriptorEntity#setHasQueueName(boolean)}
   *   <li>{@link ComponentDescriptorEntity#setName(String)}
   *   <li>{@link ComponentDescriptorEntity#setScope(ComponentScope)}
   *   <li>{@link ComponentDescriptorEntity#setType(ComponentType)}
   *   <li>{@link ComponentDescriptorEntity#toString()}
   *   <li>{@link ComponentDescriptorEntity#getActions()}
   *   <li>{@link ComponentDescriptorEntity#getClazz()}
   *   <li>{@link ComponentDescriptorEntity#getClusteringMode()}
   *   <li>{@link ComponentDescriptorEntity#getConfigurationDescriptor()}
   *   <li>{@link ComponentDescriptorEntity#getConfigurationVersion()}
   *   <li>{@link ComponentDescriptorEntity#getName()}
   *   <li>{@link ComponentDescriptorEntity#getScope()}
   *   <li>{@link ComponentDescriptorEntity#getType()}
   *   <li>{@link ComponentDescriptorEntity#isHasQueueName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ComponentDescriptorEntity.<init>()",
    "String ComponentDescriptorEntity.getActions()",
    "String ComponentDescriptorEntity.getClazz()",
    "ComponentClusteringMode ComponentDescriptorEntity.getClusteringMode()",
    "JsonNode ComponentDescriptorEntity.getConfigurationDescriptor()",
    "int ComponentDescriptorEntity.getConfigurationVersion()",
    "String ComponentDescriptorEntity.getName()",
    "ComponentScope ComponentDescriptorEntity.getScope()",
    "ComponentType ComponentDescriptorEntity.getType()",
    "boolean ComponentDescriptorEntity.isHasQueueName()",
    "void ComponentDescriptorEntity.setActions(String)",
    "void ComponentDescriptorEntity.setClazz(String)",
    "void ComponentDescriptorEntity.setClusteringMode(ComponentClusteringMode)",
    "void ComponentDescriptorEntity.setConfigurationDescriptor(JsonNode)",
    "void ComponentDescriptorEntity.setConfigurationVersion(int)",
    "void ComponentDescriptorEntity.setHasQueueName(boolean)",
    "void ComponentDescriptorEntity.setName(String)",
    "void ComponentDescriptorEntity.setScope(ComponentScope)",
    "void ComponentDescriptorEntity.setType(ComponentType)",
    "String ComponentDescriptorEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ComponentDescriptorEntity actualComponentDescriptorEntity = new ComponentDescriptorEntity();
    actualComponentDescriptorEntity.setActions("Actions");
    actualComponentDescriptorEntity.setClazz("Clazz");
    actualComponentDescriptorEntity.setClusteringMode(ComponentClusteringMode.USER_PREFERENCE);
    JsonNode configurationDescriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualComponentDescriptorEntity.setConfigurationDescriptor(configurationDescriptor);
    actualComponentDescriptorEntity.setConfigurationVersion(1);
    actualComponentDescriptorEntity.setHasQueueName(true);
    actualComponentDescriptorEntity.setName("Name");
    actualComponentDescriptorEntity.setScope(ComponentScope.SYSTEM);
    actualComponentDescriptorEntity.setType(ComponentType.ENRICHMENT);
    String actualToStringResult = actualComponentDescriptorEntity.toString();
    String actualActions = actualComponentDescriptorEntity.getActions();
    String actualClazz = actualComponentDescriptorEntity.getClazz();
    ComponentClusteringMode actualClusteringMode =
        actualComponentDescriptorEntity.getClusteringMode();
    JsonNode actualConfigurationDescriptor =
        actualComponentDescriptorEntity.getConfigurationDescriptor();
    int actualConfigurationVersion = actualComponentDescriptorEntity.getConfigurationVersion();
    String actualName = actualComponentDescriptorEntity.getName();
    ComponentScope actualScope = actualComponentDescriptorEntity.getScope();
    ComponentType actualType = actualComponentDescriptorEntity.getType();
    boolean actualIsHasQueueNameResult = actualComponentDescriptorEntity.isHasQueueName();

    // Assert
    assertEquals("Actions", actualActions);
    assertEquals("Clazz", actualClazz);
    assertEquals(
        "ComponentDescriptorEntity(type=ENRICHMENT, scope=SYSTEM, clusteringMode=USER_PREFERENCE, name=Name,"
            + " clazz=Clazz, configurationDescriptor={\"isPublic\":true}, configurationVersion=1, actions=Actions,"
            + " hasQueueName=true)",
        actualToStringResult);
    assertEquals("Name", actualName);
    assertNull(actualComponentDescriptorEntity.getId());
    assertNull(actualComponentDescriptorEntity.getUuid());
    assertEquals(0L, actualComponentDescriptorEntity.getCreatedTime());
    assertEquals(1, actualConfigurationVersion);
    assertEquals(ComponentClusteringMode.USER_PREFERENCE, actualClusteringMode);
    assertEquals(ComponentScope.SYSTEM, actualScope);
    assertEquals(ComponentType.ENRICHMENT, actualType);
    assertTrue(actualIsHasQueueNameResult);
    assertSame(configurationDescriptor, actualConfigurationDescriptor);
  }

  /**
   * Test {@link ComponentDescriptorEntity#ComponentDescriptorEntity(ComponentDescriptor)}.
   *
   * <p>Method under test: {@link
   * ComponentDescriptorEntity#ComponentDescriptorEntity(ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComponentDescriptorEntity.<init>(ComponentDescriptor)"})
  public void testNewComponentDescriptorEntity() {
    // Arrange
    ComponentDescriptor component =
        new ComponentDescriptor(new ComponentDescriptorId(ModelConstants.NULL_UUID));

    // Act
    ComponentDescriptorEntity actualComponentDescriptorEntity =
        new ComponentDescriptorEntity(component);

    // Assert
    UUID id = actualComponentDescriptorEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualComponentDescriptorEntity.getConfigurationDescriptor());
    assertNull(actualComponentDescriptorEntity.getActions());
    assertNull(actualComponentDescriptorEntity.getClazz());
    assertNull(actualComponentDescriptorEntity.getName());
    assertNull(actualComponentDescriptorEntity.getClusteringMode());
    assertNull(actualComponentDescriptorEntity.getScope());
    assertNull(actualComponentDescriptorEntity.getType());
    assertEquals(0, actualComponentDescriptorEntity.getConfigurationVersion());
    assertEquals(0L, actualComponentDescriptorEntity.getCreatedTime());
    assertFalse(actualComponentDescriptorEntity.isHasQueueName());
    assertSame(id, actualComponentDescriptorEntity.getUuid());
  }

  /**
   * Test {@link ComponentDescriptorEntity#ComponentDescriptorEntity(ComponentDescriptor)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return CreatedTime is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ComponentDescriptorEntity#ComponentDescriptorEntity(ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComponentDescriptorEntity.<init>(ComponentDescriptor)"})
  public void testNewComponentDescriptorEntity_givenThree_thenReturnCreatedTimeIsThree() {
    // Arrange
    ComponentDescriptor component = new ComponentDescriptor();
    component.setCreatedTime(3L);

    // Act
    ComponentDescriptorEntity actualComponentDescriptorEntity =
        new ComponentDescriptorEntity(component);

    // Assert
    assertNull(actualComponentDescriptorEntity.getConfigurationDescriptor());
    assertNull(actualComponentDescriptorEntity.getActions());
    assertNull(actualComponentDescriptorEntity.getClazz());
    assertNull(actualComponentDescriptorEntity.getName());
    assertNull(actualComponentDescriptorEntity.getId());
    assertNull(actualComponentDescriptorEntity.getUuid());
    assertNull(actualComponentDescriptorEntity.getClusteringMode());
    assertNull(actualComponentDescriptorEntity.getScope());
    assertNull(actualComponentDescriptorEntity.getType());
    assertEquals(0, actualComponentDescriptorEntity.getConfigurationVersion());
    assertEquals(3L, actualComponentDescriptorEntity.getCreatedTime());
    assertFalse(actualComponentDescriptorEntity.isHasQueueName());
  }

  /**
   * Test {@link ComponentDescriptorEntity#ComponentDescriptorEntity(ComponentDescriptor)}.
   *
   * <ul>
   *   <li>When {@link ComponentDescriptor#ComponentDescriptor()}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ComponentDescriptorEntity#ComponentDescriptorEntity(ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComponentDescriptorEntity.<init>(ComponentDescriptor)"})
  public void testNewComponentDescriptorEntity_whenComponentDescriptor_thenReturnIdIsNull() {
    // Arrange and Act
    ComponentDescriptorEntity actualComponentDescriptorEntity =
        new ComponentDescriptorEntity(new ComponentDescriptor());

    // Assert
    assertNull(actualComponentDescriptorEntity.getConfigurationDescriptor());
    assertNull(actualComponentDescriptorEntity.getActions());
    assertNull(actualComponentDescriptorEntity.getClazz());
    assertNull(actualComponentDescriptorEntity.getName());
    assertNull(actualComponentDescriptorEntity.getId());
    assertNull(actualComponentDescriptorEntity.getUuid());
    assertNull(actualComponentDescriptorEntity.getClusteringMode());
    assertNull(actualComponentDescriptorEntity.getScope());
    assertNull(actualComponentDescriptorEntity.getType());
    assertEquals(0, actualComponentDescriptorEntity.getConfigurationVersion());
    assertEquals(0L, actualComponentDescriptorEntity.getCreatedTime());
    assertFalse(actualComponentDescriptorEntity.isHasQueueName());
  }

  /**
   * Test {@link ComponentDescriptorEntity#toData()}.
   *
   * <p>Method under test: {@link ComponentDescriptorEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ComponentDescriptor ComponentDescriptorEntity.toData()"})
  public void testToData() {
    // Arrange and Act
    ComponentDescriptor actualToDataResult = new ComponentDescriptorEntity().toData();

    // Assert
    assertNull(actualToDataResult.getConfigurationDescriptor());
    assertNull(actualToDataResult.getActions());
    assertNull(actualToDataResult.getClazz());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getClusteringMode());
    assertNull(actualToDataResult.getScope());
    assertNull(actualToDataResult.getType());
    assertEquals(0, actualToDataResult.getConfigurationVersion());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isHasQueueName());
  }
}
