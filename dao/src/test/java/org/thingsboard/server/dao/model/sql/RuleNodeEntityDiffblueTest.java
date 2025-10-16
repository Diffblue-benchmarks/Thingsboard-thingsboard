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
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class RuleNodeEntityDiffblueTest {
  /**
   * Test {@link RuleNodeEntity#equals(Object)}, and {@link RuleNodeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeEntity#equals(Object)}
   *   <li>{@link RuleNodeEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeEntity, ruleNodeEntity2);
    assertEquals(ruleNodeEntity.hashCode(), ruleNodeEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}, and {@link RuleNodeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeEntity#equals(Object)}
   *   <li>{@link RuleNodeEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(null);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(null);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeEntity, ruleNodeEntity2);
    assertEquals(ruleNodeEntity.hashCode(), ruleNodeEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}, and {@link RuleNodeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeEntity#equals(Object)}
   *   <li>{@link RuleNodeEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(null);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(null);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeEntity, ruleNodeEntity2);
    assertEquals(ruleNodeEntity.hashCode(), ruleNodeEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}, and {@link RuleNodeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeEntity#equals(Object)}
   *   <li>{@link RuleNodeEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(null);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(null);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeEntity, ruleNodeEntity2);
    assertEquals(ruleNodeEntity.hashCode(), ruleNodeEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}, and {@link RuleNodeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeEntity#equals(Object)}
   *   <li>{@link RuleNodeEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeEntity, ruleNodeEntity);
    int expectedHashCodeResult = ruleNodeEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeEntity.hashCode());
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(null);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(DoubleNode.valueOf(10.0d));
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(null);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(3);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(3L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(false);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(UUID.randomUUID());
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(null);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Type");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName(null);
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Type");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName(null);
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(UUID.randomUUID());
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(null);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(false);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Name");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType(null);
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(1);
    ruleNodeEntity2.setCreatedTime(1L);
    ruleNodeEntity2.setDebugMode(true);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("Name");
    ruleNodeEntity2.setQueueName("Queue Name");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(true);
    ruleNodeEntity2.setType("Type");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, ruleNodeEntity2);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, null);
  }

  /**
   * Test {@link RuleNodeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeEntity.equals(Object)", "int RuleNodeEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeEntity, "Different type to RuleNodeEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeEntity#RuleNodeEntity()}
   *   <li>{@link RuleNodeEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link RuleNodeEntity#setConfiguration(JsonNode)}
   *   <li>{@link RuleNodeEntity#setConfigurationVersion(int)}
   *   <li>{@link RuleNodeEntity#setDebugMode(boolean)}
   *   <li>{@link RuleNodeEntity#setExternalId(UUID)}
   *   <li>{@link RuleNodeEntity#setName(String)}
   *   <li>{@link RuleNodeEntity#setQueueName(String)}
   *   <li>{@link RuleNodeEntity#setRuleChainId(UUID)}
   *   <li>{@link RuleNodeEntity#setSingletonMode(boolean)}
   *   <li>{@link RuleNodeEntity#setType(String)}
   *   <li>{@link RuleNodeEntity#toString()}
   *   <li>{@link RuleNodeEntity#getAdditionalInfo()}
   *   <li>{@link RuleNodeEntity#getConfiguration()}
   *   <li>{@link RuleNodeEntity#getConfigurationVersion()}
   *   <li>{@link RuleNodeEntity#getExternalId()}
   *   <li>{@link RuleNodeEntity#getName()}
   *   <li>{@link RuleNodeEntity#getQueueName()}
   *   <li>{@link RuleNodeEntity#getRuleChainId()}
   *   <li>{@link RuleNodeEntity#getType()}
   *   <li>{@link RuleNodeEntity#isDebugMode()}
   *   <li>{@link RuleNodeEntity#isSingletonMode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleNodeEntity.<init>()",
    "JsonNode RuleNodeEntity.getAdditionalInfo()",
    "JsonNode RuleNodeEntity.getConfiguration()",
    "int RuleNodeEntity.getConfigurationVersion()",
    "UUID RuleNodeEntity.getExternalId()",
    "String RuleNodeEntity.getName()",
    "String RuleNodeEntity.getQueueName()",
    "UUID RuleNodeEntity.getRuleChainId()",
    "String RuleNodeEntity.getType()",
    "boolean RuleNodeEntity.isDebugMode()",
    "boolean RuleNodeEntity.isSingletonMode()",
    "void RuleNodeEntity.setAdditionalInfo(JsonNode)",
    "void RuleNodeEntity.setConfiguration(JsonNode)",
    "void RuleNodeEntity.setConfigurationVersion(int)",
    "void RuleNodeEntity.setDebugMode(boolean)",
    "void RuleNodeEntity.setExternalId(UUID)",
    "void RuleNodeEntity.setName(String)",
    "void RuleNodeEntity.setQueueName(String)",
    "void RuleNodeEntity.setRuleChainId(UUID)",
    "void RuleNodeEntity.setSingletonMode(boolean)",
    "void RuleNodeEntity.setType(String)",
    "String RuleNodeEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity();
    actualRuleNodeEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualRuleNodeEntity.setConfiguration(configuration);
    actualRuleNodeEntity.setConfigurationVersion(1);
    actualRuleNodeEntity.setDebugMode(true);
    actualRuleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    actualRuleNodeEntity.setName("Name");
    actualRuleNodeEntity.setQueueName("Queue Name");
    UUID ruleChainId = ModelConstants.NULL_UUID;
    actualRuleNodeEntity.setRuleChainId(ruleChainId);
    actualRuleNodeEntity.setSingletonMode(true);
    actualRuleNodeEntity.setType("Type");
    String actualToStringResult = actualRuleNodeEntity.toString();
    JsonNode actualAdditionalInfo = actualRuleNodeEntity.getAdditionalInfo();
    JsonNode actualConfiguration = actualRuleNodeEntity.getConfiguration();
    int actualConfigurationVersion = actualRuleNodeEntity.getConfigurationVersion();
    UUID actualExternalId = actualRuleNodeEntity.getExternalId();
    String actualName = actualRuleNodeEntity.getName();
    String actualQueueName = actualRuleNodeEntity.getQueueName();
    UUID actualRuleChainId = actualRuleNodeEntity.getRuleChainId();
    String actualType = actualRuleNodeEntity.getType();
    boolean actualIsDebugModeResult = actualRuleNodeEntity.isDebugMode();
    boolean actualIsSingletonModeResult = actualRuleNodeEntity.isSingletonMode();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Name", actualName);
    assertEquals("Queue Name", actualQueueName);
    assertEquals(
        "RuleNodeEntity(ruleChainId=13814000-1dd2-11b2-8080-808080808080, type=Type, name=Name, configurationVersion"
            + "=1, configuration={\"isPublic\":true}, additionalInfo={\"isPublic\":true}, debugMode=true, singletonMode=true,"
            + " queueName=Queue Name, externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertNull(actualRuleNodeEntity.getId());
    assertNull(actualRuleNodeEntity.getUuid());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertEquals(1, actualConfigurationVersion);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsSingletonModeResult);
    assertSame(configuration, actualAdditionalInfo);
    assertSame(configuration, actualConfiguration);
    assertSame(ruleChainId, actualExternalId);
    assertSame(ruleChainId, actualRuleChainId);
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  public void testNewRuleNodeEntity() {
    // Arrange
    RuleNode ruleNode = new RuleNode((RuleNodeId) null);
    ruleNode.setRuleChainId(null);
    ruleNode.setExternalId(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualRuleNodeEntity.getExternalId().toString());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  public void testNewRuleNodeEntity2() {
    // Arrange
    RuleNode ruleNode = new RuleNode((RuleNodeId) null);
    ruleNode.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    ruleNode.setExternalId(null);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualRuleNodeEntity.getRuleChainId().toString());
    assertNull(actualRuleNodeEntity.getExternalId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  public void testNewRuleNodeEntity_givenA() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return CreatedTime is three.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  public void testNewRuleNodeEntity_givenThree_thenReturnCreatedTimeIsThree() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setCreatedTime(3L);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(3L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link RuleNode#RuleNode()} DebugMode is {@code true}.
   *   <li>Then return DebugMode.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  public void testNewRuleNodeEntity_givenTrue_whenRuleNodeDebugModeIsTrue_thenReturnDebugMode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertTrue(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  public void testNewRuleNodeEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(new RuleNode(new RuleNode()));

    // Assert
    JsonNode additionalInfo = actualRuleNodeEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertSame(additionalInfo, actualRuleNodeEntity.getConfiguration());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  public void testNewRuleNodeEntity_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNodeId(ModelConstants.NULL_UUID));
    ruleNode.setRuleChainId(null);
    ruleNode.setExternalId(null);

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    UUID id = actualRuleNodeEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualRuleNodeEntity.getAdditionalInfo());
    assertNull(actualRuleNodeEntity.getConfiguration());
    assertSame(id, actualRuleNodeEntity.getUuid());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>When {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link
   *       RuleNode#RuleNode(RuleNode)}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  public void testNewRuleNodeEntity_whenRuleNodeWithRuleNodeIsRuleNode() {
    // Arrange
    RuleNode ruleNode = new RuleNode(new RuleNode(new RuleNode()));

    // Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(ruleNode);

    // Assert
    JsonNode additionalInfo = actualRuleNodeEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertSame(additionalInfo, actualRuleNodeEntity.getConfiguration());
  }

  /**
   * Test {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}.
   *
   * <ul>
   *   <li>When {@link RuleNode#RuleNode()}.
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#RuleNodeEntity(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeEntity.<init>(RuleNode)"})
  public void testNewRuleNodeEntity_whenRuleNode_thenReturnExternalIdIsNull() {
    // Arrange and Act
    RuleNodeEntity actualRuleNodeEntity = new RuleNodeEntity(new RuleNode());

    // Assert
    assertNull(actualRuleNodeEntity.getExternalId());
    assertNull(actualRuleNodeEntity.getRuleChainId());
    assertEquals(0L, actualRuleNodeEntity.getCreatedTime());
    assertFalse(actualRuleNodeEntity.isDebugMode());
  }

  /**
   * Test {@link RuleNodeEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeEntity#RuleNodeEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode RuleNodeEntity.toData()"})
  public void testToData_givenRuleNodeEntity_thenAdditionalInfoReturnNullNode()
      throws UnsupportedEncodingException {
    // Arrange and Act
    RuleNode actualToDataResult = new RuleNodeEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getQueueName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    assertEquals(0, actualToDataResult.getConfigurationVersion());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDebugMode());
    assertFalse(actualToDataResult.isSingletonMode());
    assertArrayEquals("null".getBytes("UTF-8"), actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNodeEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code RULE_NODE}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode RuleNodeEntity.toData()"})
  public void testToData_thenReturnExternalIdEntityTypeIsRuleNode()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);
    ruleNodeEntity.setRuleChainId(null);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    RuleNode actualToDataResult = ruleNodeEntity.toData();

    // Assert
    RuleNodeId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.RULE_NODE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"), actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleNodeEntity#toData()}.
   *
   * <ul>
   *   <li>Then return RuleChainId EntityType is {@code RULE_CHAIN}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode RuleNodeEntity.toData()"})
  public void testToData_thenReturnRuleChainIdEntityTypeIsRuleChain()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setExternalId(null);

    // Act
    RuleNode actualToDataResult = ruleNodeEntity.toData();

    // Assert
    RuleChainId ruleChainId = actualToDataResult.getRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    assertTrue(actualToDataResult.getId().isNullUid());
    assertTrue(ruleChainId.isNullUid());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"), actualToDataResult.getConfigurationBytes());
  }
}
