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
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;

public class TenantProfileEntityDiffblueTest {
  /**
   * Test {@link TenantProfileEntity#equals(Object)}, and {@link TenantProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEntity#equals(Object)}
   *   <li>{@link TenantProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tenantProfileEntity, tenantProfileEntity2);
    assertEquals(tenantProfileEntity.hashCode(), tenantProfileEntity2.hashCode());
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}, and {@link TenantProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEntity#equals(Object)}
   *   <li>{@link TenantProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription(null);
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription(null);
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tenantProfileEntity, tenantProfileEntity2);
    assertEquals(tenantProfileEntity.hashCode(), tenantProfileEntity2.hashCode());
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}, and {@link TenantProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEntity#equals(Object)}
   *   <li>{@link TenantProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName(null);
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName(null);
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tenantProfileEntity, tenantProfileEntity2);
    assertEquals(tenantProfileEntity.hashCode(), tenantProfileEntity2.hashCode());
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}, and {@link TenantProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEntity#equals(Object)}
   *   <li>{@link TenantProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(null);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(null);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tenantProfileEntity, tenantProfileEntity2);
    assertEquals(tenantProfileEntity.hashCode(), tenantProfileEntity2.hashCode());
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}, and {@link TenantProfileEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEntity#equals(Object)}
   *   <li>{@link TenantProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tenantProfileEntity, tenantProfileEntity);
    int expectedHashCodeResult = tenantProfileEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileEntity.hashCode());
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(3L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(false);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("Name");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription(null);
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(false);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("The characteristics of someone or something");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName(null);
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(DoubleNode.valueOf(10.0d));
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(null);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, null);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEntity.equals(Object)",
    "int TenantProfileEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, "Different type to TenantProfileEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEntity#TenantProfileEntity()}
   *   <li>{@link TenantProfileEntity#setDefault(boolean)}
   *   <li>{@link TenantProfileEntity#setDescription(String)}
   *   <li>{@link TenantProfileEntity#setIsolatedTbRuleEngine(boolean)}
   *   <li>{@link TenantProfileEntity#setName(String)}
   *   <li>{@link TenantProfileEntity#setProfileData(JsonNode)}
   *   <li>{@link TenantProfileEntity#toString()}
   *   <li>{@link TenantProfileEntity#getDescription()}
   *   <li>{@link TenantProfileEntity#getName()}
   *   <li>{@link TenantProfileEntity#getProfileData()}
   *   <li>{@link TenantProfileEntity#isDefault()}
   *   <li>{@link TenantProfileEntity#isIsolatedTbRuleEngine()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantProfileEntity.<init>()",
    "String TenantProfileEntity.getDescription()",
    "String TenantProfileEntity.getName()",
    "JsonNode TenantProfileEntity.getProfileData()",
    "boolean TenantProfileEntity.isDefault()",
    "boolean TenantProfileEntity.isIsolatedTbRuleEngine()",
    "void TenantProfileEntity.setDefault(boolean)",
    "void TenantProfileEntity.setDescription(String)",
    "void TenantProfileEntity.setIsolatedTbRuleEngine(boolean)",
    "void TenantProfileEntity.setName(String)",
    "void TenantProfileEntity.setProfileData(JsonNode)",
    "String TenantProfileEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity();
    actualTenantProfileEntity.setDefault(true);
    actualTenantProfileEntity.setDescription("The characteristics of someone or something");
    actualTenantProfileEntity.setIsolatedTbRuleEngine(true);
    actualTenantProfileEntity.setName("Name");
    JsonNode profileData = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualTenantProfileEntity.setProfileData(profileData);
    String actualToStringResult = actualTenantProfileEntity.toString();
    String actualDescription = actualTenantProfileEntity.getDescription();
    String actualName = actualTenantProfileEntity.getName();
    JsonNode actualProfileData = actualTenantProfileEntity.getProfileData();
    boolean actualIsDefaultResult = actualTenantProfileEntity.isDefault();
    boolean actualIsIsolatedTbRuleEngineResult = actualTenantProfileEntity.isIsolatedTbRuleEngine();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(
        "TenantProfileEntity(name=Name, description=The characteristics of someone or something, isDefault=true,"
            + " isolatedTbRuleEngine=true, profileData={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualTenantProfileEntity.getId());
    assertNull(actualTenantProfileEntity.getUuid());
    assertEquals(0L, actualTenantProfileEntity.getCreatedTime());
    assertTrue(actualIsDefaultResult);
    assertTrue(actualIsIsolatedTbRuleEngineResult);
    assertSame(profileData, actualProfileData);
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_givenA() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity(tenantProfile);

    // Assert
    assertNull(actualTenantProfileEntity.getDescription());
    assertNull(actualTenantProfileEntity.getName());
    JsonNode profileData = actualTenantProfileEntity.getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = profileData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2 instanceof NullNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_givenEmptyArrayOfByte() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[] {});

    // Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity(tenantProfile);

    // Assert
    assertNull(actualTenantProfileEntity.getDescription());
    assertNull(actualTenantProfileEntity.getName());
    JsonNode profileData = actualTenantProfileEntity.getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = profileData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2 instanceof NullNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return CreatedTime is three.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_givenThree_thenReturnCreatedTimeIsThree() {
    // Arrange
    TenantProfile tenantProfile = TenantProfileServiceTest.createTenantProfile("Name");
    tenantProfile.setCreatedTime(3L);

    // Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity(tenantProfile);

    // Assert
    JsonNode profileData = actualTenantProfileEntity.getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
    assertEquals("Name Test", actualTenantProfileEntity.getDescription());
    assertEquals("Name", actualTenantProfileEntity.getName());
    assertEquals(3L, actualTenantProfileEntity.getCreatedTime());
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return Default.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_givenTrue_thenReturnDefault() {
    // Arrange
    TenantProfile tenantProfile = TenantProfileServiceTest.createTenantProfile("Name");
    tenantProfile.setDefault(true);

    // Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity(tenantProfile);

    // Assert
    JsonNode profileData = actualTenantProfileEntity.getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
    assertEquals("Name Test", actualTenantProfileEntity.getDescription());
    assertEquals("Name", actualTenantProfileEntity.getName());
    assertTrue(actualTenantProfileEntity.isDefault());
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>When createTenantProfile {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_whenCreateTenantProfileName() {
    // Arrange and Act
    TenantProfileEntity actualTenantProfileEntity =
        new TenantProfileEntity(TenantProfileServiceTest.createTenantProfile("Name"));

    // Assert
    assertEquals("Name Test", actualTenantProfileEntity.getDescription());
    assertEquals("Name", actualTenantProfileEntity.getName());
    JsonNode profileData = actualTenantProfileEntity.getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = profileData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2 instanceof NullNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}.
   *
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.
   *   <li>Then return Description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileEntity.<init>(TenantProfile)"})
  public void testNewTenantProfileEntity_whenTenantProfile_thenReturnDescriptionIsNull() {
    // Arrange and Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity(new TenantProfile());

    // Assert
    assertNull(actualTenantProfileEntity.getDescription());
    assertNull(actualTenantProfileEntity.getName());
    JsonNode profileData = actualTenantProfileEntity.getProfileData();
    assertTrue(profileData instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = profileData.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2 instanceof NullNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(profileData.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link TenantProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileEntity#TenantProfileEntity()} ProfileData is Instance.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileEntity.toData()"})
  public void testToData_givenTenantProfileEntityProfileDataIsInstance() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setProfileData(MissingNode.getInstance());

    // Act
    TenantProfile actualToDataResult = tenantProfileEntity.toData();

    // Assert
    assertNull(actualToDataResult.getProfileDataBytes());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDefault());
    assertFalse(actualToDataResult.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link TenantProfileEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileEntity#TenantProfileEntity()}.
   *   <li>Then return ProfileDataBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileEntity.toData()"})
  public void testToData_givenTenantProfileEntity_thenReturnProfileDataBytesIsNull() {
    // Arrange and Act
    TenantProfile actualToDataResult = new TenantProfileEntity().toData();

    // Assert
    assertNull(actualToDataResult.getProfileDataBytes());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDefault());
    assertFalse(actualToDataResult.isIsolatedTbRuleEngine());
  }
}
