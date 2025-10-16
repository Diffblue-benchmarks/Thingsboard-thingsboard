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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class RuleChainEntityDiffblueTest {
  /**
   * Test {@link RuleChainEntity#equals(Object)}, and {@link RuleChainEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainEntity#equals(Object)}
   *   <li>{@link RuleChainEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(ruleChainEntity, ruleChainEntity2);
    assertEquals(ruleChainEntity.hashCode(), ruleChainEntity2.hashCode());
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}, and {@link RuleChainEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainEntity#equals(Object)}
   *   <li>{@link RuleChainEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(null);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(null);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(ruleChainEntity, ruleChainEntity2);
    assertEquals(ruleChainEntity.hashCode(), ruleChainEntity2.hashCode());
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}, and {@link RuleChainEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainEntity#equals(Object)}
   *   <li>{@link RuleChainEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(null);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(null);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(ruleChainEntity, ruleChainEntity2);
    assertEquals(ruleChainEntity.hashCode(), ruleChainEntity2.hashCode());
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}, and {@link RuleChainEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainEntity#equals(Object)}
   *   <li>{@link RuleChainEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(null);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(null);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(ruleChainEntity, ruleChainEntity2);
    assertEquals(ruleChainEntity.hashCode(), ruleChainEntity2.hashCode());
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}, and {@link RuleChainEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainEntity#equals(Object)}
   *   <li>{@link RuleChainEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    // Act and Assert
    assertEquals(ruleChainEntity, ruleChainEntity);
    int expectedHashCodeResult = ruleChainEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainEntity.hashCode());
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(null);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(DoubleNode.valueOf(10.0d));
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(null);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(3L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(false);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(UUID.randomUUID());
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(null);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(UUID.randomUUID());
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(null);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName(null);
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("org.thingsboard.server.dao.model.sql.RuleChainEntity");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(false);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(UUID.randomUUID());
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(null);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(null);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.EDGE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(true);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, ruleChainEntity2);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, null);
  }

  /**
   * Test {@link RuleChainEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainEntity.equals(Object)", "int RuleChainEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChainEntity, "Different type to RuleChainEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainEntity#RuleChainEntity()}
   *   <li>{@link RuleChainEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link RuleChainEntity#setConfiguration(JsonNode)}
   *   <li>{@link RuleChainEntity#setDebugMode(boolean)}
   *   <li>{@link RuleChainEntity#setExternalId(UUID)}
   *   <li>{@link RuleChainEntity#setFirstRuleNodeId(UUID)}
   *   <li>{@link RuleChainEntity#setName(String)}
   *   <li>{@link RuleChainEntity#setRoot(boolean)}
   *   <li>{@link RuleChainEntity#setTenantId(UUID)}
   *   <li>{@link RuleChainEntity#setType(RuleChainType)}
   *   <li>{@link RuleChainEntity#toString()}
   *   <li>{@link RuleChainEntity#getAdditionalInfo()}
   *   <li>{@link RuleChainEntity#getConfiguration()}
   *   <li>{@link RuleChainEntity#getExternalId()}
   *   <li>{@link RuleChainEntity#getFirstRuleNodeId()}
   *   <li>{@link RuleChainEntity#getName()}
   *   <li>{@link RuleChainEntity#getTenantId()}
   *   <li>{@link RuleChainEntity#getType()}
   *   <li>{@link RuleChainEntity#isDebugMode()}
   *   <li>{@link RuleChainEntity#isRoot()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainEntity.<init>()",
    "JsonNode RuleChainEntity.getAdditionalInfo()",
    "JsonNode RuleChainEntity.getConfiguration()",
    "UUID RuleChainEntity.getExternalId()",
    "UUID RuleChainEntity.getFirstRuleNodeId()",
    "String RuleChainEntity.getName()",
    "UUID RuleChainEntity.getTenantId()",
    "RuleChainType RuleChainEntity.getType()",
    "boolean RuleChainEntity.isDebugMode()",
    "boolean RuleChainEntity.isRoot()",
    "void RuleChainEntity.setAdditionalInfo(JsonNode)",
    "void RuleChainEntity.setConfiguration(JsonNode)",
    "void RuleChainEntity.setDebugMode(boolean)",
    "void RuleChainEntity.setExternalId(UUID)",
    "void RuleChainEntity.setFirstRuleNodeId(UUID)",
    "void RuleChainEntity.setName(String)",
    "void RuleChainEntity.setRoot(boolean)",
    "void RuleChainEntity.setTenantId(UUID)",
    "void RuleChainEntity.setType(RuleChainType)",
    "String RuleChainEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity();
    actualRuleChainEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualRuleChainEntity.setConfiguration(configuration);
    actualRuleChainEntity.setDebugMode(true);
    actualRuleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    actualRuleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    actualRuleChainEntity.setName("Name");
    actualRuleChainEntity.setRoot(true);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualRuleChainEntity.setTenantId(tenantId);
    actualRuleChainEntity.setType(RuleChainType.CORE);
    String actualToStringResult = actualRuleChainEntity.toString();
    JsonNode actualAdditionalInfo = actualRuleChainEntity.getAdditionalInfo();
    JsonNode actualConfiguration = actualRuleChainEntity.getConfiguration();
    UUID actualExternalId = actualRuleChainEntity.getExternalId();
    UUID actualFirstRuleNodeId = actualRuleChainEntity.getFirstRuleNodeId();
    String actualName = actualRuleChainEntity.getName();
    UUID actualTenantId = actualRuleChainEntity.getTenantId();
    RuleChainType actualType = actualRuleChainEntity.getType();
    boolean actualIsDebugModeResult = actualRuleChainEntity.isDebugMode();
    boolean actualIsRootResult = actualRuleChainEntity.isRoot();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "RuleChainEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, type=CORE, firstRuleNodeId"
            + "=13814000-1dd2-11b2-8080-808080808080, root=true, debugMode=true, configuration={\"isPublic\":true},"
            + " additionalInfo={\"isPublic\":true}, externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertNull(actualRuleChainEntity.getVersion());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
    assertEquals(0L, actualRuleChainEntity.getCreatedTime());
    assertEquals(RuleChainType.CORE, actualType);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsRootResult);
    assertSame(configuration, actualAdditionalInfo);
    assertSame(configuration, actualConfiguration);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualFirstRuleNodeId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  public void testNewRuleChainEntity() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChain.setFirstRuleNodeId(null);
    ruleChain.setExternalId(null);
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    UUID id = actualRuleChainEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualRuleChainEntity.getTenantId().toString());
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertSame(id, actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  public void testNewRuleChainEntity2() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChain.setFirstRuleNodeId(null);
    ruleChain.setExternalId(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChain.setTenantId(null);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    UUID externalId = actualRuleChainEntity.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.toString());
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertSame(externalId, actualRuleChainEntity.getId());
    assertSame(externalId, actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  public void testNewRuleChainEntity3() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChain.setFirstRuleNodeId(new RuleNodeId(ModelConstants.NULL_UUID));
    ruleChain.setExternalId(null);
    ruleChain.setTenantId(null);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    UUID firstRuleNodeId = actualRuleChainEntity.getFirstRuleNodeId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", firstRuleNodeId.toString());
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertSame(firstRuleNodeId, actualRuleChainEntity.getId());
    assertSame(firstRuleNodeId, actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  public void testNewRuleChainEntity_givenA() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link RuleChain#RuleChain()} Root is {@code true}.
   *   <li>Then return Root.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  public void testNewRuleChainEntity_givenTrue_whenRuleChainRootIsTrue_thenReturnRoot() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
    assertTrue(actualRuleChainEntity.isRoot());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  public void testNewRuleChainEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(new RuleChain(new RuleChain()));

    // Assert
    JsonNode additionalInfo = actualRuleChainEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertSame(additionalInfo, actualRuleChainEntity.getConfiguration());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  public void testNewRuleChainEntity_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChain.setFirstRuleNodeId(null);
    ruleChain.setExternalId(null);
    ruleChain.setTenantId(null);

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    UUID id = actualRuleChainEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertSame(id, actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is {@link
   *       RuleChain#RuleChain(RuleChain)}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  public void testNewRuleChainEntity_whenRuleChainWithRuleChainIsRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChain(new RuleChain()));

    // Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(ruleChain);

    // Assert
    JsonNode additionalInfo = actualRuleChainEntity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertSame(additionalInfo, actualRuleChainEntity.getConfiguration());
  }

  /**
   * Test {@link RuleChainEntity#RuleChainEntity(RuleChain)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain()}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#RuleChainEntity(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainEntity.<init>(RuleChain)"})
  public void testNewRuleChainEntity_whenRuleChain_thenReturnIdIsNull() {
    // Arrange and Act
    RuleChainEntity actualRuleChainEntity = new RuleChainEntity(new RuleChain());

    // Assert
    assertNull(actualRuleChainEntity.getAdditionalInfo());
    assertNull(actualRuleChainEntity.getConfiguration());
    assertNull(actualRuleChainEntity.getId());
    assertNull(actualRuleChainEntity.getUuid());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link RuleChainEntity#RuleChainEntity()} TenantId is randomUUID.
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain RuleChainEntity.toData()"})
  public void testToData_givenRuleChainEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    ruleChainEntity.setFirstRuleNodeId(null);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    RuleChain actualToDataResult = ruleChainEntity.toData();

    // Assert
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"), actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link RuleChainEntity#RuleChainEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain RuleChainEntity.toData()"})
  public void testToData_givenRuleChainEntity_thenAdditionalInfoReturnNullNode()
      throws UnsupportedEncodingException {
    // Arrange and Act
    RuleChain actualToDataResult = new RuleChainEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDebugMode());
    assertFalse(actualToDataResult.isDefault());
    assertFalse(actualToDataResult.isRoot());
    assertArrayEquals("null".getBytes("UTF-8"), actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   *
   * <ul>
   *   <li>Then return FirstRuleNodeId EntityType is {@code RULE_NODE}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain RuleChainEntity.toData()"})
  public void testToData_thenReturnFirstRuleNodeIdEntityTypeIsRuleNode()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setExternalId(null);

    // Act
    RuleChain actualToDataResult = ruleChainEntity.toData();

    // Assert
    RuleNodeId firstRuleNodeId = actualToDataResult.getFirstRuleNodeId();
    assertEquals(EntityType.RULE_NODE, firstRuleNodeId.getEntityType());
    assertTrue(firstRuleNodeId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"), actualToDataResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChainEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain RuleChainEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    ruleChainEntity.setFirstRuleNodeId(null);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    RuleChain actualToDataResult = ruleChainEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"), actualToDataResult.getConfigurationBytes());
  }
}
